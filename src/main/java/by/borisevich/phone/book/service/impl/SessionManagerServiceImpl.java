package by.borisevich.phone.book.service.impl;

import by.borisevich.phone.book.dao.admin.DepartmentDao;
import by.borisevich.phone.book.dao.admin.LoginDao;
import by.borisevich.phone.book.dao.admin.SessionDao;
import by.borisevich.phone.book.domain.admin.Login;
import by.borisevich.phone.book.domain.admin.Session;
import by.borisevich.phone.book.service.SessionManagerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.core.Authentication;
import org.springframework.security.web.authentication.WebAuthenticationDetails;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * Created by dima on 6/5/16.
 */
@Service
public class SessionManagerServiceImpl implements SessionManagerService {

    @Autowired
    private SessionDao sessionDao;

    @Autowired
    private LoginDao loginDao;
//    @Autowired
//    private ResetPackageProcedure resetPackageProcedure;

//    @Autowired
//    private MenuDao menuDao;

//    @Autowired
//    private DepartmentDao departmentDao;

//    @Value("${db.logger.level}")
//    private int debugLevel;

    @Transactional
    public Session authentication(Authentication authentication) {
        String name = authentication.getName();
        String password = authentication.getCredentials().toString();
        WebAuthenticationDetails details = (WebAuthenticationDetails) authentication.getDetails();

        Login login = loginDao.get(name);

        //check password

        Session session = new Session(name, details.getSessionId(), details.getRemoteAddress(), login);

        sessionDao.create(session);

        session = sessionDao.get(details.getSessionId());
//        session.setId(details.getSessionId());
//        session.setDebug(debugLevel);

        //получаем меню для пользователя
//        session.setMenu(UserServiceImpl.convertMenu(menuDao.list(false)));

        return session;
    }

//    @Transactional
//    public void logout() {
//        sessionDao.logout();
//    }

    @Transactional
    public void kill(Session session) {
        sessionDao.delete(session);
    }
}
