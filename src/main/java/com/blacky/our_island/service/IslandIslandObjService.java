package com.blacky.our_island.service;

import com.blacky.our_island.domain.IslandIslandObj;
import com.blacky.our_island.repository.IslandIslandObjRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class IslandIslandObjService {

    @Autowired
    private IslandIslandObjRepository islandIslandObjRepository;

    public List<IslandIslandObj> getAllIslandIslandObjs() {
        return islandIslandObjRepository.findAll();
    }

    public IslandIslandObj getIslandIslandObjById(Long islandIslandObjId) {
        return islandIslandObjRepository.findById(islandIslandObjId).orElse(null);
    }

    public IslandIslandObj createIslandIslandObj(IslandIslandObj islandIslandObj) {
        return islandIslandObjRepository.save(islandIslandObj);
    }

    public IslandIslandObj updateIslandIslandObj(Long islandIslandObjId, IslandIslandObj updatedIslandIslandObj) {
        IslandIslandObj islandIslandObj = islandIslandObjRepository.findById(islandIslandObjId).orElse(null);
        if (islandIslandObj != null) {
            // Update fields as needed
            return islandIslandObjRepository.save(islandIslandObj);
        }
        return null;
    }

    public void deleteIslandIslandObj(Long islandIslandObjId) {
        islandIslandObjRepository.deleteById(islandIslandObjId);
    }
}
