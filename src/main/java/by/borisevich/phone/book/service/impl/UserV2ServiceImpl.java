package by.borisevich.phone.book.service.impl;

import by.borisevich.phone.book.controller.dto.UserDto;
import by.borisevich.phone.book.dao.PostV2Dao;
import by.borisevich.phone.book.dao.UserV2Dao;
import by.borisevich.phone.book.domain.UserV2;
import by.borisevich.phone.book.service.UserV2Service;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by BorisevichDA on 2016-04-22.
 */
@Service
public class UserV2ServiceImpl extends GenericServiceImpl<UserV2, Long> implements UserV2Service {
    @Autowired
    private UserV2Dao dao;

    @Autowired
    private PostV2Dao postV2Dao;

    @Autowired
    public UserV2ServiceImpl(UserV2Dao dao) {
        super(dao);
        this.dao = dao;
    }

    @Transactional(readOnly = true)
    public List<UserDto> find() {

        List<UserDto> userDtos = new ArrayList<UserDto>();

        List<UserV2> userV2s = dao.findAll();

        for (UserV2 user : userV2s) {
            userDtos.add(new UserDto(user));
        }

        return userDtos;
    }

    ;

    @Transactional(readOnly = true)
    public List<UserDto> getByName(String name) {

        List<UserDto> userDtos = new ArrayList<UserDto>();

        List<UserV2> userV2s = dao.getByName(name);

        for (UserV2 user : userV2s) {
            userDtos.add(new UserDto(user));
        }

        return userDtos;
    }

    ;
}
