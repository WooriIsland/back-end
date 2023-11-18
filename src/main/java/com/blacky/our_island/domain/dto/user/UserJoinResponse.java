package com.blacky.our_island.domain.dto.user;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class UserJoinResponse {

    private String email;
    private String nickname;
    private String role;
    private String character;
    private Long islandId;

    public static UserJoinResponse of(UserDto userDto) {
        return UserJoinResponse.builder()
                .email(userDto.getEmail())
                .nickname(userDto.getNickname())
                .role(userDto.getRole())
                .character(userDto.getCharacter())
                .islandId(userDto.getIslandId())
                .build();
    }


}