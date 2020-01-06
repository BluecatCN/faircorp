package com.emse.faircorp.controller;

import com.emse.faircorp.dao.BuildingDao;
import com.emse.faircorp.dto.BuildingDto;
import com.emse.faircorp.dto.RoomDto;
import com.emse.faircorp.model.Building;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletResponse;
import javax.transaction.Transactional;
import java.util.List;
import java.util.stream.Collectors;

@RestController
//@CrossOrigin(origins = "*", allowedHeaders = "*")
@RequestMapping("/api/buildings")
@Transactional
public class BuildingController {

    public void addHeaders (HttpServletResponse response) {
        response.addHeader("access-control-allow-credentials", "true");
        response.addHeader("access-control-allow-headers", "Origin,Accept,X-Requested-With,Content-Type,X-Auth-Token,Access-Control-Request-Method,Access-Control-Request-Headers,Authorization");
        response.addHeader("access-control-allow-origin", "*");
        response.addHeader("content-type", "application/json;charset=UTF-8");
    }

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
    public List<RoomDto> findRoomsByBuilding(@PathVariable Long id) {
        return buildingDao.findBuildingRoomsByBuildingId(id).stream().map(room -> new RoomDto(room)).collect(Collectors.toList());
    }

    @PostMapping
    public BuildingDto create(@RequestBody BuildingDto dto) {
        Building building = null;
        if (dto.getId() != null) {
            building = buildingDao.findById(dto.getId()).orElse(null);
        }
        if (building == null) {
            building = buildingDao.save(new Building(buildingDao.getOne(dto.getId()), dto.getName()));
        } else {
            building.setName(dto.getName());
            buildingDao.save(building);
        }
        return new BuildingDto(building);
    }

}
