package com.blacky.our_island.domain;

import javax.persistence.*;

@Entity
@Table(name = "building_location_info")
public class BuildingLocationInfo {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "building_id")
    private Long buildingId;  // 건물 번호

    @Column(name = "building_name")
    private String buildingName;  // 건물명

    @Column(name = "building_index")
    private String buildingIndex;  // 건물 오브젝트 index

    @Column(name = "building_pos_x")
    private Double buildingPosX;  // 위치 X

    @Column(name = "building_pos_y")
    private Double buildingPosY;  // 위치 Y

    @Column(name = "building_pos_z")
    private Double buildingPosZ;  // 위치 Z

    @Column(name = "building_rot_x")
    private Double buildingRotX;  // 회전 X

    @Column(name = "building_rot_y")
    private Double buildingRotY;  // 회전 Y

    @Column(name = "building_rot_z")
    private Double buildingRotZ;  // 회전 Z

    @Column(name = "buildling_rot_w")
    private Double buildingRotW;  // 회전 W

    @Column(name = "building_latitude")
    private Double buildingLatitude;  // 위도

    @Column(name = "building_longitude")
    private Double buildingLongitude;  // 경도

    @Column(name = "island_id")
    private Long islandId;  // 가족섬 번호


    // Getter Setter
    public Long getBuildingId() {
        return buildingId;
    }

    public void setBuildingId(Long buildingId) {
        this.buildingId = buildingId;
    }

    public String getBuildingName() {
        return buildingName;
    }

    public void setBuildingName(String buildingName) {
        this.buildingName = buildingName;
    }

    public String getBuildingIndex() {
        return buildingIndex;
    }

    public void setBuildingIndex(String buildingIndex) {
        this.buildingIndex = buildingIndex;
    }

    public Double getBuildingPosX() {
        return buildingPosX;
    }

    public void setBuildingPosX(Double buildingPosX) {
        this.buildingPosX = buildingPosX;
    }

    public Double getBuildingPosY() {
        return buildingPosY;
    }

    public void setBuildingPosY(Double buildingPosY) {
        this.buildingPosY = buildingPosY;
    }

    public Double getBuildingPosZ() {
        return buildingPosZ;
    }

    public void setBuildingPosZ(Double buildingPosZ) {
        this.buildingPosZ = buildingPosZ;
    }

    public Double getBuildingRotX() {
        return buildingRotX;
    }

    public void setBuildingRotX(Double buildingRotX) {
        this.buildingRotX = buildingRotX;
    }

    public Double getBuildingRotY() {
        return buildingRotY;
    }

    public void setBuildingRotY(Double buildingRotY) {
        this.buildingRotY = buildingRotY;
    }

    public Double getBuildingRotZ() {
        return buildingRotZ;
    }

    public void setBuildingRotZ(Double buildingRotZ) {
        this.buildingRotZ = buildingRotZ;
    }

    public Double getBuildingRotW() {
        return buildingRotW;
    }

    public void setBuildingRotW(Double buildingRotW) {
        this.buildingRotW = buildingRotW;
    }

    public Double getBuildingLatitude() {
        return buildingLatitude;
    }

    public void setBuildingLatitude(Double buildingLatitude) {
        this.buildingLatitude = buildingLatitude;
    }

    public Double getBuildingLongitude() {
        return buildingLongitude;
    }

    public void setBuildingLongitude(Double buildingLongitude) {
        this.buildingLongitude = buildingLongitude;
    }

    public Long getIslandId() {
        return islandId;
    }

    public void setIslandId(Long islandId) {
        this.islandId = islandId;
    }


}
