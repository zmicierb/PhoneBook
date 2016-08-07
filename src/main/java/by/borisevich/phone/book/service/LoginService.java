package by.borisevich.phone.book.service;

import by.borisevich.phone.book.controller.dto.LoginInfoDto;
import by.borisevich.phone.book.controller.dto.LoginPlainDto;
import by.borisevich.phone.book.controller.dto.MenuDto;
import by.borisevich.phone.book.dao.util.ListParams;
import by.borisevich.phone.book.domain.admin.Function;
import by.borisevich.phone.book.domain.admin.Login;
import org.springframework.security.core.userdetails.UserDetailsService;

import java.util.List;

/**
 * Created by dima on 8/6/16.
 */
public interface LoginService extends UserDetailsService {

    Login get(String id);

    //TODO menu by login
    List<MenuDto> menu();

    void delete(String id);

    LoginPlainDto update(LoginPlainDto user);

    LoginPlainDto create(LoginPlainDto user);

//    List<VUser> vList(Date bDate, ListParams lp);

    LoginPlainDto getLogin(String id);

    List<LoginInfoDto> find(Login login, ListParams lp);

    List<LoginInfoDto> find(Long deptId, ListParams lp);

    List<Login> findAllLogins(String query, ListParams params);

    List<Function> functionList(ListParams params);
}
