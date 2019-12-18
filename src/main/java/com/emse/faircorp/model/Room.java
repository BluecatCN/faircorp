package com.emse.faircorp.model;

import javax.persistence.*;
import java.util.Set;

@Entity
@Table(name = "ROOM")
public class Room {

    @Id
    @GeneratedValue
    private Long id;

    @Column(nullable = false, length=255)
    private String name;

    @Column(nullable = false)
    private Integer floor;

    @OneToMany(mappedBy = "room")
    private Set<Light> lights;

    public Room() {
    }

    public Room(Long id, String name, Integer floor) {
        this.id = id;
        this.name = name;
        this.floor = floor;
    }
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getFloor() {
        return floor;
    }

    public void setFloor(Integer floor) {
        this.floor = floor;
    }

    public Set<Light> getLights() {
        return lights;
    }

    public void setLights(Set<Light> lights) {
        this.lights = lights;
    }
}
