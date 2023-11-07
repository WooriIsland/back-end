package com.blacky.our_island.domain;

import javax.persistence.*;

@Entity
@Table(name = "island_island_obj")
public class IslandIslandObj {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "island_island_obj_id")
    private Long islandIslandObjId;

    @Column(name = "pos_x", nullable = false)
    private Double posX;

    @Column(name = "pos_y", nullable = false)
    private Double posY;

    @Column(name = "pos_z", nullable = false)
    private Double posZ;

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

    // Getters and Setters

    // Constructors
}
