package com.blacky.our_island.local;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/user1")
@Tag(name = "로컬 회원 가입 및 로그인", description = "로컬 회원 가입 및 로그인 API Document")
public class UserLocalController {

    @Autowired
    private UserLocalService userLocalService;

    @GetMapping
    @Operation(summary = "전체 사용자 조회", description = "전체 사용자 정보를 조회합니다.")
    public List<UserLocal> getAllUsers() {
        return userLocalService.getAllUsers();
    }

    @GetMapping("/{userId}")
    @Operation(summary = "사용자 정보 조회", description = "User Id 기반으로 사용자 정보를 조회합니다.")
    public UserLocal getUserById(@PathVariable Long userId) {
        return userLocalService.getUserById(userId);
    }

    @PostMapping
    @Operation(summary = "회원 등록", description = "회원을 등록합니다.")
    public UserLocal createUser(@RequestBody UserLocal userLocal) {
        return userLocalService.createUser(userLocal);
    }

    @PutMapping("/{userId}")
    @Operation(summary = "사용자 정보 수정", description = "사용자 정보를 수정합니다.")
    public UserLocal updateUser(@PathVariable Long userId, @RequestBody UserLocal updatedUserLocal) {
        return userLocalService.updateUser(userId, updatedUserLocal);
    }


    @DeleteMapping("/{userId}")
    @Operation(summary = "사용자 정보 삭제", description = "사용자 정보를 삭제합니다.")
    public String deleteUser(@PathVariable Long userId) {
        userLocalService.deleteUser(userId);
        return "ID가 " + userId + "인 사용자가 성공적으로 삭제되었습니다.";
    }
}
