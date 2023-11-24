//package com.blacky.our_island.repository;
//
//
//import com.blacky.our_island.domain.BuildingLocationInfo;
//import org.junit.jupiter.api.Test;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.boot.test.context.SpringBootTest;
//
//import static org.junit.jupiter.api.Assertions.assertEquals;
//import static org.junit.jupiter.api.Assertions.assertNotNull;
//import static org.junit.jupiter.api.Assertions.assertNull;
//
//@SpringBootTest
//public class BuildingLocationInfoRepositoryTest {
//
//    @Autowired
//    private BuildingLocationInfoRepository buildingLocationInfoRepository;
//
//    @Test
//    public void testSaveAndGetBuildingLocationInfo() {
//        // Given
//        BuildingLocationInfo buildingLocationInfo = new BuildingLocationInfo();
//        buildingLocationInfo.setBuildingName("아빠 회사");
//        buildingLocationInfo.setBuildingIndex("52");
//        buildingLocationInfo.setBuildingPosX(10.0);
//        buildingLocationInfo.setBuildingPosY(20.0);
//        buildingLocationInfo.setBuildingPosZ(5.0);
//        buildingLocationInfo.setBuildingRotX(0.0);
//        buildingLocationInfo.setBuildingRotY(90.0);
//        buildingLocationInfo.setBuildingRotZ(0.0);
//        buildingLocationInfo.setBuildingRotW(1.0);
//        buildingLocationInfo.setBuildingLatitude(37.123);
//        buildingLocationInfo.setBuildingLongitude(-122.456);
//        buildingLocationInfo.setIslandId(1L);
//
//        // When
//        BuildingLocationInfo savedBuildingLocationInfo = buildingLocationInfoRepository.save(buildingLocationInfo);
//        BuildingLocationInfo retrievedBuildingLocationInfo = buildingLocationInfoRepository.findById(savedBuildingLocationInfo.getBuildingId()).orElse(null);
//
//        // Then
//        assertNotNull(retrievedBuildingLocationInfo);
//        assertEquals("아빠 회사", retrievedBuildingLocationInfo.getBuildingName());
//        assertEquals("52", retrievedBuildingLocationInfo.getBuildingIndex());
//        // Add more assertions as needed
//    }
//
//    @Test
//    public void testUpdateBuildingLocationInfo() {
//        // Given
//        BuildingLocationInfo buildingLocationInfo = new BuildingLocationInfo();
//        buildingLocationInfo.setBuildingName("아들학원");
//        buildingLocationInfo.setBuildingIndex("456");
//        buildingLocationInfo.setBuildingPosX(15.0);
//        buildingLocationInfo.setBuildingPosY(25.0);
//        buildingLocationInfo.setBuildingPosZ(7.0);
//        buildingLocationInfo.setBuildingRotX(0.0);
//        buildingLocationInfo.setBuildingRotY(180.0);
//        buildingLocationInfo.setBuildingRotZ(0.0);
//        buildingLocationInfo.setBuildingRotW(1.0);
//        buildingLocationInfo.setBuildingLatitude(37.456);
//        buildingLocationInfo.setBuildingLongitude(-122.789);
//        buildingLocationInfo.setIslandId(2L);
//
//        BuildingLocationInfo savedBuildingLocationInfo = buildingLocationInfoRepository.save(buildingLocationInfo);
//
//        // When
//        savedBuildingLocationInfo.setBuildingName("아들학원 수정");
//        savedBuildingLocationInfo.setBuildingIndex("456");
//        savedBuildingLocationInfo.setBuildingPosX(20.0);
//        savedBuildingLocationInfo.setBuildingPosY(30.0);
//        savedBuildingLocationInfo.setBuildingPosZ(10.0);
//        savedBuildingLocationInfo.setBuildingRotX(0.0);
//        savedBuildingLocationInfo.setBuildingRotY(270.0);
//        savedBuildingLocationInfo.setBuildingRotZ(0.0);
//        savedBuildingLocationInfo.setBuildingRotW(1.0);
//        savedBuildingLocationInfo.setBuildingLatitude(37.789);
//        savedBuildingLocationInfo.setBuildingLongitude(-122.987);
//        savedBuildingLocationInfo.setIslandId(3L);
//
//        buildingLocationInfoRepository.save(savedBuildingLocationInfo);
//        BuildingLocationInfo updatedBuildingLocationInfo = buildingLocationInfoRepository.findById(savedBuildingLocationInfo.getBuildingId()).orElse(null);
//
//        // Then
//        assertNotNull(updatedBuildingLocationInfo);
//        assertEquals("아들학원 수정", updatedBuildingLocationInfo.getBuildingName());
//        // Add more assertions as needed
//    }
//
//    @Test
//    public void testDeleteBuildingLocationInfo() {
//        // Given
//        BuildingLocationInfo buildingLocationInfo = new BuildingLocationInfo();
//        buildingLocationInfo.setBuildingName("Delete 아들학교");
//        buildingLocationInfo.setBuildingIndex("4528");
//        buildingLocationInfo.setBuildingPosX(25.0);
//        buildingLocationInfo.setBuildingPosY(35.0);
//        buildingLocationInfo.setBuildingPosZ(12.0);
//        buildingLocationInfo.setBuildingRotX(0.0);
//        buildingLocationInfo.setBuildingRotY(360.0);
//        buildingLocationInfo.setBuildingRotZ(0.0);
//        buildingLocationInfo.setBuildingRotW(1.0);
//        buildingLocationInfo.setBuildingLatitude(37.987);
//        buildingLocationInfo.setBuildingLongitude(-123.456);
//        buildingLocationInfo.setIslandId(4L);
//
//        BuildingLocationInfo savedBuildingLocationInfo = buildingLocationInfoRepository.save(buildingLocationInfo);
//
//        // When
//        buildingLocationInfoRepository.deleteById(savedBuildingLocationInfo.getBuildingId());
//        BuildingLocationInfo deletedBuildingLocationInfo = buildingLocationInfoRepository.findById(savedBuildingLocationInfo.getBuildingId()).orElse(null);
//
//        // Then
//        assertNull(deletedBuildingLocationInfo);
//    }
//}
