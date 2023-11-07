package com.blacky.our_island.controller;

import com.blacky.our_island.domain.BuildingLocationInfo;
import com.blacky.our_island.service.BuildingLocationInfoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequestMapping("/api/building-location-info")
public class BuildingLocationInfoController {

    @Autowired
    private BuildingLocationInfoService buildingLocationInfoService;

    @GetMapping
    public List<BuildingLocationInfo> getAllBuildingLocationInfo() {
        return buildingLocationInfoService.getAllBuildingLocationInfo();
    }

    @GetMapping("/{buildingId}")
    public BuildingLocationInfo getBuildingLocationInfoById(@PathVariable Long buildingId) {
        return buildingLocationInfoService.getBuildingLocationInfoById(buildingId);
    }

    @PostMapping
    public BuildingLocationInfo createBuildingLocationInfo(@RequestBody BuildingLocationInfo buildingLocationInfo) {
        return buildingLocationInfoService.createBuildingLocationInfo(buildingLocationInfo);
    }

    @PutMapping("/{buildingId}")
    public BuildingLocationInfo updateBuildingLocationInfo(@PathVariable Long buildingId, @RequestBody BuildingLocationInfo updatedBuildingLocationInfo) {
        return buildingLocationInfoService.updateBuildingLocationInfo(buildingId, updatedBuildingLocationInfo);
    }

    @DeleteMapping("/{buildingId}")
    public void deleteBuildingLocationInfo(@PathVariable Long buildingId) {
        buildingLocationInfoService.deleteBuildingLocationInfo(buildingId);
    }
}
