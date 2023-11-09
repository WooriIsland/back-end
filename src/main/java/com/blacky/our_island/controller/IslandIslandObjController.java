package com.blacky.our_island.controller;

import com.blacky.our_island.service.IslandIslandObjService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/api/island-island-objs")
public class IslandIslandObjController {

    @Autowired
    private IslandIslandObjService islandIslandObjService;

    @GetMapping
    public List<Map<String, Object>> getAllIslandIslandObjs() {
        return islandIslandObjService.getAllIslandIslandObjs();
    }

    @GetMapping("/{islandIslandObjId}")
    public Map<String, Object> getIslandIslandObjById(@PathVariable Long islandIslandObjId) {
        return islandIslandObjService.getIslandIslandObjById(islandIslandObjId);
    }

    @PostMapping
    public void createIslandIslandObj(@RequestBody Map<String, Object> islandIslandObj) {
        islandIslandObjService.createIslandIslandObj(islandIslandObj);
    }

    @PutMapping("/{islandIslandObjId}")
    public void updateIslandIslandObj(@PathVariable Long islandIslandObjId, @RequestBody Map<String, Object> updatedIslandIslandObj) {
        islandIslandObjService.updateIslandIslandObj(islandIslandObjId, updatedIslandIslandObj);
    }

    @DeleteMapping("/{islandIslandObjId}")
    public void deleteIslandIslandObj(@PathVariable Long islandIslandObjId) {
        islandIslandObjService.deleteIslandIslandObj(islandIslandObjId);
    }
}
