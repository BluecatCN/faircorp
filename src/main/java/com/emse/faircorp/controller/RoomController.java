package com.emse.faircorp.controller;

import com.emse.faircorp.dao.BuildingDao;
import com.emse.faircorp.dao.LightDao;
import com.emse.faircorp.dao.RoomDao;
import com.emse.faircorp.dto.LightDto;
import com.emse.faircorp.dto.RoomDto;
import com.emse.faircorp.model.Building;
import com.emse.faircorp.model.Room;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletResponse;
import javax.transaction.Transactional;
import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/api/rooms")
@Transactional
public class RoomController {

    public void addHeaders(HttpServletResponse response) {
        response.addHeader("access-control-allow-credentials", "true");
        response.addHeader("access-control-allow-headers", "Origin,Accept,X-Requested-With,Content-Type,X-Auth-Token,Access-Control-Request-Method,Access-Control-Request-Headers,Authorization");
        response.addHeader("access-control-allow-origin", "*");
        response.addHeader("content-type", "application/json;charset=UTF-8");
    }

    @Autowired
    private BuildingDao buildingDao;

    @Autowired
    private LightDao lightDao;
    @Autowired
    private RoomDao roomDao;

    @GetMapping
    public List<RoomDto> findAll() {
        return roomDao.findAll()
                .stream()
                .map(RoomDto::new)
                .collect(Collectors.toList());
    }

    @GetMapping(path = "/{id}")
    public RoomDto findById(@PathVariable Long id) {
        return roomDao.findById(id).map(room -> new RoomDto(room)).orElse(null);
    }

    @GetMapping(path = "getLights/{id}")
    public List<LightDto> findLightsByRoom(@PathVariable Long id) {
        return roomDao.findRoomLightsByRoomId(id).stream().map(light -> new LightDto(light)).collect(Collectors.toList());
    }

    @GetMapping(path = "update/{id}/roomName/{roomName}/buildingId/{buildingId}")
    public List<RoomDto> updateRoom(@PathVariable Long id) {
        Room room = roomDao.findById(id).orElseThrow(IllegalArgumentException::new);
        String roomName = null;
        room.setName(roomName);
        Building buil = buildingDao.findById(id).orElseThrow(IllegalArgumentException::new);
        room.setBuilding(buil);

        roomDao.save(room);
        return roomDao.findAll()
                .stream()
                .map(RoomDto::new)
                .collect(Collectors.toList());
    }
}
