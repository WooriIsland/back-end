package com.blacky.our_island.controller;

import com.blacky.our_island.domain.BuildingLocationInfo;
import com.blacky.our_island.repository.BuildingLocationInfoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/building-location-info")
public class BuildingLocationInfoController {

    @Autowired
    private BuildingLocationInfoRepository buildingLocationInfoRepository;

    @GetMapping
    public List<BuildingLocationInfo> getAllBuildingLocationInfo() {
        return buildingLocationInfoRepository.findAll();
    }

    @GetMapping("/{buildingId}")
    public BuildingLocationInfo getBuildingLocationInfoById(@PathVariable Long buildingId) {
        return buildingLocationInfoRepository.findById(buildingId).orElse(null);
    }

    @PostMapping
    public BuildingLocationInfo createBuildingLocationInfo(@RequestBody BuildingLocationInfo buildingLocationInfo) {
        return buildingLocationInfoRepository.save(buildingLocationInfo);
    }

    @PutMapping("/{buildingId}")
    public BuildingLocationInfo updateBuildingLocationInfo(@PathVariable Long buildingId, @RequestBody BuildingLocationInfo updatedBuildingLocationInfo) {
        BuildingLocationInfo buildingLocationInfo = buildingLocationInfoRepository.findById(buildingId).orElse(null);
        if (buildingLocationInfo != null) {
            // Update fields as needed
            return buildingLocationInfoRepository.save(buildingLocationInfo);
        }
        return null;
    }

    @DeleteMapping("/{buildingId}")
    public void deleteBuildingLocationInfo(@PathVariable Long buildingId) {
        buildingLocationInfoRepository.deleteById(buildingId);
    }
}
