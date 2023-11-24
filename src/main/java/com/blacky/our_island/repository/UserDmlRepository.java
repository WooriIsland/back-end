package com.blacky.our_island.repository;

import com.blacky.our_island.domain.entity.User;
import com.blacky.our_island.domain.entity.UserDml;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface UserDmlRepository extends JpaRepository<UserDml, Long> {
    Optional<UserDml> findByEmail(String email);
}
