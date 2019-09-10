package com.senla.catalog.dao;

import com.senla.catalog.dao.basic.AbstractDao;
import com.senla.catalog.daoapi.ICommentDao;
import com.senla.catalog.entity.Comment;
import org.hibernate.Session;

public class CommentDao extends AbstractDao<Comment, Integer> implements ICommentDao {

    public CommentDao(Session session) {
        super(session);
    }

    @Override
    protected Class<Comment> getChildClass() {
        return Comment.class;
    }
}
