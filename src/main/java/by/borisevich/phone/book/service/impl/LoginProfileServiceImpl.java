package by.borisevich.phone.book.service.impl;

import by.borisevich.phone.book.dao.LoginProfileDao;
import by.borisevich.phone.book.domain.LoginProfile;
import by.borisevich.phone.book.service.LoginProfileService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;


@Service("loginProfileService")
@Transactional
public class LoginProfileServiceImpl extends GenericServiceImpl<LoginProfile, Integer> implements LoginProfileService {

    @Autowired
    LoginProfileDao dao;

    @Autowired
    public LoginProfileServiceImpl(LoginProfileDao dao) {
        super(dao);
        this.dao = dao;
    }

    public LoginProfile findByType(String type) {
        return dao.findByType(type);
    }

}