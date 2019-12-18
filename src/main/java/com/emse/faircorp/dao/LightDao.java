package com.emse.faircorp.dao;

import com.emse.faircorp.model.Light;
import org.springframework.data.jpa.repository.JpaRepository;

public interface LightDao extends JpaRepository<Light, Long>, LightDaoCustom {
}
