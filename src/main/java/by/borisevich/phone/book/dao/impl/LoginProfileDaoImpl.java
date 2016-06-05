package by.borisevich.phone.book.dao.impl;

import java.util.List;

import by.borisevich.phone.book.dao.LoginProfileDao;
import by.borisevich.phone.book.dao.util.ListParams;
import by.borisevich.phone.book.domain.LoginProfile;
import org.hibernate.criterion.DetachedCriteria;
import org.hibernate.criterion.Restrictions;
import org.springframework.stereotype.Repository;

@Repository("loginProfileDao")
public class LoginProfileDaoImpl extends GenericDaoImpl<LoginProfile, Integer> implements LoginProfileDao {

    public LoginProfileDaoImpl() {
        super(LoginProfile.class);
    }

    public LoginProfile findByType(String type) {
        DetachedCriteria dc = getDetachedCriteria();
        dc.add(Restrictions.eq("type", type));

        List<LoginProfile> loginProfiles = getResultList(dc, ListParams.EMPTY);

        if (loginProfiles.size() == 0)
            return null;

        LoginProfile loginProfile = loginProfiles.get(0);

        return loginProfile;
    }

}