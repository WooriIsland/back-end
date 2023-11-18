package com.blacky.our_island.domain.dto.user;

import com.blacky.our_island.domain.entity.User;
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
    private Long islandId;


    public static UserDto of (User user) {
        return UserDto.builder()
                .userId(user.getUser_id())
                .email(user.getEmail())
                .password(user.getPassword())
                .nickname(user.getNickname())
                .role(user.getRole().name())
                .character(user.getCharacter())
                .islandId(user.getIslandId())
                .build();
    }



}
