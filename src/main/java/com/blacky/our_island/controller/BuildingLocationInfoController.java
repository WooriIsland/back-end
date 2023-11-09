package com.blacky.our_island.controller;

import com.blacky.our_island.service.BuildingLocationInfoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/api/building-location-info")
public class BuildingLocationInfoController {

    @Autowired
    private BuildingLocationInfoService buildingLocationInfoService;

    @GetMapping
    public List<Map<String, Object>> getAllBuildingLocationInfo() {
        return buildingLocationInfoService.getAllBuildingLocationInfo();
    }

    @GetMapping("/{buildingId}")
    public Map<String, Object> getBuildingLocationInfo(@PathVariable Long buildingId) {
        return buildingLocationInfoService.getBuildingLocationInfo(buildingId);
    }

    @PostMapping
    public void saveBuildingLocationInfo(@RequestBody Map<String, Object> buildingInfo) {
        buildingLocationInfoService.saveBuildingLocationInfo(buildingInfo);
    }

    @DeleteMapping("/{buildingId}")
    public void deleteBuildingLocationInfo(@PathVariable Long buildingId) {
        buildingLocationInfoService.deleteBuildingLocationInfo(buildingId);
    }

    @PutMapping("/{buildingId}")
    public void updateBuildingLocationInfo(@PathVariable Long buildingId, @RequestBody Map<String, Object> buildingInfo) {
        buildingLocationInfoService.updateBuildingLocationInfo(buildingId, buildingInfo);
    }
}
