package by.borisevich.phone.book.service.impl;

import by.borisevich.phone.book.controller.dto.UserDto;
import by.borisevich.phone.book.dao.PostV2Dao;
import by.borisevich.phone.book.dao.UserV2Dao;
import by.borisevich.phone.book.domain.PostV2;
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

    @Transactional(readOnly = true)
    public List<UserDto> getByName(String name) {

        List<UserDto> userDtos = new ArrayList<UserDto>();

        List<UserV2> userV2s = dao.getByName(name);

        for (UserV2 user : userV2s) {
            userDtos.add(new UserDto(user));
        }

        return userDtos;
    }

    @Transactional(readOnly = true)
    public UserDto getById(Long id) {

        UserDto userDto;

        UserV2 userV2 = dao.get(id);

        if (userV2 != null) {
            userDto = new UserDto(userV2);
        } else {
            userDto = null;
        }
        ;

        return userDto;
    }

    @Transactional
    public UserDto create(UserDto userDto) {

        UserV2 userV2 = new UserV2();

        PostV2 postV2 = new PostV2();

        userV2.setId(userDto.getId());
        userV2.setName(userDto.getName());
        userV2.setAddress(userDto.getAddress());
        userV2.setPhone(userDto.getPhone());

        if (userDto.getPost() != null) {
            if (postV2Dao.getByName(userDto.getPost()) != null) {
                postV2 = postV2Dao.getByName(userDto.getPost());
            } else {
                postV2.setPost(userDto.getPost());
                postV2Dao.create(postV2);
            }
        } else {
            postV2 = null;
        }

        userV2.setPostV2(postV2);

        dao.create(userV2);

        return userDto;
    }

    @Transactional
    public UserDto createOrUpdate(UserDto userDto) {
        UserV2 userV2 = new UserV2();

        PostV2 postV2 = new PostV2();

        userV2.setId(userDto.getId());
        userV2.setName(userDto.getName());
        userV2.setAddress(userDto.getAddress());
        userV2.setPhone(userDto.getPhone());

        if (userDto.getPost() != null) {
            if (postV2Dao.getByName(userDto.getPost()) != null) {
                postV2 = postV2Dao.getByName(userDto.getPost());
            } else {
                postV2.setPost(userDto.getPost());
                postV2Dao.create(postV2);
            }
        } else {
            postV2 = null;
        }

        userV2.setPostV2(postV2);

        dao.createOrUpdate(userV2);

        return userDto;
    }

    @Transactional
    public void delete(UserDto userDto) {
        UserV2 userV2 = new UserV2();

        userV2.setId(userDto.getId());
        userV2.setName(userDto.getName());
        userV2.setAddress(userDto.getAddress());
        userV2.setPhone(userDto.getPhone());

        dao.delete(userV2);
    }
}
