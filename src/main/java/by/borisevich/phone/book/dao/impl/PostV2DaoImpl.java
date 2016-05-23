package by.borisevich.phone.book.dao.impl;

import by.borisevich.phone.book.dao.PostV2Dao;
import by.borisevich.phone.book.dao.util.ListParams;
import by.borisevich.phone.book.domain.PostV2;
import by.borisevich.phone.book.domain.UserV2;
import org.hibernate.criterion.DetachedCriteria;
import org.hibernate.criterion.Restrictions;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Created by BorisevichDA on 2016-04-22.
 */
@Repository
public class PostV2DaoImpl extends GenericDaoImpl<PostV2, Long> implements PostV2Dao {

    public PostV2DaoImpl() {
        super(PostV2.class);
    }

    @Override
    public PostV2 getByName(String name) {
        DetachedCriteria dc = getDetachedCriteria();
        dc.add(Restrictions.eq("post", name));
        List<PostV2> postV2s = getResultList(dc, ListParams.EMPTY);

        if (postV2s.size() == 0) {
            return null;
        } else {
            return postV2s.get(0);
        }

    }

    ;
}
