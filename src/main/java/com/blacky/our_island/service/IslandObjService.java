package com.blacky.our_island.service;

import com.blacky.our_island.domain.IslandObj;
import com.blacky.our_island.repository.IslandObjRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class IslandObjService {

    @Autowired
    private IslandObjRepository islandObjRepository;

    public List<IslandObj> getAllIslandObjs() {
        return islandObjRepository.findAll();
    }

    public IslandObj getIslandObjById(Long islandObjId) {
        return islandObjRepository.findById(islandObjId).orElse(null);
    }

    public IslandObj createIslandObj(IslandObj islandObj) {
        return islandObjRepository.save(islandObj);
    }

    public IslandObj updateIslandObj(Long islandObjId, IslandObj updatedIslandObj) {
        IslandObj islandObj = islandObjRepository.findById(islandObjId).orElse(null);
        if (islandObj != null) {
            islandObj.setIslandObjIndex(updatedIslandObj.getIslandObjIndex());
            return islandObjRepository.save(islandObj);
        }
        return null;
    }


    public void deleteIslandObj(Long islandObjId) {
        islandObjRepository.deleteById(islandObjId);
    }
}
