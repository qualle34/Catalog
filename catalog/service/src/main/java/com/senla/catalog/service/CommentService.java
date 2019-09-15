package com.senla.catalog.service;

import com.senla.catalog.daoapi.ICommentDao;
import com.senla.catalog.daoapi.basic.IGenericDao;
import com.senla.catalog.entity.Comment;
import com.senla.catalog.service.basic.AbstractService;
import com.senla.catalog.serviceapi.ICommentService;
import org.hibernate.Session;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Service;

@Service
public class CommentService extends AbstractService<Comment, Integer> implements ICommentService {

    private static final Logger logger = LoggerFactory.getLogger(CommentService.class);

    @Autowired
    private Session session;

    @Autowired
    private ICommentDao commentDao;

    @Override
    protected Class getChildClass() {
        return CommentService.class;
    }

    @Override
    protected Class<Comment> getEntityClass() {
        return Comment.class;
    }

    public void setSession(Session session) {
        this.session = session;
    }
}
