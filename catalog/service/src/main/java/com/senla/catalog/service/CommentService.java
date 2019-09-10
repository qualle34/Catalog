package com.senla.catalog.service;

import com.senla.catalog.daoapi.ICommentDao;
import com.senla.catalog.entity.Comment;
import com.senla.catalog.service.basic.AbstractService;
import com.senla.catalog.serviceapi.ICommentService;
import org.hibernate.Session;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class CommentService extends AbstractService<Comment, Integer> implements ICommentService {

    private static final Logger logger = LoggerFactory.getLogger(CommentService.class);
    private ICommentDao commentDao;
    private Session session;

    public CommentService(ICommentDao commentDao, Session session) {
        super(commentDao, session);
        this.commentDao = commentDao;
        this.session = session;
    }
}
