package com.senla.catalog.dao;

import com.senla.catalog.dao.basic.AbstractDao;
import com.senla.catalog.daoapi.ICommentDao;
import com.senla.catalog.entity.Comment;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

@Repository
public class CommentDao extends AbstractDao<Comment, Integer> implements ICommentDao {

    @PersistenceContext
    private EntityManager entityManager;

    @Override
    protected Class<Comment> getEntityClass() {
        return Comment.class;
    }
}
