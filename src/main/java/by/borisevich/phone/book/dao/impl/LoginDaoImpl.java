package by.borisevich.phone.book.dao.impl;


import java.util.List;

import by.borisevich.phone.book.dao.LoginDao;
import by.borisevich.phone.book.dao.util.ListParams;
import by.borisevich.phone.book.domain.Login;
import org.hibernate.Criteria;
import org.hibernate.Hibernate;
import org.hibernate.criterion.DetachedCriteria;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Restrictions;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Repository;

@Repository("loginDao")
public class LoginDaoImpl extends GenericDaoImpl<Login, Integer> implements LoginDao {

    static final Logger logger = LoggerFactory.getLogger(LoginDaoImpl.class);

    public LoginDaoImpl() {
        super(Login.class);
    }

    public Login findById(Integer id) {
        Login login = get(id);
        if (login != null) {
            Hibernate.initialize(login.getLoginProfiles());
        }
        return login;
    }

    public Login findBySSO(String sso) {
        logger.info("SSO : {}", sso);
        DetachedCriteria dc = getDetachedCriteria();
        dc.add(Restrictions.eq("ssoId", sso));
        List<Login> logins = (List<Login>) getResultList(dc, ListParams.EMPTY);

        if (logins.size() == 0)
            return null;
        Login login = logins.get(0);
        Hibernate.initialize(login.getLoginProfiles());
        return login;
    }

    @SuppressWarnings("unchecked")
    public List<Login> findAllLogins() {
        DetachedCriteria dc = getDetachedCriteria().addOrder(Order.asc("firstName"));
        dc.setResultTransformer(Criteria.DISTINCT_ROOT_ENTITY);//To avoid duplicates.
        List<Login> logins = (List<Login>) getResultList(dc, ListParams.EMPTY);

        // No need to fetch userProfiles since we are not showing them on list page. Let them lazy load.
        // Uncomment below lines for eagerly fetching of userProfiles if you want.
        /*
        for(User user : users){
            Hibernate.initialize(user.getUserProfiles());
        }*/
        return logins;
    }

    public void deleteBySSO(String sso) {
        DetachedCriteria dc = getDetachedCriteria();
        dc.add(Restrictions.eq("ssoId", sso));
        List<Login> logins = (List<Login>) getResultList(dc, ListParams.EMPTY);

        if (logins.size() == 0)
            return;
        Login login = logins.get(0);
        delete(login);
    }

}
