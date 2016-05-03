package by.borisevich.phone.book.service.impl;

import by.borisevich.phone.book.domain.User;
import by.borisevich.phone.book.dao.UserDao;
import by.borisevich.phone.book.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Created by BorisevichDA on 2016-04-21.
 */
@Service
public class UserServiceImpl extends GenericServiceImpl<User, Long> implements UserService {

    @Autowired
    private UserDao dao;

    @Autowired
    public UserServiceImpl(UserDao dao) {
        super(dao);
        this.dao = dao;
    }
}
