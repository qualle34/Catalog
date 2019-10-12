package com.senla.catalog.serviceapi;

import com.senla.catalog.dto.advert.CommentDto;
import com.senla.catalog.dto.advert.SimpleCommentDto;
import com.senla.catalog.entity.Advert;
import com.senla.catalog.entity.Comment;
import com.senla.catalog.entity.User;
import com.senla.catalog.serviceapi.basic.IGenericService;

import java.util.Collection;
import java.util.List;
import java.util.Set;

public interface ICommentService extends IGenericService<Comment, Long> {

    List<Comment> getByAdvertId(long advertId);

    CommentDto commentToDto(Comment comment);

    Comment dtoToComment(CommentDto dto, User user , Advert advert);

    List<SimpleCommentDto> commentsToDto(Collection<Comment> commentList);

    void add(CommentDto dto);

    void delete(long id);
}