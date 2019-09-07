package com.senla.catalog.daoapi;

import com.senla.catalog.entity.Comment;

import java.util.List;

public interface ICommentDao extends IGenericDao<Comment, Integer> {

    @Override
    List<Comment> getAll();

    @Override
    void add(Comment comment);

    @Override
    Comment get(Integer integer);

    @Override
    void update(Comment comment);

    @Override
    void delete(Comment comment);
}
