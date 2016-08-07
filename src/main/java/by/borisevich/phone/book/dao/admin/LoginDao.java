package by.borisevich.phone.book.dao.admin;

import by.borisevich.phone.book.controller.dto.LoginInfoDto;
import by.borisevich.phone.book.dao.GenericDao;
import by.borisevich.phone.book.dao.util.ListParams;
import by.borisevich.phone.book.domain.admin.Login;

import java.util.List;

/**
 * Created by dima on 6/5/16.
 */
public interface LoginDao extends GenericDao<Login, String> {

    List<LoginInfoDto> find(Login searchLogin, ListParams params);

    List<LoginInfoDto> find(Long deptId, ListParams params);

    List<Login> findAllLogins(String query, ListParams params);
}
