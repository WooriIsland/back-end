package com.blacky.our_island.domain.dto.user;

import com.blacky.our_island.domain.entity.User;
import com.blacky.our_island.domain.enum_class.Role;
import lombok.AllArgsConstructor;
import lombok.Getter;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.crypto.password.PasswordEncoder;

@Getter
@AllArgsConstructor
public class UserLoginRequest {

    private String email;
    private String password;

    public User user(PasswordEncoder passwordEncoder) {
        return User.builder()
                .email(email)
                .password(passwordEncoder.encode(password))
                .role(Role.USER)
                .build();
    }

    public UsernamePasswordAuthenticationToken authenticationToken() {
        return new UsernamePasswordAuthenticationToken(email, password);
    }
}
