package com.emse.faircorp.dao;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

@Repository
public class BuildingDaoCustomImpl implements BuildingDaoCustom {

    @PersistenceContext
    private EntityManager em;
}