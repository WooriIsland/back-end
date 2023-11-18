package com.blacky.our_island.domain.dto.token;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class LoginResponseDto {
    private TokenDto tokenDto;
    private Long userId;
    private String nickname;
    private String character;

}
