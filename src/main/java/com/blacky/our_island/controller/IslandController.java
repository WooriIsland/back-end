package com.blacky.our_island.controller;

import com.blacky.our_island.domain.Island;
import com.blacky.our_island.service.IslandService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@Tag(name = "가족섬", description = "가족섬 API Document")
@RequestMapping("/api/islands")
public class IslandController {

    @Autowired
    private IslandService islandService;

    @GetMapping
    @Operation(summary = "가족섬 모두 조회", description = "가족섬의 모든 정보를 조회합니다.", tags = {"GET"})
    public List<Island> getAllIslands() {
        return islandService.getAllIslands();
    }

    @GetMapping("/{islandId}")
    @Operation(summary = "가족섬 단일 조회", description = "특정 가족섬의 정보를 출력합니다.", tags = {"GET"})
    public Island getIslandById(@PathVariable Long islandId) {
        return islandService.getIslandById(islandId);
    }

    @PostMapping
    @Operation(summary = "가족섬 등록", description = "가족섬을 등록합니다.", tags = {"POST"})
    public Island createIsland(@RequestBody Island island) {
        return islandService.createIsland(island);
    }

    @PutMapping("/{islandId}")
    @Operation(summary = "가족섬 정보 수정", description = "가족섬 정보를 수정합니다.", tags = {"PUT"})
    public Island updateIsland(@PathVariable Long islandId, @RequestBody Island updatedIsland) {
        return islandService.updateIsland(islandId, updatedIsland);
    }

    @DeleteMapping("/{islandId}")
    @Operation(summary = "가족섬 삭제", description = "가족섬을 삭제합니다.", tags = {"DELETE"})
    public void deleteIsland(@PathVariable Long islandId) {
        islandService.deleteIsland(islandId);
    }

//
//    @DeleteMapping("/{islandId}")
//    public ResponseEntity<String> deleteIsland(@PathVariable Long islandId) {
//        islandService.deleteIsland(islandId);
//        return ResponseEntity.ok("Island deleted successfully");
//    }


}
