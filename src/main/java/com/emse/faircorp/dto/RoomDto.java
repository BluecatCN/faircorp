package com.emse.faircorp.dto;

import com.emse.faircorp.model.Light;
import com.emse.faircorp.model.Room;
import com.emse.faircorp.model.Status;

import java.util.Set;

public class RoomDto {
    private Long id;
    private String name;
    private Integer floor;
//    private Set<Light> lights;
//    private String[] lights;

    public RoomDto() {
    }

    public RoomDto(Room room) {
        this.id = room.getId();
        this.name = room.getName();
        this.floor = room.getFloor();
//        Set<Light> ll = room.getLights();
//        this.lights = (String[]) room.getLights().toArray();
    }

    public Long getId() {
        return id;
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
//
//
//    public String[] getLights() {
//        return lights;
//    }
//
//    public void setLights(String[] lights) {
//        this.lights = lights;
//    }
}