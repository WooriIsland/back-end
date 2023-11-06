package com.blacky.our_island.repository;

import com.blacky.our_island.domain.BuildingLocationInfo;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BuildingLocationInfoRepository extends JpaRepository<BuildingLocationInfo, Long> {
}
