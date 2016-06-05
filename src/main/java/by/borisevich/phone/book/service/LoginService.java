package by.borisevich.phone.book.service;

import by.borisevich.phone.book.domain.Login;

import java.util.List;

public interface LoginService extends GenericService<Login, Integer> {

    Login findBySSO(String sso);

    void saveLogin(Login user);

    void updateLogin(Login user);

    void deleteLoginBySSO(String sso);

    boolean isLoginSSOUnique(Integer id, String sso);

}
