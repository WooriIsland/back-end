package com.blacky.our_island.service;

import com.blacky.our_island.domain.dto.token.LoginResponseDto;
import com.blacky.our_island.domain.dto.token.TokenDto;
import com.blacky.our_island.domain.dto.token.TokenRequestDto;
import com.blacky.our_island.domain.dto.user.*;
import com.blacky.our_island.domain.entity.RefreshToken;
import com.blacky.our_island.domain.entity.User;
import com.blacky.our_island.domain.entity.UserDml;
import com.blacky.our_island.exception.AppException;
import com.blacky.our_island.exception.ErrorCode;
import com.blacky.our_island.jwt.TokenProvider;
import com.blacky.our_island.repository.RefreshTokenRepository;
import com.blacky.our_island.repository.UserDmlRepository;
import com.blacky.our_island.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.core.Authentication;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class UserService {

    private final UserRepository userRepository;
    private final BCryptPasswordEncoder encoder;
    private final AuthenticationManagerBuilder authenticationManagerBuilder;
    private final TokenProvider tokenProvider;
    private final RefreshTokenRepository refreshTokenRepository;
    private final UserDmlRepository userDmlRepository;

    @Value("${jwt.token.secret}")
    private String secretKey;

    public UserDto join(UserJoinRequest userJoinRequest) {
        if (userRepository.existsByEmail(userJoinRequest.getEmail())) {
            throw new AppException(ErrorCode.DUPLICATED_USER_EMAIL);
        }

        User user = userRepository.save(userJoinRequest.toEntity(encoder.encode(userJoinRequest.getPassword())));
        System.out.println("user = " + user);
        return UserDto.of(user);
    }


    // 로그인시 엑세스, 리프레시 외에도 사용자 일부 정보 전달
    public LoginResponseDto login(UserLoginRequest userLoginRequest) {

        User user = userRepository.findByEmail(userLoginRequest.getEmail())
                .orElseThrow(() -> new AppException(ErrorCode.USER_NOT_FOUNDED));

        if (!encoder.matches(userLoginRequest.getPassword(), user.getPassword())) {
            throw new AppException(ErrorCode.INVALID_PASSWORD);
        }

        // 1. Login ID/PW 를 기반으로 AuthenticationToken 생성
        UsernamePasswordAuthenticationToken authenticationToken = userLoginRequest.authenticationToken();

        // 2. 실제로 검증 (사용자 비밀번호 체크) 이 이루어지는 부분
        //    authenticate 메서드가 실행이 될 때 CustomUserDetailsService 에서 만들었던 loadUserByUsername 메서드가 실행됨
        Authentication authentication = authenticationManagerBuilder.getObject().authenticate(authenticationToken);

        // 3. 인증 정보를 기반으로 JWT 토큰 생성
        TokenDto tokenDto = tokenProvider.generateTokenDto(authentication);

        RefreshToken refreshToken = RefreshToken.builder()
                .key(authentication.getName())
                .value(tokenDto.getRefreshToken())
                .build();
        refreshTokenRepository.save(refreshToken);



        // 5. 토큰 발급 및 Unity에서 요구하는 값 전달
        return LoginResponseDto.builder()
                .tokenDto(tokenDto)
                .userId(user.getUser_id())
                .nickname(user.getNickname())
                .character(user.getCharacter())
//                .islandUniqueNumber(user.getIsland().getIslandUniqueNumber())  // 추가된 부분
                .islandUniqueNumber(user.getIsland() != null ? user.getIsland().getIslandUniqueNumber() : null)
                .build();
    }




    @Transactional
    public TokenDto reissue(TokenRequestDto tokenRequestDto) {

        // 1. RefreshToken 검증
        if (!tokenProvider.validateToken(tokenRequestDto.getRefreshToken())) {
            throw new AppException(ErrorCode.INVALID_REFRESH_TOKEN);
        }

        // 2. AccessToken에서 Id 가져오기
        Authentication authentication = tokenProvider.getAuthentication(tokenRequestDto.getAccessToken());

        // 3. 저장소에서 id를 기반으로 RefreshToken 값 가져오기
        RefreshToken refreshToken = refreshTokenRepository.findByKey(authentication.getName())
                .orElseThrow(() -> new AppException(ErrorCode.LOGOUT_USER));

        // 4. RefreshToken이 일치 하는지 검사
        if (!refreshToken.getValue().equals(tokenRequestDto.getRefreshToken())) {
            throw new AppException(ErrorCode.TOKEN_NOT_MATCH);
        }

        // 5. 새로운 토큰 생성
        TokenDto tokenDto = tokenProvider.generateTokenDto(authentication);

        // 6. 정보 업데이트
        RefreshToken newRefreshToken = refreshToken.updateValue(tokenDto.getRefreshToken());
        refreshTokenRepository.save(newRefreshToken);

        return tokenDto;
    }

    // 정보 변경
    @Transactional
    public void editUserInfo(String password, String email) {
        User user = userRepository.findByEmail(email)
                .orElseThrow(() -> new AppException(ErrorCode.USER_NOT_FOUNDED));

        String changedPassword = user.getPassword();

        if (!password.equals("")) {
            changedPassword = encoder.encode(password);
        }

        user.updateUser(changedPassword);
        userRepository.save(user);
    }


    // 비밀번호 변경
    public void changePassword (String email, String newPassword) {
        User user = userRepository.findByEmail(email)
                .orElseThrow(() -> new AppException(ErrorCode.USER_NOT_FOUNDED));

        String encodedPassword = encoder.encode(newPassword);
        user.changePassword(encodedPassword);
        userRepository.save(user);
    }


    // 전체 조회, 단일 email 조회, 수정, 삭제 기능 추가



    public List<UserDto> getAllUsers() {
        return userRepository.findAll().stream()
                .map(UserDto::of)
                .collect(Collectors.toList());
    }

    public UserDto getUserByEmail(String email) {
        User user = userRepository.findByEmail(email)
                .orElseThrow(() -> new AppException(ErrorCode.USER_NOT_FOUNDED));
        return UserDto.of(user);
    }



    // IllegalArgumentException: rawPassword cannot be null 에러가 발생
    // updateUser 메소드에서 비밀번호를 수정하지 않는 경우에도 비밀번호 인코딩 로직이 실행되어서 문제가 발생
    // 사용자 정보 수정 요청에서 비밀번호가 제공되지 않은 경우에는 비밀번호 인코딩 로직을 건너뛰도록 코드 수정
    /*

    @Transactional
    public UserDto updateUser(String email, UserEditRequest userEditRequest) {
        User user = userRepository.findByEmail(email)
                .orElseThrow(() -> new AppException(ErrorCode.USER_NOT_FOUNDED));
        user.updateUser(
                userEditRequest.getEmail(),
                encoder.encode(userEditRequest.getPassword()),
                userEditRequest.getNickname(),
                userEditRequest.getCharacter()
                ,userEditRequest.getIslandId()
        );
        return UserDto.of(userRepository.save(user));
    }
    */

    @Transactional
    public UserDto updateUser(String email, UserEditRequest userEditRequest) {
        UserDml user = userDmlRepository.findByEmail(email)
                .orElseThrow(() -> new AppException(ErrorCode.USER_NOT_FOUNDED));

        user.setIslandId(userEditRequest.getIslandId());

        return UserDto.of(user);
    }



    @Transactional
    public void deleteUser(String email) {
        User user = userRepository.findByEmail(email)
                .orElseThrow(() -> new AppException(ErrorCode.USER_NOT_FOUNDED));
        userRepository.delete(user);
    }


    public List<UserByIslandIdDTO> getUsersByIslandId(Long islandId) {
        List<User> users = userRepository.findByIsland_IslandId(islandId);

        return users.stream()
                .map(user -> UserByIslandIdDTO.builder()
                        .nickname(user.getNickname())
                        .character(user.getCharacter())
                        .build())
                .collect(Collectors.toList());
    }


}
