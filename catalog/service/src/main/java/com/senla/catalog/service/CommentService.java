package com.senla.catalog.service;

import com.senla.catalog.dao.CommentDao;
import com.senla.catalog.daoapi.ICommentDao;
import com.senla.catalog.entity.Comment;
import com.senla.catalog.serviceapi.ICommentService;

import java.util.List;

public class CommentService implements ICommentService {

    private ICommentDao commentDao;

    public CommentService() {
        commentDao = new CommentDao();
    }

    @Override
    public List<Comment> getAll() {
        return commentDao.getAll();
    }

    @Override
    public void add(Comment comment) {
        commentDao.add(comment);
    }

    @Override
    public Comment get(Integer id) {
        return commentDao.get(id);
    }

    @Override
    public void update(Comment comment) {
        commentDao.update(comment);
    }

    @Override
    public void delete(Comment comment) {
        commentDao.update(comment);
    }
}
