package com.blacky.our_island.service;

import com.blacky.our_island.domain.IslandIslandObj;
import com.blacky.our_island.repository.IslandIslandObjRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class IslandIslandObjService {

    @Autowired
    private IslandIslandObjRepository islandIslandObjRepository;

    public List<Map<String, Object>> getAllIslandIslandObjs() {
        return islandIslandObjRepository.findAll().stream()
                .map(this::mapToResponseFormat)
                .collect(Collectors.toList());
    }

    public Map<String, Object> getIslandIslandObjById(Long islandIslandObjId) {
        Optional<IslandIslandObj> islandIslandObjOptional = islandIslandObjRepository.findById(islandIslandObjId);
        return islandIslandObjOptional.map(this::mapToResponseFormat).orElse(null);
    }

    public void createIslandIslandObj(Map<String, Object> islandObjInfo) {
        IslandIslandObj islandIslandObj = new IslandIslandObj();

        islandIslandObj.setIslandId(Long.parseLong(islandObjInfo.get("island_id").toString()));
        islandIslandObj.setIslandObjId(Long.parseLong(islandObjInfo.get("island_obj_id").toString()));

        Map<String, Object> position = (Map<String, Object>) islandObjInfo.get("position");
        islandIslandObj.setPositionX(Double.parseDouble(position.get("x").toString()));
        islandIslandObj.setPositionY(Double.parseDouble(position.get("y").toString()));
        islandIslandObj.setPositionZ(Double.parseDouble(position.get("z").toString()));

        Map<String, Object> rotation = (Map<String, Object>) islandObjInfo.get("rotation");
        islandIslandObj.setRotationX(Double.parseDouble(rotation.get("x").toString()));
        islandIslandObj.setRotationY(Double.parseDouble(rotation.get("y").toString()));
        islandIslandObj.setRotationZ(Double.parseDouble(rotation.get("z").toString()));
        islandIslandObj.setRotationW(Double.parseDouble(rotation.get("w").toString()));

        islandIslandObjRepository.save(islandIslandObj);
    }

    public void updateIslandIslandObj(Long islandIslandObjId, Map<String, Object> islandObjInfo) {
        Optional<IslandIslandObj> islandIslandObjOptional = islandIslandObjRepository.findById(islandIslandObjId);
        islandIslandObjOptional.ifPresent(obj -> {
            obj.setIslandId(Long.parseLong(islandObjInfo.get("island_id").toString()));
            obj.setIslandObjId(Long.parseLong(islandObjInfo.get("island_obj_id").toString()));

            Map<String, Object> position = (Map<String, Object>) islandObjInfo.get("position");
            obj.setPositionX(Double.parseDouble(position.get("x").toString()));
            obj.setPositionY(Double.parseDouble(position.get("y").toString()));
            obj.setPositionZ(Double.parseDouble(position.get("z").toString()));

            Map<String, Object> rotation = (Map<String, Object>) islandObjInfo.get("rotation");
            obj.setRotationX(Double.parseDouble(rotation.get("x").toString()));
            obj.setRotationY(Double.parseDouble(rotation.get("y").toString()));
            obj.setRotationZ(Double.parseDouble(rotation.get("z").toString()));
            obj.setRotationW(Double.parseDouble(rotation.get("w").toString()));

            islandIslandObjRepository.save(obj);
        });
    }

    public void deleteIslandIslandObj(Long islandIslandObjId) {
        islandIslandObjRepository.deleteById(islandIslandObjId);
    }

    private Map<String, Object> mapToResponseFormat(IslandIslandObj islandIslandObj) {
        Map<String, Object> response = new HashMap<>();
        response.put("island_id", islandIslandObj.getIslandId());
        response.put("island_obj_id", islandIslandObj.getIslandObjId());

        Map<String, Object> position = new HashMap<>();
        position.put("x", islandIslandObj.getPositionX());
        position.put("y", islandIslandObj.getPositionY());
        position.put("z", islandIslandObj.getPositionZ());
        response.put("position", position);

        Map<String, Object> rotation = new HashMap<>();
        rotation.put("x", islandIslandObj.getRotationX());
        rotation.put("y", islandIslandObj.getRotationY());
        rotation.put("z", islandIslandObj.getRotationZ());
        rotation.put("w", islandIslandObj.getRotationW());
        response.put("rotation", rotation);

        return response;
    }
}
