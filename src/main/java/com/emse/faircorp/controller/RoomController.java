package com.emse.faircorp.controller;

import com.emse.faircorp.dao.LightDao;
import com.emse.faircorp.dao.RoomDao;
import com.emse.faircorp.dao.RoomDaoCustom;
import com.emse.faircorp.dto.LightDto;
import com.emse.faircorp.dto.RoomDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletResponse;
import javax.transaction.Transactional;
import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/api/rooms")
//@CrossOrigin(origins = "*", allowedHeaders = "*")
@Transactional
public class RoomController {

    public void addHeaders (HttpServletResponse response) {
        response.addHeader("access-control-allow-credentials", "true");
        response.addHeader("access-control-allow-headers", "Origin,Accept,X-Requested-With,Content-Type,X-Auth-Token,Access-Control-Request-Method,Access-Control-Request-Headers,Authorization");
        response.addHeader("access-control-allow-origin", "*");
        response.addHeader("content-type", "application/json;charset=UTF-8");
    }

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

    @GetMapping(path = "/{id}")
    public RoomDto findById(@PathVariable Long id) {
        return roomDao.findById(id).map(room -> new RoomDto(room)).orElse(null);
    }


    @GetMapping(path = "getLights/{id}")
    public List<LightDto> findLightsByRoom(@PathVariable Long id) {
        return roomDao.findRoomLightsByRoomId(id).stream().map(light -> new LightDto(light)).collect(Collectors.toList());
    }
}
