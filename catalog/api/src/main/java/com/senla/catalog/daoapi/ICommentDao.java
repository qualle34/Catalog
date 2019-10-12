package com.senla.catalog.daoapi;

import com.senla.catalog.daoapi.basic.IGenericDao;
import com.senla.catalog.entity.Comment;

import java.util.List;

public interface ICommentDao extends IGenericDao<Comment, Long> {

    List<Comment> getByAdvertId(long advertId);

    void delete(long id);
}
