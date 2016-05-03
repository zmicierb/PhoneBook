package by.borisevich.phone.book.dao.impl;

import by.borisevich.phone.book.dao.PostV2Dao;
import by.borisevich.phone.book.domain.PostV2;
import org.springframework.stereotype.Repository;

/**
 * Created by BorisevichDA on 2016-04-22.
 */
@Repository
public class PostV2DaoImpl extends GenericDaoImpl<PostV2, Long> implements PostV2Dao {

    public PostV2DaoImpl() {
        super(PostV2.class);
    }
}
