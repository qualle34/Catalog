package com.senla.catalog.serviceapi;


import com.senla.catalog.entity.Comment;

import java.util.List;

public interface ICommentService {

    List<Comment> getAll();

    void add(Comment comment);

    Comment getById(Integer id);

    void update(Comment comment);

    void delete(Comment comment);
}
