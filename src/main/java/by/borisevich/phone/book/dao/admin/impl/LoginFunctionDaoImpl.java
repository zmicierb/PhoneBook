package by.borisevich.phone.book.dao.admin.impl;

import by.borisevich.phone.book.dao.admin.LoginFunctionDao;
import by.borisevich.phone.book.dao.impl.GenericDaoImpl;
import by.borisevich.phone.book.dao.util.ListParams;
import by.borisevich.phone.book.domain.admin.LoginFunction;
import by.borisevich.phone.book.domain.admin.LoginFunctionPK;
import org.hibernate.criterion.DetachedCriteria;
import org.hibernate.criterion.Restrictions;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Created by dima on 8/7/16.
 */
@Repository
public class LoginFunctionDaoImpl extends GenericDaoImpl<LoginFunction, LoginFunctionPK> implements LoginFunctionDao {
    public LoginFunctionDaoImpl() {
        super(LoginFunction.class);
    }

    public List<LoginFunction> list(String loginId) {
        DetachedCriteria dc = getDetachedCriteria();
        dc.add(Restrictions.eq("loginId", loginId));
        return getResultList(dc, ListParams.EMPTY);
    }
}
