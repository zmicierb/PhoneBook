package by.borisevich.phone.book.service.impl;

import by.borisevich.phone.book.dao.PositionDao;
import by.borisevich.phone.book.domain.Position;
import by.borisevich.phone.book.service.PositionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Created by BorisevichDA on 2016-04-21.
 */
@Service
public class PositionServiceImpl extends GenericServiceImpl<Position, Long> implements PositionService {

    @Autowired
    private PositionDao dao;

    @Autowired
    public PositionServiceImpl(PositionDao dao) {
        super(dao);
        this.dao = dao;
    }
}
