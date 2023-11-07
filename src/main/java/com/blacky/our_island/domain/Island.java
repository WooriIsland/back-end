package com.blacky.our_island.domain;

import javax.persistence.*;

@Entity
@Table(name = "island")
public class Island {

    public Island() {
    }

    @Id
    @Column(name = "island_id")
    private Long islandId;

    @Column(name = "island_unique_number", nullable = false)
    private String islandUniqueNumber;

    // Getters and Setters

    public Long getIslandId() {
        return islandId;
    }

    public void setIslandId(Long islandId) {
        this.islandId = islandId;
    }

    public String getIslandUniqueNumber() {
        return islandUniqueNumber;
    }

    public void setIslandUniqueNumber(String islandUniqueNumber) {
        this.islandUniqueNumber = islandUniqueNumber;
    }

    public Island(Long islandId, String islandUniqueNumber) {
        this.islandId = islandId;
        this.islandUniqueNumber = islandUniqueNumber;
    }


}
