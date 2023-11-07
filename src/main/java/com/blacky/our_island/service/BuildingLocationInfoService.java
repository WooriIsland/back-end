package com.blacky.our_island.service;

import com.blacky.our_island.domain.BuildingLocationInfo;
import com.blacky.our_island.repository.BuildingLocationInfoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BuildingLocationInfoService {

    @Autowired
    private BuildingLocationInfoRepository buildingLocationInfoRepository;

    public List<BuildingLocationInfo> getAllBuildingLocationInfo() {
        return buildingLocationInfoRepository.findAll();
    }

    public BuildingLocationInfo getBuildingLocationInfoById(Long buildingId) {
        return buildingLocationInfoRepository.findById(buildingId).orElse(null);
    }

    public BuildingLocationInfo createBuildingLocationInfo(BuildingLocationInfo buildingLocationInfo) {
        return buildingLocationInfoRepository.save(buildingLocationInfo);
    }

    public BuildingLocationInfo updateBuildingLocationInfo(Long buildingId, BuildingLocationInfo updatedBuildingLocationInfo) {
        BuildingLocationInfo buildingLocationInfo = buildingLocationInfoRepository.findById(buildingId).orElse(null);
        if (buildingLocationInfo != null) {
            // 필요한 필드 업데이트
            return buildingLocationInfoRepository.save(buildingLocationInfo);
        }
        return null;
    }

    public void deleteBuildingLocationInfo(Long buildingId) {
        buildingLocationInfoRepository.deleteById(buildingId);
    }
}
