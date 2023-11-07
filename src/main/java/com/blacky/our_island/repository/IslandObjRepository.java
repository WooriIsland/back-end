package com.blacky.our_island.repository;

import com.blacky.our_island.domain.IslandObj;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IslandObjRepository extends JpaRepository<IslandObj, Long> {
}
