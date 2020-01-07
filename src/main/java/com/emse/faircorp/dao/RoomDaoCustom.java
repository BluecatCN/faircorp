package com.emse.faircorp.dao;

import com.emse.faircorp.model.Light;
import com.emse.faircorp.model.Room;
import com.emse.faircorp.model.Status;

import java.util.List;

public interface RoomDaoCustom {
    Room findRoomByName();
    List<Light> findRoomLightsByRoomId(Long id);
    List<Light> updateRoomDataRoomId();
}
