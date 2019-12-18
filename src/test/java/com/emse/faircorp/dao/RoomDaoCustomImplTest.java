package com.emse.faircorp.dao;

import com.emse.faircorp.model.Status;
import org.assertj.core.api.Assertions;
import org.assertj.core.groups.Tuple;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.context.annotation.Import;
import org.springframework.test.context.junit.jupiter.SpringExtension;

@ExtendWith(SpringExtension.class)
@Import(RoomDaoCustomImpl.class)
@DataJpaTest
public class RoomDaoCustomImplTest {

    @Autowired
    private RoomDao roomDao;

    @Test
    public void shouldFindRoomByName() {
        Assertions.assertThat(roomDao.findRoomByName())
                .extracting("id", "name", "floor")
                .containsExactly(Tuple.tuple(-10, "Room1", 1));
    }

}
