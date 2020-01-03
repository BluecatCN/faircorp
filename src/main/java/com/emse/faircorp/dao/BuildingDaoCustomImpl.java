package com.emse.faircorp.dao;
import com.emse.faircorp.model.Building;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;

@Repository
public class BuildingDaoCustomImpl implements BuildingDaoCustom {

    @PersistenceContext
    private EntityManager em;

    @Override
    public List<Building> findBuildingRoomsByBuildingId(Long id) {
        String jpql = "select rm from Room rm join rm.building building where building.id = :id";
        return em.createQuery(jpql, Building.class)
                .setParameter("id", id)
                .getResultList();
    }
}