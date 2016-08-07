package by.borisevich.phone.book.dao.admin;

import by.borisevich.phone.book.dao.GenericDao;
import by.borisevich.phone.book.domain.admin.LoginFunction;
import by.borisevich.phone.book.domain.admin.LoginFunctionPK;

import java.util.List;

/**
 * Created by dima on 8/7/16.
 */
public interface LoginFunctionDao extends GenericDao<LoginFunction, LoginFunctionPK> {

    List<LoginFunction> list(String loginId);
}
