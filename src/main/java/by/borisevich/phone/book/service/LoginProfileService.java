package by.borisevich.phone.book.service;

import by.borisevich.phone.book.domain.LoginProfile;

public interface LoginProfileService extends GenericService<LoginProfile, Integer> {

    LoginProfile findByType(String type);

}
