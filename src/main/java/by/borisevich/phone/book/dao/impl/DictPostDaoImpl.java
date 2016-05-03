package by.borisevich.phone.book.dao.impl;

import by.borisevich.phone.book.dao.DictPostDao;
import by.borisevich.phone.book.domain.DictPost;
import org.springframework.stereotype.Repository;

/**
 * Created by BorisevichDA on 2016-04-21.
 */
@Repository
public class DictPostDaoImpl extends GenericDaoImpl<DictPost, Long> implements DictPostDao {

    public DictPostDaoImpl() {
        super(DictPost.class);
    }
}
