package com.blacky.our_island.controller;

import com.blacky.our_island.domain.Island;
import com.blacky.our_island.service.IslandService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/islands")
public class IslandController {

    @Autowired
    private IslandService islandService;

    @GetMapping
    public List<Island> getAllIslands() {
        return islandService.getAllIslands();
    }

    @GetMapping("/{islandId}")
    public Island getIslandById(@PathVariable Long islandId) {
        return islandService.getIslandById(islandId);
    }

    @PostMapping
    public Island createIsland(@RequestBody Island island) {
        return islandService.createIsland(island);
    }

    @PutMapping("/{islandId}")
    public Island updateIsland(@PathVariable Long islandId, @RequestBody Island updatedIsland) {
        return islandService.updateIsland(islandId, updatedIsland);
    }

    @DeleteMapping("/{islandId}")
    public void deleteIsland(@PathVariable Long islandId) {
        islandService.deleteIsland(islandId);
    }
}
