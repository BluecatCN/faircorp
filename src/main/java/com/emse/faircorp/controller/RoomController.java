package com.emse.faircorp.controller;

import com.emse.faircorp.dao.LightDao;
import com.emse.faircorp.dao.RoomDao;
import com.emse.faircorp.dao.RoomDaoCustom;
import com.emse.faircorp.dto.LightDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.transaction.Transactional;
import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/api/rooms")
@Transactional
public class RoomController {

    @Autowired
    private LightDao lightDao; // 4.
    @Autowired
    private RoomDao roomDao;

    @GetMapping(path = "getLig/{id}")
    public List<LightDto> findLightsByRoom(@PathVariable Long id) {
        return roomDao.findRoomLightsByRoomId(id).stream().map(light -> new LightDto(light)).collect(Collectors.toList());
    }
}
