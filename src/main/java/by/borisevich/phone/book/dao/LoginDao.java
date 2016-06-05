package by.borisevich.phone.book.dao;

import by.borisevich.phone.book.domain.Login;

import java.util.List;

public interface LoginDao extends GenericDao<Login, Integer> {

    Login findById(Integer id);

    Login findBySSO(String sso);

    void deleteBySSO(String sso);

    List<Login> findAllLogins();

}