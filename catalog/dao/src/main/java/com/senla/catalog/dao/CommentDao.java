package com.senla.catalog.dao;

import com.senla.catalog.daoapi.ICommentDao;
import com.senla.catalog.entity.Comment;

public class CommentDao extends AbstractDao<Comment, Integer> implements ICommentDao {

    @Override
    protected Class<Comment> getChildClass() {
        return Comment.class;
    }
}
