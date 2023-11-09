package com.blacky.our_island.service;

import com.blacky.our_island.domain.Island;
import com.blacky.our_island.repository.IslandRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class IslandService {

    @Autowired
    private IslandRepository islandRepository;

    public List<Island> getAllIslands() {
        return islandRepository.findAll();
    }

    public Island getIslandById(Long islandId) {
        return islandRepository.findById(islandId).orElse(null);
    }

    public Island createIsland(Island island) {
        return islandRepository.save(island);
    }

    public Island updateIsland(Long islandId, Island updatedIsland) {
        Island island = islandRepository.findById(islandId).orElse(null);
        if (island != null) {
            island.setIslandUniqueNumber(updatedIsland.getIslandUniqueNumber());
            return islandRepository.save(island);
        }
        return null;
    }


    public void deleteIsland(Long islandId) {
        islandRepository.deleteById(islandId);
    }
}
