package com.emse.faircorp.model;

import javax.persistence.*;

@Entity
@Table(name = "LIGHT")
public class Light {

    @Id
    @GeneratedValue
    private Long id;

    @Column()
    private Integer level;

    @Column()
    @Enumerated(EnumType.STRING)
    private Status status;

    @ManyToOne()
    private Room room;

    public Light() {
    }

    public Light(Integer level, Status status, Room room) {
        this.level = level;
        this.status = status;
        this.room = room;
    }

    public Light(Long roomId, Integer level, Status status) {
        this.level = level;
        this.status = status;

    }

    public Long getId() {
        return this.id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Integer getLevel() {
        return level;
    }

    public void setLevel(Integer level) {
        this.level = level;
    }

    public Status getStatus() {
        return status;
    }

    public void setStatus(Status status) {
        this.status = status;
    }

    public Room getRoom() {
        return room;
    }

    public void setRoom(Room room) {
        this.room = room;
    }
}