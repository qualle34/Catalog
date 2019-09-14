package com.senla.catalog.dao;

import com.senla.catalog.dao.basic.AbstractDao;
import com.senla.catalog.dao.util.HibernateUtil;
import com.senla.catalog.daoapi.ICommentDao;
import com.senla.catalog.entity.Comment;
import org.hibernate.Session;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Repository;

@Repository
public class CommentDao extends AbstractDao<Comment, Integer> implements ICommentDao {

    private static final Logger logger = LoggerFactory.getLogger(CommentDao.class);

    @Autowired
    private Session session;

    @Override
    protected Class getChildClass() {
        return CommentDao.class;
    }

    @Override
    protected Class<Comment> getEntityClass() {
        return Comment.class;
    }

    @Override
    protected Session getSession() {
        return session;
    }

    @Bean
    public CommentDao getInstance() {
        return new CommentDao();
    }

}
