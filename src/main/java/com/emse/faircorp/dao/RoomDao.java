package com.emse.faircorp.dao;

import com.emse.faircorp.model.Light;
import com.emse.faircorp.model.Room;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Arrays;
import java.util.List;

public interface RoomDao extends JpaRepository<Room, Long>, RoomDaoCustom {
    @Override
    default List<Light> updateRoomDataRoomId() {
        return null;
    }


}

