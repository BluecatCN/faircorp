package com.emse.faircorp.dao;
import com.emse.faircorp.model.Building;

import java.util.List;

public interface BuildingDaoCustom {
    List<Building> findBuildingRoomsByBuildingId(Long id);
}
