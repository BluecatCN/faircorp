package com.emse.faircorp.controller;

import com.emse.faircorp.dao.BuildingDao;
import com.emse.faircorp.dto.BuildingDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.transaction.Transactional;
import java.util.List;
import java.util.stream.Collectors;

@RestController
//@CrossOrigin(origins = "*", allowedHeaders = "*")
@RequestMapping("/api/buildings")
@Transactional
public class BuildingController {

    @Autowired
    private BuildingDao buildingDao;

    @GetMapping
    public List<BuildingDto> findAll() {
        return buildingDao.findAll()
                .stream()
                .map(BuildingDto::new)
                .collect(Collectors.toList());
    }

    @GetMapping(path = "/{id}")
    public BuildingDto findById(@PathVariable Long id) {
        return buildingDao.findById(id).
                map(building -> new BuildingDto(building)).
                orElse(null);
    }


    @GetMapping(path = "getRooms/{id}")
    public List<BuildingDto> findRoomsByBuilding(@PathVariable Long id) {
        return buildingDao.findBuildingRoomsByBuildingId(id).stream().map(building -> new BuildingDto(building)).collect(Collectors.toList());
    }



}
