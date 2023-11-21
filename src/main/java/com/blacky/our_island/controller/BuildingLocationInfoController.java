package com.blacky.our_island.controller;

import com.blacky.our_island.service.BuildingLocationInfoService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@RestController
@Tag(name = "건물 위치정보", description = "건물 위치정보 API Document")
@RequestMapping("/api/building-location-info")
public class BuildingLocationInfoController {

    @Autowired
    private BuildingLocationInfoService buildingLocationInfoService;

    @GetMapping
    @Operation(summary = "건물 위치정보 모두 조회", description = "건물의 모든 위치정보를 조회합니다.", tags = {"GET"})
    public List<Map<String, Object>> getAllBuildingLocationInfo() {
        return buildingLocationInfoService.getAllBuildingLocationInfo();
    }

    @GetMapping("/{buildingId}")
    @Operation(summary = "건물 위치정보 단일 조회", description = "건물의 특정 위치정보를 조회합니다.", tags = {"GET"})
    public Map<String, Object> getBuildingLocationInfo(@PathVariable Long buildingId) {
        return buildingLocationInfoService.getBuildingLocationInfo(buildingId);
    }

    @PostMapping
    @Operation(summary = "건물 위치정보 등록", description = "건물 위치정보를 등록합니다.", tags = {"POST"})
    public void saveBuildingLocationInfo(@RequestBody Map<String, Object> buildingInfo) {
        buildingLocationInfoService.saveBuildingLocationInfo(buildingInfo);
    }

    @DeleteMapping("/{buildingId}")
    @Operation(summary = "건물 위치정보 삭제", description = "건물 위치정보를 삭제합니다.", tags = {"DELETE"})
    public void deleteBuildingLocationInfo(@PathVariable Long buildingId) {
        buildingLocationInfoService.deleteBuildingLocationInfo(buildingId);
    }

    @PutMapping("/{buildingId}")
    @Operation(summary = "건물 위치정보 수정", description = "건물 위치정보를 수정합니다.", tags = {"PUT"})
    public void updateBuildingLocationInfo(@PathVariable Long buildingId, @RequestBody Map<String, Object> buildingInfo) {
        buildingLocationInfoService.updateBuildingLocationInfo(buildingId, buildingInfo);
    }
}
