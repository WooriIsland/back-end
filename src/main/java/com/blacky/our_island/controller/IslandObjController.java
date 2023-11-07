package com.blacky.our_island.controller;

import com.blacky.our_island.domain.IslandObj;
import com.blacky.our_island.service.IslandObjService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/island-objs")
public class IslandObjController {

    @Autowired
    private IslandObjService islandObjService;

    @GetMapping
    public List<IslandObj> getAllIslandObjs() {
        return islandObjService.getAllIslandObjs();
    }

    @GetMapping("/{islandObjId}")
    public IslandObj getIslandObjById(@PathVariable Long islandObjId) {
        return islandObjService.getIslandObjById(islandObjId);
    }

    @PostMapping
    public IslandObj createIslandObj(@RequestBody IslandObj islandObj) {
        return islandObjService.createIslandObj(islandObj);
    }

    @PutMapping("/{islandObjId}")
    public IslandObj updateIslandObj(@PathVariable Long islandObjId, @RequestBody IslandObj updatedIslandObj) {
        return islandObjService.updateIslandObj(islandObjId, updatedIslandObj);
    }

    @DeleteMapping("/{islandObjId}")
    public void deleteIslandObj(@PathVariable Long islandObjId) {
        islandObjService.deleteIslandObj(islandObjId);
    }
}
