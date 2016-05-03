package by.borisevich.phone.book.dao.impl;

import by.borisevich.phone.book.dao.*;
import by.borisevich.phone.book.domain.User;
import org.springframework.stereotype.Repository;

/**
 * Created by BorisevichDA on 2016-04-19.
 */
@Repository
public class UserDaoImpl extends GenericDaoImpl<User, Long> implements UserDao {

    public UserDaoImpl() {
        super(User.class);
    }
}
