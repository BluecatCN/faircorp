package com.emse.faircorp.dto;

import com.emse.faircorp.model.Light;
import com.emse.faircorp.model.Room;
import com.emse.faircorp.model.Status;

import java.util.List;
import java.util.Set;

public class RoomDto {
    private Long id;
    private String name;
    private Integer floor;
//    private Set<Light> lights;
//    private List<Long> lightIds;
    private Long buildingId;
    private String buildingName;
    private Set<Light> lights;

    public RoomDto() {
    }

    public RoomDto(Room room) {
        this.id = room.getId();
        this.name = room.getName();
        this.floor = room.getFloor();
        this.buildingId = room.getBuilding().getId();
        this.buildingName = room.getBuilding().getName();
//        this.lights = room.getLights();
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

//    public Set<Light> getLights() {
//        return lights;
//    }
//
//    public void setLights(Set<Light> lights) {
//        this.lights = lights;
//    }

    public void setFloor(Integer floor) {
        this.floor = floor;
    }

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