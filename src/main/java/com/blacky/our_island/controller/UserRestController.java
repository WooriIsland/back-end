package com.blacky.our_island.controller;

import com.blacky.our_island.domain.dto.EmailCode.CodeRequest;
import com.blacky.our_island.domain.dto.EmailCode.EmailRequest;
import com.blacky.our_island.domain.dto.token.LoginResponseDto;
import com.blacky.our_island.domain.dto.token.TokenDto;
import com.blacky.our_island.domain.dto.token.TokenRequestDto;
import com.blacky.our_island.domain.dto.user.*;
import com.blacky.our_island.exception.Response;
import com.blacky.our_island.service.EmailService;
import com.blacky.our_island.service.UserService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/api/v1/users")
@RequiredArgsConstructor
@Tag(name = "회원 가입 및 로그인", description = "회원 가입 및 로그인 API Document")
@Validated
public class UserRestController {

    private final UserService userService;
    private final EmailService emailService;


    @PostMapping("/join")
    @Operation(summary = "회원 등록", description = "회원을 등록합니다.")
    public Response<UserJoinResponse> join(@RequestBody @Valid UserJoinRequest userJoinRequest) {
        UserDto userDto = userService.join(userJoinRequest);
        return Response.success(UserJoinResponse.of(userDto));
    }

    //로그인시 엑세스와 리프레시 뿐만 아니라 일부 회원 정보도 반환
    @PostMapping("/login")
    @Operation(summary = "로그인", description = "로그인을 합니다.")
    public Response<LoginResponseDto> login(@RequestBody @Valid UserLoginRequest userLoginRequest) {
        return Response.success(userService.login(userLoginRequest));
    }


    @PostMapping("/reissue")
    @Operation(summary = "토큰 재발행", description = "토큰을 재발행합니다.")
    public Response<TokenDto> reissue(@RequestBody TokenRequestDto tokenRequestDto) {
        return Response.success(userService.reissue(tokenRequestDto));
    }

    // 인증 메일 보내기
//    @PostMapping("/send-auth-email")
//    @Operation(summary = "인증 메일 보내기", description = "인증 메일을 보냅니다.")
//    public Response<String> sendAuthEmail(@RequestParam String email) throws Exception {
//        System.out.println("email = " + email);
//        return Response.success(emailService.sendLoginAuthMessage(email));
//    }

    @PostMapping("/send-auth-email")
    @Operation(summary = "인증 메일 보내기", description = "인증 메일을 보냅니다.")
    public Response<String> sendAuthEmail(@RequestBody EmailRequest request) throws Exception {
        String email = request.getEmail();
        System.out.println("email = " + email);
        return Response.success(emailService.sendLoginAuthMessage(email));
    }


//    // 인증 메일 확인 하기
//    @PostMapping("/check-auth-email")
//    @Operation(summary = "인증 코드 확인하기", description = "인증 코드를 확인합니다.")
//    public Response<Boolean> checkAuthEmail(@RequestParam String code) {
//        System.out.println(code);
//        if (emailService.getData(code) == null) return Response.success(false);
//        else return Response.success(true);
//    }

    @PostMapping("/check-auth-email")
    @Operation(summary = "인증 코드 확인하기", description = "인증 코드를 확인합니다.")
    public Response<Boolean> checkAuthEmail(@RequestBody CodeRequest request) {
        String code = request.getCode();
        System.out.println(code);
        if (emailService.getData(code) == null) {
            return Response.success(false);
        } else {
            return Response.success(true);
        }
    }

    // 단일 조회, 전체 조회, 수정, 삭제 기능 추가

    @GetMapping
    @Operation(summary = "전체 사용자 조회", description = "전체 사용자 정보를 조회합니다.")
    public Response<List<UserDto>> getAllUsers() {
        return Response.success(userService.getAllUsers());
    }


    @GetMapping("/{email}")
    @Operation(summary = "사용자 정보 조회", description = "이메일을 기반으로 사용자 정보를 조회합니다.")
    public Response<UserDto> getUserByEmail(@PathVariable String email) {
        return Response.success(userService.getUserByEmail(email));
    }


    @PutMapping("/{email}")
    @Operation(summary = "사용자 정보 수정", description = "사용자 정보를 수정합니다.")
    public Response<UserDto> updateUser(@PathVariable String email, @RequestBody @Valid UserEditRequest userEditRequest) {
        return Response.success(userService.updateUser(email, userEditRequest));
    }


    @DeleteMapping("/{email}")
    @Operation(summary = "사용자 정보 삭제", description = "사용자 정보를 삭제합니다.")
    public Response<String> deleteUser(@PathVariable String email) {
        userService.deleteUser(email);
        return Response.success("Deleted user with email: " + email);
    }

    @GetMapping("/island/{islandId}")
    @Operation(summary = "섬 ID로 사용자 정보 조회", description = "섬 ID를 기반으로 사용자 정보를 조회합니다.")
    public Response<List<UserByIslandIdDTO>> getUsersByIslandId(@PathVariable Long islandId) {
        return Response.success(userService.getUsersByIslandId(islandId));
    }


}
