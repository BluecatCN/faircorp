package com.emse.faircorp.dao;

import com.emse.faircorp.model.Light;

import java.util.List;

public interface LightDaoCustom {
    List<Light> findOnLights();
    List<Light> findOffLights();
}
