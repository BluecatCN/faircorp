package com.emse.faircorp.controller;

import com.emse.faircorp.dao.LightDao;
import com.emse.faircorp.dao.RoomDao;
import com.emse.faircorp.dto.LightDto;
import com.emse.faircorp.model.Light;
import com.emse.faircorp.model.Room;
import com.emse.faircorp.model.Status;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
//import org.springframework.web.filter.HttpPutFormContentFilter;

import javax.transaction.Transactional;
import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/api/lights")
@Transactional
public class LightController {

    @Autowired
    private LightDao lightDao;
    @Autowired
    private RoomDao roomDao;

    @GetMapping
    public List<LightDto> findAll() {
        return lightDao.findAll()
                .stream()
                .map(LightDto::new)
                .collect(Collectors.toList());
    }

    @GetMapping(path = "/{id}")
    public LightDto findById(@PathVariable Long id) {
        return lightDao.findById(id).map(light -> new LightDto(light)).orElse(null);
    }


    //    @PutMapping(path = "/{id}/switch")
    @RequestMapping(value = "/{id}/switch", method = RequestMethod.GET)
    public List<LightDto> switchStatus(@PathVariable Long id) {
        Light light1 = lightDao.findById(id).orElseThrow(IllegalArgumentException::new);
        light1.setStatus(light1.getStatus() == Status.ON ? Status.OFF : Status.ON);

        Room room = light1.getRoom();
        Long roomId = room.getId();
        return roomDao.findRoomLightsByRoomId(roomId).stream().map(light -> new LightDto(light)).collect(Collectors.toList());
    }

    @RequestMapping(value = "createLight", method = RequestMethod.POST)
    public LightDto create(@RequestBody LightDto dto) {
        Light light = null;
        if (dto.getId() != null) {
            light = lightDao.findById(dto.getId()).orElse(null);
        }

        if (light == null) {
//            roomDao.getOne(dto.getId())
            light = lightDao.save(
                    new Light(
                            roomDao.getOne(
                                    dto.getRoom(),
                                    dto.getLevel(),
                                    dto.getStatus()
                            )
                    )
            );
        } else {
            light.setLevel(dto.getLevel());
            light.setStatus(dto.getStatus());
            lightDao.save(light);
        }

        return new LightDto(light);
    }

    @DeleteMapping(path = "/{id}")
    public void delete(@PathVariable Long id) {
        lightDao.deleteById(id);
    }
}
