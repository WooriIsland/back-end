package com.blacky.our_island.controller;

import com.blacky.our_island.domain.IslandIslandObj;
import com.blacky.our_island.service.IslandIslandObjService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/island-island-objs")
public class IslandIslandObjController {

    @Autowired
    private IslandIslandObjService islandIslandObjService;

    @GetMapping
    public List<IslandIslandObj> getAllIslandIslandObjs() {
        return islandIslandObjService.getAllIslandIslandObjs();
    }

    @GetMapping("/{islandIslandObjId}")
    public IslandIslandObj getIslandIslandObjById(@PathVariable Long islandIslandObjId) {
        return islandIslandObjService.getIslandIslandObjById(islandIslandObjId);
    }

    @PostMapping
    public IslandIslandObj createIslandIslandObj(@RequestBody IslandIslandObj islandIslandObj) {
        return islandIslandObjService.createIslandIslandObj(islandIslandObj);
    }

    @PutMapping("/{islandIslandObjId}")
    public IslandIslandObj updateIslandIslandObj(@PathVariable Long islandIslandObjId, @RequestBody IslandIslandObj updatedIslandIslandObj) {
        return islandIslandObjService.updateIslandIslandObj(islandIslandObjId, updatedIslandIslandObj);
    }

    @DeleteMapping("/{islandIslandObjId}")
    public void deleteIslandIslandObj(@PathVariable Long islandIslandObjId) {
        islandIslandObjService.deleteIslandIslandObj(islandIslandObjId);
    }
}
