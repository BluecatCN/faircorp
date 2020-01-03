package com.emse.faircorp.model;

import javax.persistence.*;
import java.util.Set;

@Entity
@Table(name = "BUILDING")
public class Building {
    @Id
    @GeneratedValue
    private Long id;

    @Column(nullable = false, length=255)
    private String name;

    @OneToMany(mappedBy = "building")
    private Set<Room> rooms;

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

    public Set<Room> getRooms() {
        return rooms;
    }

    public void setRooms(Set<Room> rooms) {
        this.rooms = rooms;
    }

    public Building(){
    }

    public Building(Long id, String name){
        this.id = id;
        this.name = name;
    }
}
