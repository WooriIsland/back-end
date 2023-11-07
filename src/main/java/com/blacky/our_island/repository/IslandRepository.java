package com.blacky.our_island.repository;

import com.blacky.our_island.domain.Island;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IslandRepository extends JpaRepository<Island, Long> {
}
