package com.blacky.our_island.domain;

import javax.persistence.*;

@Entity
@Table(name = "island")
public class Island {

    public Island() {
    }



    @Id
    @Column(name = "island_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY) //    클라이언트가 제공하는 islandId 값에 따라 저장하고 싶을 경우엔 주석처리.
    // 주석처리 안하면 클라이언트가 제공하는 islandID 값 무시
    private Long islandId;

    @Column(name = "island_unique_number", nullable = false)
    private String islandUniqueNumber;

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
