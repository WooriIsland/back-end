package com.blacky.our_island.exception;

import lombok.AllArgsConstructor;
import lombok.Getter;
import org.springframework.http.HttpStatus;

@Getter
@AllArgsConstructor
public enum ErrorCode {

    DATABASE_ERROR(HttpStatus.INTERNAL_SERVER_ERROR, "DB에러"),

    // 로그인
    USER_NOT_FOUNDED(HttpStatus.UNAUTHORIZED, "유저를 찾을 수 없습니다."),
    INVALID_PASSWORD(HttpStatus.UNAUTHORIZED, "패스워드가 잘못되었습니다."),

    // 회원가입
    DUPLICATED_USER_EMAIL(HttpStatus.CONFLICT, "User Email이 중복됩니다."),

    // 인증
    TOKEN_NOT_MATCH(HttpStatus.UNAUTHORIZED,"토큰의 유저 정보가 일치하지 않습니다"),
    INVALID_REFRESH_TOKEN(HttpStatus.UNAUTHORIZED, "Refresh Token이 유효하지 않습니다."),
    LOGOUT_USER(HttpStatus.UNAUTHORIZED, "로그아웃 된 사용자입니다."),

    // 인가
    INVALID_PERMISSION(HttpStatus.FORBIDDEN, "사용자가 권한이 없습니다."),

//    DUPLICATED_USER_NICKNAME(HttpStatus.CONFLICT, "User NickName이 중복됩니다."),
    DUPLICATED_ISLAND_UNIQUE_NUMBER(HttpStatus.CONFLICT, "island_unique_number이 중복됩니다."),

    ISLAND_NOT_FOUND(HttpStatus.BAD_REQUEST, "가족섬를 찾을 수 없습니다."),
    ;

    private HttpStatus status;
    private String message;
}


// 리소스를 찾을 수 없는 경우는 404에러 발생 O
// 하지만, 인증 관련에서만 404에러는 되도록 사용 X