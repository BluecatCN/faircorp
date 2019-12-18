package com.emse.faircorp.dao;

import com.emse.faircorp.model.Room;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RoomDao extends JpaRepository<Room, Long>, RoomDaoCustom {
}

