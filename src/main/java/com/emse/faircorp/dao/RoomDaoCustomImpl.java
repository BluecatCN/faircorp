package com.emse.faircorp.dao;

import com.emse.faircorp.model.Light;
import com.emse.faircorp.model.Room;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;

@Repository
public class RoomDaoCustomImpl implements RoomDaoCustom {

    @PersistenceContext
    private EntityManager em;

    @Override
    public Room findRoomByName() {
        String jpql = "select rm from Room rm where rm.name = :name";
        return em.createQuery(jpql, Room.class)
                .setParameter("name", "Room1")
                .getSingleResult();
    }

    @Override
    public List<Light> findRoomLightsByRoomId(Long id) {
        String jpql = "select lt from Light lt join lt.room rm where rm.id = :id";
        return em.createQuery(jpql, Light.class)
                .setParameter("id", id)
                .getResultList();
    }

    @Override
    public List<Light> updateRoomDataRoomId() {
        return null;
    }

}
