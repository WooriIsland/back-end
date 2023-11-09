package com.blacky.our_island.domain;

import javax.persistence.*;

@Entity
@Table(name = "island_obj")
public class IslandObj {

    public IslandObj() {
    }

    @Id
    @Column(name = "island_obj_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long islandObjId;

    @Column(name = "island_obj_index", nullable = false)
    private String islandObjIndex;

    public Long getIslandObjId() {
        return islandObjId;
    }

    public void setIslandObjId(Long islandObjId) {
        this.islandObjId = islandObjId;
    }

    public String getIslandObjIndex() {
        return islandObjIndex;
    }

    public void setIslandObjIndex(String islandObjIndex) {
        this.islandObjIndex = islandObjIndex;
    }

}
