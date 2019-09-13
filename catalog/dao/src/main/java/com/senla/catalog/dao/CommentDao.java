package com.senla.catalog.dao;

import com.senla.catalog.dao.basic.AbstractDao;
import com.senla.catalog.daoapi.ICommentDao;
import com.senla.catalog.entity.Comment;
import org.hibernate.Session;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class CommentDao extends AbstractDao<Comment, Integer> implements ICommentDao {

    private static CommentDao instance;
    private static final Logger logger = LoggerFactory.getLogger(CommentDao.class);
    private Session session;

    private CommentDao(Session session) {
        super(session);
        this.session = session;
    }

    @Override
    protected Class<Comment> getChildClass() {
        return Comment.class;
    }

    public static CommentDao getInstance(Session session) {

        if (instance == null) {
            instance = new CommentDao(session);
        }
        return instance;
    }

}
