package com.blacky.our_island.service;

import com.blacky.our_island.domain.entity.User;
import com.blacky.our_island.exception.AppException;
import com.blacky.our_island.exception.ErrorCode;
import com.blacky.our_island.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Collections;

@Service
@RequiredArgsConstructor
public class CustomUserDetailsService implements UserDetailsService {

    private final UserRepository userRepository;

    @Override
    @Transactional
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        return userRepository.findByEmail(username)
                .map(this::createUserDetail)
                .orElseThrow(() -> new AppException(ErrorCode.USER_NOT_FOUNDED));
    }

    private UserDetails createUserDetail(User user) {
        GrantedAuthority grantedAuthority = new SimpleGrantedAuthority(user.getRole().toString());

        return new org.springframework.security.core.userdetails.User(
                String.valueOf(user.getUser_id()),
                user.getPassword(),
                Collections.singleton(grantedAuthority)
        );
    }
}
