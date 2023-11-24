package com.blacky.our_island.domain.dto.user;

import com.blacky.our_island.domain.entity.User;
import com.blacky.our_island.domain.entity.UserDml;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class UserDto {

    private Long userId;
    private String email;
    private String password;
    private String nickname;
    private String character;
    private String role;
    private Long islandId;          // 주석해야 하는지?
    private String islandUniqueNumber;


    // 회원가입에서 문제가 발생.
    // 이 코드는 islandId값이 null이면 nullpointException 발생
/*
    public static UserDto of (User user) {
        return UserDto.builder()
                .userId(user.getUser_id())
                .email(user.getEmail())
                .password(user.getPassword())
                .nickname(user.getNickname())
                .role(user.getRole().name())
                .character(user.getCharacter())
                .islandId(user.getIsland().getIslandId())
                .build();
    }

 */

    // 회원가입에서 islandId값이 null이면 null전달하도록.
    public static UserDto of(User user) {

        Long islandId = null;
        String islandUniqueNumber = null;
        if (user.getIsland() != null) {
            islandId = user.getIsland().getIslandId();
            islandUniqueNumber = user.getIsland().getIslandUniqueNumber();
        }

        return UserDto.builder()
                .userId(user.getUser_id())
                .email(user.getEmail())
                .password(user.getPassword())
                .nickname(user.getNickname())
                .role(user.getRole().name())
                .character(user.getCharacter())
                .islandId(islandId)       // 수정된 부분
                .islandUniqueNumber(islandUniqueNumber)  // 추가된 부분
                .build();
    }

    // 회원 수정할 떄 조회용 UserDml 사용 로직
    public static UserDto of(UserDml user) {

        return UserDto.builder()
                .userId(user.getUser_id())
                .email(user.getEmail())
                .password(user.getPassword())
                .nickname(user.getNickname())
                .role(user.getRole().name())
                .character(user.getCharacter())
                .islandId(user.getIslandId())       // 수정된 부분
                .build();
    }

}