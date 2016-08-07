package by.borisevich.phone.book.service.impl;

import by.borisevich.phone.book.controller.dto.LoginInfoDto;
import by.borisevich.phone.book.controller.dto.LoginPlainDto;
import by.borisevich.phone.book.controller.dto.MenuDto;
import by.borisevich.phone.book.dao.admin.*;
import by.borisevich.phone.book.dao.util.ListParams;
import by.borisevich.phone.book.domain.admin.*;
import by.borisevich.phone.book.service.LoginService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.support.MessageSourceAccessor;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.SpringSecurityMessageSource;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.*;

/**
 * Created by dima on 8/6/16.
 */
@Service
public class LoginServiceImpl implements LoginService {

    private static final Logger log = LoggerFactory.getLogger(LoginServiceImpl.class);
    protected final MessageSourceAccessor messages = SpringSecurityMessageSource
            .getAccessor();
    @Autowired
    private MenuDao menuDao;
    @Autowired
    private LoginDao loginDao;
    @Autowired
    private DepartmentDao deptDao;
    @Autowired
    private FunctionDao functionDao;
    @Autowired
    private LoginFunctionDao loginFunctionDao;
//    @Autowired
//    private VUserDao vUserDao;


    @Transactional
    public List<MenuDto> menu() {
        List<Menu> menus = menuDao.findAll();
        List<MenuDto> menuDtos = new ArrayList<MenuDto>();
        if (menus.size() > 0) {
            for (Menu menu : menus) {
                menuDtos.add(new MenuDto(menu));
            }
        }
        return menuDtos;
    }

    @Transactional
    public void delete(String id) {
        Login loginFull = loginDao.get(id);
        if (loginFull != null) {
            List<LoginFunction> loginFunctions = loginFunctionDao.list(id);
            if (loginFunctions != null) {
                for (LoginFunction loginFunction : loginFunctions) {
                    loginFunctionDao.delete(loginFunction);
                }
            }
            loginDao.delete(loginFull);
        }
    }

    @Transactional
    public LoginPlainDto update(LoginPlainDto login) {
        Login oldLogin = loginDao.get(login.getId());
        if (login.getPassword() == null) {
            login.setPassword(oldLogin.getPassword());
        }
        for (LoginLock loginLock : oldLogin.getLoginLocks()) {
            boolean found = false;
            for (LoginLock newLock : login.getLoginLocks()) {
                if (loginLock.getId().equals(newLock.getId())) {
                    found = true;
                    break;
                }
            }
            if (!found) {
                //Locks can not be deleted from this list
                login.getLoginLocks().add(loginLock);
            }
        }
        Login loginFull = login.asLogin();
        if (login.getDeptId() != null) {
            loginFull.setDepartment(deptDao.get(login.getDeptId()));
        }
        List<LoginFunction> oldLoginFunction = loginFunctionDao.list(oldLogin.getId());//may be oldLogin
        for (LoginFunction loginFunction : oldLoginFunction) {
            loginFunctionDao.delete(loginFunction);
        }
        List<LoginFunction> loginFunctions = login.asLoginFunctionList();
        if (loginFunctions != null) {
            for (LoginFunction loginFunction : loginFunctions) {
                loginFunctionDao.create(loginFunction);
            }
        }
        loginDao.merge(loginFull);
        List<Function> functions = functionDao.findAll();
        return new LoginPlainDto(loginDao.get(login.getId()), loginFunctions, functions);
    }

    @Transactional
    public LoginPlainDto create(LoginPlainDto login) {
        Login loginFull = login.asLogin();
        if (login.getDeptId() != null) {
            loginFull.setDepartment(deptDao.get(login.getDeptId()));
        }
        loginFull.setPassword("123"); //TODO ставим дефолтный пароль при создании пользователя
        String id = loginDao.create(loginFull);
        List<LoginFunction> loginFunctions = login.asLoginFunctionList();
        if (loginFunctions != null) {
            for (LoginFunction loginFunction : loginFunctions) {
                loginFunctionDao.create(loginFunction);
            }
        }
        List<Function> functions = functionDao.findAll();
        return new LoginPlainDto(loginDao.get(id), loginFunctions, functions);
    }

    @Transactional
    public LoginPlainDto getLogin(String id) {
        Login login = loginDao.get(id);
        List<Function> functions = functionDao.findAll();
        List<LoginFunction> loginFunctionList = loginFunctionDao.list(id);
        LoginPlainDto loginPlainDto = new LoginPlainDto(login, loginFunctionList, functions);
        return loginPlainDto;
    }

//    @Transactional
//    @DatabaseLogin
//    public List<VUser> vList(Date bDate, ListParams params) {
//        return vUserDao.findAllByDate(bDate, params);
//    }

    @Transactional(readOnly = true)
    public List<LoginInfoDto> find(Login searchLogin, ListParams params) {
        List<LoginInfoDto> list = loginDao.find(searchLogin, params);

        return list;
    }

    @Transactional(readOnly = true)
    public List<LoginInfoDto> find(Long deptId, ListParams params) {
        List<LoginInfoDto> list = loginDao.find(deptId, params);

        return list;
    }

    @Transactional(readOnly = true)
    public List<Login> findAllLogins(String query, ListParams params) {
        List<Login> list = loginDao.findAllLogins(query, params);

        return list;
    }

    @Transactional(readOnly = true)
    public List<Function> functionList(ListParams params) {
//        List<AppFunctionDto> functionDtos = new ArrayList<>();
        List<Function> functions = functionDao.findAll(params);
        return functions;
    }

    @Transactional(readOnly = true)
    public Login get(String id) {
        return loginDao.get(id);
    }

    @Transactional(readOnly = true)
    public UserDetails loadUserByUsername(String login) throws UsernameNotFoundException {

        Login u = loginDao.get(login);
        if (u == null) {
            log.debug("Query returned no results for user '" + login + "'");
            throw new UsernameNotFoundException(
                    this.messages.getMessage("userService.notFound",
                            new Object[]{login}, "Username {0} not found"));
        }


        List<LoginFunction> functions = loginFunctionDao.list(login);
        List<GrantedAuthority> dbAuths = new ArrayList<GrantedAuthority>(functions.size());
        for (LoginFunction function : functions)
            dbAuths.add(new SimpleGrantedAuthority(function.getFunctionId().toUpperCase()));

        if (dbAuths.size() == 0) {
            log.debug("User '" + login + "' has no authorities'");
        }

        UserDetails user = new org.springframework.security.core.userdetails.User(
                u.getId(),
                u.getPassword(),
                true, true, true, true, dbAuths
        );

        return user;
    }
}
