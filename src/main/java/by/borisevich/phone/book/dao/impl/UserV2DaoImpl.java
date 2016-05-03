package by.borisevich.phone.book.dao.impl;

import by.borisevich.phone.book.dao.UserV2Dao;
import by.borisevich.phone.book.dao.util.ListParams;
import by.borisevich.phone.book.domain.UserV2;
import org.hibernate.criterion.DetachedCriteria;
import org.hibernate.criterion.Restrictions;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Created by BorisevichDA on 2016-04-22.
 */
@Repository
public class UserV2DaoImpl extends GenericDaoImpl<UserV2, Long> implements UserV2Dao {
    public UserV2DaoImpl() {
        super(UserV2.class);
    }

    public List<UserV2> getByName(String name){
        DetachedCriteria dc = getDetachedCriteria();
        dc.add(Restrictions.eq("name", name));
        return getResultList(dc, ListParams.EMPTY );
    };
}
