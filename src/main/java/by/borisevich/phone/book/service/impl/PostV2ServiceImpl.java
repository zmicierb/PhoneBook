package by.borisevich.phone.book.service.impl;

import by.borisevich.phone.book.dao.PostV2Dao;
import by.borisevich.phone.book.domain.PostV2;
import by.borisevich.phone.book.service.PostV2Service;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Created by dima on 5/4/16.
 */
@Service
public class PostV2ServiceImpl extends GenericServiceImpl<PostV2, Long> implements PostV2Service {

    @Autowired
    private PostV2Dao dao;

    @Autowired
    public PostV2ServiceImpl(PostV2Dao dao) {
        super(dao);
        this.dao = dao;
    }
}
