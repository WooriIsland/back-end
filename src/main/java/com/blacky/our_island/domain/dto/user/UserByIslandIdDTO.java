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
public class UserByIslandIdDTO {

    private String nickname;
    private String character;

    public static UserByIslandIdDTO of(User user) {
        String nickname = user.getNickname();
        String character = user.getCharacter();

        return UserByIslandIdDTO.builder()
                .nickname(nickname)
                .character(character)
                .build();
    }
}
