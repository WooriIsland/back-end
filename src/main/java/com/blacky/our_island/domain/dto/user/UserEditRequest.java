package com.blacky.our_island.domain.dto.user;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class UserEditRequest {

    private String password;
    // 추가
    private String email;
    private String nickname;
    private String character;
    private Long islandId;

}
