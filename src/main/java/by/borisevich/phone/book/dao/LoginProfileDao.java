package by.borisevich.phone.book.dao;

import by.borisevich.phone.book.domain.LoginProfile;

public interface LoginProfileDao extends GenericDao<LoginProfile, Integer> {

    LoginProfile findByType(String type);
}
