package by.borisevich.phone.book.dao;

import by.borisevich.phone.book.domain.UserV2;

import java.util.List;

/**
 * Created by BorisevichDA on 2016-04-22.
 */
public interface UserV2Dao extends GenericDao<UserV2, Long> {


    List<UserV2> getByName(String name);
}
