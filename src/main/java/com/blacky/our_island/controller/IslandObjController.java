package com.blacky.our_island.controller;

import com.blacky.our_island.domain.IslandObj;
import com.blacky.our_island.service.IslandObjService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@Tag(name = "가족섬 오브젝트", description = "가족섬 오브젝트 API Document")
@RequestMapping("/api/island-objs")
public class IslandObjController {

    @Autowired
    private IslandObjService islandObjService;

    @GetMapping
    @Operation(summary = "가족섬 오브젝트 모두 조회", description = "가족섬 오브젝트의 모든 정보를 조회합니다.", tags = {"GET"})
    public List<IslandObj> getAllIslandObjs() {
        return islandObjService.getAllIslandObjs();
    }

    @GetMapping("/{islandObjId}")
    @Operation(summary = "가족섬 오브젝트 단일 조회", description = "특정 가족섬 오브젝트의 정보를 출력합니다.", tags = {"GET"})
    public IslandObj getIslandObjById(@PathVariable Long islandObjId) {
        return islandObjService.getIslandObjById(islandObjId);
    }

    @PostMapping
    @Operation(summary = "가족섬 오브젝트 등록", description = "가족섬 오브젝트를 등록합니다.", tags = {"POST"})
    public IslandObj createIslandObj(@RequestBody IslandObj islandObj) {
        return islandObjService.createIslandObj(islandObj);
    }

    @PutMapping("/{islandObjId}")
    @Operation(summary = "가족섬 오브젝트 수정", description = "가족섬 오브젝트를 수정합니다.", tags = {"PUT"})
    public IslandObj updateIslandObj(@PathVariable Long islandObjId, @RequestBody IslandObj updatedIslandObj) {
        return islandObjService.updateIslandObj(islandObjId, updatedIslandObj);
    }

    @DeleteMapping("/{islandObjId}")
    @Operation(summary = "가족섬 오브젝트 삭제", description = "가족섬 오브젝트를 삭제합니다.", tags = {"DELETE"})
    public void deleteIslandObj(@PathVariable Long islandObjId) {
        islandObjService.deleteIslandObj(islandObjId);
    }
}
