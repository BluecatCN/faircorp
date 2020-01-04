package com.emse.faircorp.dto;

import com.emse.faircorp.model.Light;
import com.emse.faircorp.model.Room;
import com.emse.faircorp.model.Status;

public class LightDto {

    private Long id;
    private Integer level;
    private Status status;
    private Long roomId;

    public Long getRoomId() {
        return roomId;
    }

    public void setRoomId(Long roomId) {
        this.roomId = roomId;
    }

    public LightDto() {
    }

    public LightDto(Light light) {
        this.id = light.getId();
        this.level = light.getLevel();
        this.status = light.getStatus();
        this.roomId = light.getRoom().getId();
    }

    public Long getId() {
        return id;
    }

    public Integer getLevel() {
        return level;
    }

    public Status getStatus() {
        return status;
    }

    public Long getRoom() {
        return roomId;
    }

}