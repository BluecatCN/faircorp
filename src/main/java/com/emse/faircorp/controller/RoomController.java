package com.emse.faircorp.controller;

import com.emse.faircorp.dao.LightDao;
import com.emse.faircorp.dao.RoomDao;
import com.emse.faircorp.dao.RoomDaoCustom;
import com.emse.faircorp.dto.LightDto;
import com.emse.faircorp.dto.RoomDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.transaction.Transactional;
import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/api/rooms")
@Transactional
public class RoomController {

    @Autowired
    private LightDao lightDao;
    @Autowired
    private RoomDao roomDao;

//    @CrossOrigin(origins = "http://localhost:8080")
    @GetMapping
    public List<RoomDto> findAll() {
        return roomDao.findAll()
                .stream()
                .map(RoomDto::new)
                .collect(Collectors.toList());
    }

    @GetMapping(path = "getLights/{id}")
    public List<LightDto> findLightsByRoom(@PathVariable Long id) {
        return roomDao.findRoomLightsByRoomId(id).stream().map(light -> new LightDto(light)).collect(Collectors.toList());
    }
}
