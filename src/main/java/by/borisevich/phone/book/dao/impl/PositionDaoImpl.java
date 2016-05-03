package by.borisevich.phone.book.dao.impl;

import by.borisevich.phone.book.dao.PositionDao;
import by.borisevich.phone.book.domain.Position;
import org.springframework.stereotype.Repository;

/**
* Created by BorisevichDA on 2016-04-19.
*/
@Repository
public class PositionDaoImpl extends GenericDaoImpl<Position, Long> implements PositionDao {

    public PositionDaoImpl() {
        super(Position.class);
    }
}
