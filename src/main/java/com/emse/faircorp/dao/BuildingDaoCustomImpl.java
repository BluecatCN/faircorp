package com.emse.faircorp.dao;
import com.emse.faircorp.model.Building;
import com.emse.faircorp.model.Room;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;

@Repository
public class BuildingDaoCustomImpl implements BuildingDaoCustom {

    @PersistenceContext
    private EntityManager em;

    @Override
    public List<Room> findBuildingRoomsByBuildingId(Long id) {
        String jpql = "select rm from Room rm join rm.building building where building.id = :id";
        return em.createQuery(jpql, Room.class)
                .setParameter("id", id)
                .getResultList();
    }
}