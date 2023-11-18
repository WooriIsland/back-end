package com.blacky.our_island.domain.enum_class;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public enum Role {
    GUEST,
    USER,
    BAN,
    ADMIN;
}