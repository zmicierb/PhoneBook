package by.borisevich.phone.book.controller;

import by.borisevich.phone.book.domain.PostV2;
import by.borisevich.phone.book.service.PostV2Service;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.Collection;

/**
 * Created by dima on 5/4/16.
 */
@RestController
@RequestMapping("/post")
public class PostController {

    @Autowired
    private PostV2Service postV2Service;

    @RequestMapping(value = "/V2", method = RequestMethod.GET)
    public Collection<PostV2> list() {
        return postV2Service.findAll();
    }
}
