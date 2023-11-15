package com.blacky.our_island.service;

import com.blacky.our_island.domain.BuildingLocationInfo;
import com.blacky.our_island.repository.BuildingLocationInfoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class BuildingLocationInfoService {

    @Autowired
    private BuildingLocationInfoRepository buildingLocationInfoRepository;

    public List<Map<String, Object>> getAllBuildingLocationInfo() {
        return buildingLocationInfoRepository.findAll().stream()
                .map(this::mapToResponseFormat)
                .collect(Collectors.toList());
    }

    public Map<String, Object> getBuildingLocationInfo(Long buildingId) {
        Optional<BuildingLocationInfo> buildingLocationInfoOptional = buildingLocationInfoRepository.findById(buildingId);
        return buildingLocationInfoOptional.map(this::mapToResponseFormat).orElse(null);
    }

    public void saveBuildingLocationInfo(Map<String, Object> buildingInfo) {
        BuildingLocationInfo buildingLocationInfo = new BuildingLocationInfo();

        buildingLocationInfo.setIslandId(Long.parseLong(buildingInfo.get("island_id").toString()));
        buildingLocationInfo.setBuildingName(buildingInfo.get("building_name").toString());
        buildingLocationInfo.setBuildingIndex(buildingInfo.get("building_index").toString());
        buildingLocationInfo.setBuildingLatitude(Double.parseDouble(buildingInfo.get("building_latitude").toString()));
        buildingLocationInfo.setBuildingLongitude(Double.parseDouble(buildingInfo.get("building_longitude").toString()));

        Map<String, Object> buildingPos = (Map<String, Object>) buildingInfo.get("building_pos");
        buildingLocationInfo.setBuildingPosX(Double.parseDouble(buildingPos.get("x").toString()));
        buildingLocationInfo.setBuildingPosY(Double.parseDouble(buildingPos.get("y").toString()));
        buildingLocationInfo.setBuildingPosZ(Double.parseDouble(buildingPos.get("z").toString()));

        Map<String, Object> buildingRot = (Map<String, Object>) buildingInfo.get("building_rot");
        buildingLocationInfo.setBuildingRotX(Double.parseDouble(buildingRot.get("x").toString()));
        buildingLocationInfo.setBuildingRotY(Double.parseDouble(buildingRot.get("y").toString()));
        buildingLocationInfo.setBuildingRotZ(Double.parseDouble(buildingRot.get("z").toString()));
        buildingLocationInfo.setBuildingRotW(Double.parseDouble(buildingRot.get("w").toString()));

        buildingLocationInfoRepository.save(buildingLocationInfo);
    }


    public void deleteBuildingLocationInfo(Long buildingId) {
        buildingLocationInfoRepository.deleteById(buildingId);
    }

    public void updateBuildingLocationInfo(Long buildingId, Map<String, Object> buildingInfo) {
        Optional<BuildingLocationInfo> buildingLocationInfoOptional = buildingLocationInfoRepository.findById(buildingId);
        buildingLocationInfoOptional.ifPresent(info -> {
            info.setIslandId(Long.parseLong(buildingInfo.get("island_id").toString()));
            info.setBuildingName(buildingInfo.get("building_name").toString());
            info.setBuildingIndex(buildingInfo.get("building_index").toString());
            info.setBuildingLatitude(Double.parseDouble(buildingInfo.get("building_latitude").toString()));
            info.setBuildingLongitude(Double.parseDouble(buildingInfo.get("building_longitude").toString()));

            Map<String, Object> buildingPos = (Map<String, Object>) buildingInfo.get("building_pos");
            info.setBuildingPosX(Double.parseDouble(buildingPos.get("x").toString()));
            info.setBuildingPosY(Double.parseDouble(buildingPos.get("y").toString()));
            info.setBuildingPosZ(Double.parseDouble(buildingPos.get("z").toString()));

            Map<String, Object> buildingRot = (Map<String, Object>) buildingInfo.get("building_rot");
            info.setBuildingRotX(Double.parseDouble(buildingRot.get("x").toString()));
            info.setBuildingRotY(Double.parseDouble(buildingRot.get("y").toString()));
            info.setBuildingRotZ(Double.parseDouble(buildingRot.get("z").toString()));
            info.setBuildingRotW(Double.parseDouble(buildingRot.get("w").toString()));

            buildingLocationInfoRepository.save(info);
        });
    }


    private Map<String, Object> mapToResponseFormat(BuildingLocationInfo buildingLocationInfo) {
        Map<String, Object> response = new HashMap<>();
        response.put("island_id", buildingLocationInfo.getIslandId());
        response.put("building_name", buildingLocationInfo.getBuildingName());
        response.put("building_index", buildingLocationInfo.getBuildingIndex());
        response.put("building_latitude", buildingLocationInfo.getBuildingLatitude());
        response.put("building_longitude", buildingLocationInfo.getBuildingLongitude());

        Map<String, Object> buildingPos = new HashMap<>();
        buildingPos.put("x", buildingLocationInfo.getBuildingPosX());
        buildingPos.put("y", buildingLocationInfo.getBuildingPosY());
        buildingPos.put("z", buildingLocationInfo.getBuildingPosZ());
        response.put("building_pos", buildingPos);

        Map<String, Object> buildingRot = new HashMap<>();
        buildingRot.put("x", buildingLocationInfo.getBuildingRotX());
        buildingRot.put("y", buildingLocationInfo.getBuildingRotY());
        buildingRot.put("z", buildingLocationInfo.getBuildingRotZ());
        buildingRot.put("w", buildingLocationInfo.getBuildingRotW());
        response.put("building_rot", buildingRot);

        return response;
    }


}
