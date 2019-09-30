package com.senla.catalog.service;

import com.senla.catalog.daoapi.ICommentDao;
import com.senla.catalog.entity.Advert;
import com.senla.catalog.entity.Comment;
import com.senla.catalog.service.basic.AbstractService;
import com.senla.catalog.serviceapi.ICommentService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CommentService extends AbstractService<Comment, Integer> implements ICommentService {

    private static final Logger logger = LoggerFactory.getLogger(CommentService.class);

    @Autowired
    private ICommentDao commentDao;

    @Override
    protected Class getChildClass() {
        return CommentService.class;
    }

    @Override
    protected String getDaoClassName() {
        return "commentDao";
    }

    @Override
    protected Class<Comment> getEntityClass() {
        return Comment.class;
    }

    @Override
    public List<Comment> getByAdvert(Advert advert) {

        try {
            return commentDao.getByAdvert(advert);

        } catch (RuntimeException e) {
            logger.error("Get comment list by advert error: " + e.getMessage());
            throw e;
        }
    }
}
