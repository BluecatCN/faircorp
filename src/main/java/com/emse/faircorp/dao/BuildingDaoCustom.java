package com.emse.faircorp.dao;
import com.emse.faircorp.model.Room;

import java.util.List;

public interface BuildingDaoCustom {
    List<Room> findBuildingRoomsByBuildingId(Long id);
}
