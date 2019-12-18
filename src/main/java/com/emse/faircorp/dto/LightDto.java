package com.emse.faircorp.dto;

import com.emse.faircorp.model.Light;
import com.emse.faircorp.model.Status;

public class LightDto {

    private Long id;
    private Integer level;
    private Status status;

    public LightDto() {
    }

    public LightDto(Light light) {
        this.id = light.getId();
        this.level = light.getLevel();
        this.status = light.getStatus();
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
}