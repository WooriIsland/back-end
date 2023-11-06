package com.blacky.our_island.repository;

import com.blacky.our_island.domain.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Long> {
}