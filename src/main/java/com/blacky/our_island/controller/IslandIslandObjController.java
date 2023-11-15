package com.blacky.our_island.controller;

import com.blacky.our_island.service.IslandIslandObjService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@RestController
@Tag(name = "가족섬별 가족섬 오브젝트", description = "가족섬별 가족섬 오브젝트 API Document")
@RequestMapping("/api/island-island-objs")
public class IslandIslandObjController {

    @Autowired
    private IslandIslandObjService islandIslandObjService;

    @GetMapping
    @Operation(summary = "가족섬 모두 조회", description = "가족섬의 모든 정보를 조회합니다.", tags = {"GET"})
    public List<Map<String, Object>> getAllIslandIslandObjs() {
        return islandIslandObjService.getAllIslandIslandObjs();
    }

    @GetMapping("/{islandIslandObjId}")
    @Operation(summary = "가족섬 단일 조회", description = "특정 가족섬의 정보를 출력합니다.", tags = {"GET"})
    public Map<String, Object> getIslandIslandObjById(@PathVariable Long islandIslandObjId) {
        return islandIslandObjService.getIslandIslandObjById(islandIslandObjId);
    }

    @PostMapping
    @Operation(summary = "가족섬 등록", description = "가족섬을 등록합니다.", tags = {"POST"})
    public void createIslandIslandObj(@RequestBody Map<String, Object> islandIslandObj) {
//    public void createIslandIslandObj(@RequestBody Map<String, Object> islandIslandObj, @AuthenticationPrincipal UserPrincipal userPrincipal) {
//    토큰으로 사용자 정보 저장할때
        islandIslandObjService.createIslandIslandObj(islandIslandObj);
    }

    @PutMapping("/{islandIslandObjId}")
    @Operation(summary = "가족섬 정보 수정", description = "가족섬 정보를 수정합니다.", tags = {"PUT"})
    public void updateIslandIslandObj(@PathVariable Long islandIslandObjId, @RequestBody Map<String, Object> updatedIslandIslandObj) {
        islandIslandObjService.updateIslandIslandObj(islandIslandObjId, updatedIslandIslandObj);
    }

    @DeleteMapping("/{islandIslandObjId}")
    @Operation(summary = "가족섬 삭제", description = "가족섬을 삭제합니다.", tags = {"DELETE"})
    public void deleteIslandIslandObj(@PathVariable Long islandIslandObjId) {
        islandIslandObjService.deleteIslandIslandObj(islandIslandObjId);
    }
}
