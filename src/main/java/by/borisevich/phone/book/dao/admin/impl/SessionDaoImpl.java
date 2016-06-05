package by.borisevich.phone.book.dao.admin.impl;

import by.borisevich.phone.book.dao.admin.SessionDao;
import by.borisevich.phone.book.dao.impl.GenericDaoImpl;
import by.borisevich.phone.book.domain.admin.Session;
import org.springframework.stereotype.Repository;

/**
 * Created by dima on 6/5/16.
 */
@Repository
public class SessionDaoImpl extends GenericDaoImpl<Session, String> implements SessionDao {

    public SessionDaoImpl() {
        super(Session.class);
    }
}
