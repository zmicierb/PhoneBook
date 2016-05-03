package by.borisevich.phone.book.service.impl;

import by.borisevich.phone.book.dao.DictPostDao;
import by.borisevich.phone.book.domain.DictPost;
import by.borisevich.phone.book.service.DictPostService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Created by BorisevichDA on 2016-04-21.
 */
@Service
public class DictPostServiceImpl extends GenericServiceImpl<DictPost, Long> implements DictPostService {

    @Autowired
    private DictPostDao dao;

    @Autowired
    public DictPostServiceImpl(DictPostDao dao) {
        super(dao);
        this.dao = dao;
    }
}
