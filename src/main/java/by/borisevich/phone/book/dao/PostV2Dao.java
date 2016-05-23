package by.borisevich.phone.book.dao;

import by.borisevich.phone.book.domain.PostV2;

/**
 * Created by BorisevichDA on 2016-04-22.
 */
public interface PostV2Dao extends GenericDao<PostV2, Long> {

    PostV2 getByName(String name);
}
