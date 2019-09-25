package com.senla.catalog.dao;

import com.senla.catalog.dao.basic.AbstractDao;
import com.senla.catalog.daoapi.ICommentDao;
import com.senla.catalog.entity.Comment;
import org.hibernate.Session;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class CommentDao extends AbstractDao<Comment, Integer> implements ICommentDao {

    @Autowired
    private Session session;

    @Override
    protected Class<Comment> getEntityClass() {
        return Comment.class;
    }
}
