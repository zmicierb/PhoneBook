package by.borisevich.phone.book.dao;

import by.borisevich.phone.book.controller.dto.UserDto;
import by.borisevich.phone.book.service.UserV2Service;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.transaction.TransactionConfiguration;

import java.util.List;


@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = "classpath:applicationContext.xml")
@TransactionConfiguration(defaultRollback = true, transactionManager = "transactionManager")
public class LoginDaoImplTest {

    @Autowired
    private UserV2Service userV2Service;

    @Test
    public void testCreate() {

//        User user = new User("Kate","22","222");
//
//        userService.create(user);
//
//        userService.delete(user);

//        DictPost dictPost = new DictPost("manager");
//
//        Position post = new Position();
//
//        post.setUserId(user.getId());
//        post.setPostId(dict.getId());
//        post.setPostV2(dictPost);
//        post.setUser(user);
//
//       Position p = positionService.create(post);

//        Assert.assertEquals(p.getId(), post.getId());

        List<UserDto> userDtoList = userV2Service.find();

        for (UserDto user : userDtoList) {
            System.out.println("User: " + user.getName());
//            for(UserV2 user:post.getUser()) {

            System.out.println("    PostV2: " + user.getPost());
//            }
        }

    }

}