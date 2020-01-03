package com.emse.faircorp.dao;

import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.context.annotation.Import;
import org.springframework.test.context.junit.jupiter.SpringExtension;

@ExtendWith(SpringExtension.class)
@Import(BuildingDaoCustomImpl.class)
@DataJpaTest
public class BuildingDaoCustomImplTest {

    @Autowired
    private BuildingDao buildingDao;

}
