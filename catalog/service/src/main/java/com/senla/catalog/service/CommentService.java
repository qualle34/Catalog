package com.senla.catalog.service;

import com.senla.catalog.dao.CommentDao;
import com.senla.catalog.daoapi.ICommentDao;
import com.senla.catalog.entity.Comment;
import com.senla.catalog.service.basic.AbstractService;
import com.senla.catalog.serviceapi.ICommentService;
import org.hibernate.Session;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class CommentService extends AbstractService<Comment, Integer> implements ICommentService {

    private static CommentService instance;
    private static final Logger logger = LoggerFactory.getLogger(CommentService.class);
    private ICommentDao commentDao;
    private Session session;

    private CommentService(ICommentDao commentDao, Session session) {
        super(commentDao, session);
        this.commentDao = commentDao;
        this.session = session;
    }

    @Override
    protected Class getChildClass() {
        return CommentService.class;
    }

    public static CommentService getInstance(Session session) {
        ICommentDao commentDao = CommentDao.getInstance(session);

        if (instance == null) {
            instance = new CommentService(commentDao, session);
        }
        return instance;
    }
}
