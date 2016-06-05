package by.borisevich.phone.book.dao.admin.impl;

import by.borisevich.phone.book.dao.admin.LoginDao;
import by.borisevich.phone.book.dao.impl.GenericDaoImpl;
import by.borisevich.phone.book.domain.admin.Login;
import org.springframework.stereotype.Repository;

/**
 * Created by dima on 6/5/16.
 */
@Repository
public class LoginDaoImpl extends GenericDaoImpl<Login, String> implements LoginDao {

    public LoginDaoImpl() {
        super(Login.class);
    }
}
