package com.blacky.our_island.domain;

import javax.persistence.*;

@Entity
@Table(name = "island_island_obj")
public class IslandIslandObj {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "island_island_obj_id")
    private Long islandIslandObjId;

    @Column(name = "position_x", nullable = false)
    private Double positionX;

    @Column(name = "position_y", nullable = false)
    private Double positionY;

    @Column(name = "position_z", nullable = false)
    private Double positionZ;

    @Column(name = "rotation_x", nullable = false)
    private Double rotationX;

    @Column(name = "rotation_y", nullable = false)
    private Double rotationY;

    @Column(name = "rotation_z", nullable = false)
    private Double rotationZ;

    @Column(name = "rotation_w", nullable = false)
    private Double rotationW;

    @Column(name = "island_id", nullable = false)
    private Long islandId;

    @Column(name = "island_obj_id", nullable = false)
    private Long islandObjId;

    public Long getIslandIslandObjId() {
        return islandIslandObjId;
    }

    public void setIslandIslandObjId(Long islandIslandObjId) {
        this.islandIslandObjId = islandIslandObjId;
    }

    public Double getPositionX() {
        return positionX;
    }

    public void setPositionX(Double positionX) {
        this.positionX = positionX;
    }

    public Double getPositionY() {
        return positionY;
    }

    public void setPositionY(Double positionY) {
        this.positionY = positionY;
    }

    public Double getPositionZ() {
        return positionZ;
    }

    public void setPositionZ(Double positionZ) {
        this.positionZ = positionZ;
    }

    public Double getRotationX() {
        return rotationX;
    }

    public void setRotationX(Double rotationX) {
        this.rotationX = rotationX;
    }

    public Double getRotationY() {
        return rotationY;
    }

    public void setRotationY(Double rotationY) {
        this.rotationY = rotationY;
    }

    public Double getRotationZ() {
        return rotationZ;
    }

    public void setRotationZ(Double rotationZ) {
        this.rotationZ = rotationZ;
    }

    public Double getRotationW() {
        return rotationW;
    }

    public void setRotationW(Double rotationW) {
        this.rotationW = rotationW;
    }

    public Long getIslandId() {
        return islandId;
    }

    public void setIslandId(Long islandId) {
        this.islandId = islandId;
    }

    public Long getIslandObjId() {
        return islandObjId;
    }

    public void setIslandObjId(Long islandObjId) {
        this.islandObjId = islandObjId;
    }

}
