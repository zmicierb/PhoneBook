package by.borisevich.phone.book.controller;

import by.borisevich.phone.book.controller.dto.UserDto;
import by.borisevich.phone.book.domain.User;
import by.borisevich.phone.book.domain.UserV2;
import by.borisevich.phone.book.service.UserService;
import by.borisevich.phone.book.service.UserV2Service;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Collection;

/**
 * Created by BorisevichDA on 2016-04-11.
 */
@RestController
@RequestMapping("/api/user")
public class UserController {

    @Autowired
    private UserService userService;

    @Autowired
    private UserV2Service userV2Service;

    @RequestMapping(value = "/", method = RequestMethod.GET)
    public Collection<User> list() {
        return userService.findAll();
    }

    @RequestMapping(value = "/V2", method = RequestMethod.GET)
    public Collection<UserDto> listV2() {
        return userV2Service.find();
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    public UserDto getById(@PathVariable Long id) {
        return userV2Service.getById(id);
    }

    @RequestMapping(value = "/", method = RequestMethod.POST)
    public void create(@RequestBody UserDto user) {
        userV2Service.create(user);
    }

    @RequestMapping(value = "/", method = RequestMethod.PUT)
    public void update(@RequestBody UserDto user) {
        userV2Service.createOrUpdate(user);
    }

    @RequestMapping(value = "/delete", method = RequestMethod.PUT)
    public void delete(@RequestBody UserDto user) {
        userV2Service.delete(user);
    }
}
