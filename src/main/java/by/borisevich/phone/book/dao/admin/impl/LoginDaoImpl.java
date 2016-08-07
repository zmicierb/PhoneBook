package by.borisevich.phone.book.dao.admin.impl;

import by.borisevich.phone.book.controller.dto.LoginInfoDto;
import by.borisevich.phone.book.dao.admin.LoginDao;
import by.borisevich.phone.book.dao.impl.GenericDaoImpl;
import by.borisevich.phone.book.dao.util.ListParams;
import by.borisevich.phone.book.domain.admin.Login;
import org.hibernate.criterion.DetachedCriteria;
import org.hibernate.criterion.Restrictions;
import org.springframework.stereotype.Repository;
import org.apache.commons.lang3.StringUtils;

import java.util.List;

/**
 * Created by dima on 6/5/16.
 */
@Repository
public class LoginDaoImpl extends GenericDaoImpl<Login, String> implements LoginDao {

    public LoginDaoImpl() {
        super(Login.class);
    }

    //search in the same dept
    public List<LoginInfoDto> find(Login login, ListParams params) {
        Long deptId = login.getDepartment().getId();
        DetachedCriteria dc = getDetachedCriteria();
//        dc.add(Restrictions.sqlRestriction("dept_id in (select id from dict.dept start with id = ? connect by prior id = parent_id)", deptId, StandardBasicTypes.LONG));
        dc.add(Restrictions.eq("deptId", deptId));

        return getResultList(dc, params);
    }

    public List<LoginInfoDto> find(Long deptId, ListParams params) {
        DetachedCriteria dc = getDetachedCriteria();
        dc.add(Restrictions.eq("deptId", deptId));

        return getResultList(dc, params);
    }

    public List<Login> findAllLogins(String query, ListParams params) {
        DetachedCriteria dc = getDetachedCriteria();
        dc.add(Restrictions.isNotNull("notaryId"));
        if (StringUtils.isNotBlank(query))
            dc.add(Restrictions.like("name", "%" + query + "%").ignoreCase());

        return getResultList(dc, params);
    }
}
