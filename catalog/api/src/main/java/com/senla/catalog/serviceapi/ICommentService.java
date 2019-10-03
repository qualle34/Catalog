package com.senla.catalog.serviceapi;

import com.senla.catalog.dto.CommentDto;
import com.senla.catalog.dto.SimpleCommentDto;
import com.senla.catalog.entity.Advert;
import com.senla.catalog.entity.Comment;
import com.senla.catalog.entity.User;
import com.senla.catalog.serviceapi.basic.IGenericService;

import java.util.List;
import java.util.Set;

public interface ICommentService extends IGenericService<Comment, Integer> {

    List<Comment> getByAdvert(Advert advert);

    CommentDto CommentToDto(Comment comment);

    List<SimpleCommentDto> CommentListToDto(List<Comment> commentList);

    List<SimpleCommentDto> CommentSetToDto(Set<Comment> commentList);

    Comment dtoToComment(CommentDto dto, User user , Advert advert);
}
