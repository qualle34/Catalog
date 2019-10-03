package com.senla.catalog.service;

import com.senla.catalog.daoapi.ICommentDao;
import com.senla.catalog.dto.CommentDto;
import com.senla.catalog.dto.SimpleCommentDto;
import com.senla.catalog.entity.Advert;
import com.senla.catalog.entity.Comment;
import com.senla.catalog.entity.User;
import com.senla.catalog.service.basic.AbstractService;
import com.senla.catalog.serviceapi.IAdvertService;
import com.senla.catalog.serviceapi.ICommentService;
import com.senla.catalog.serviceapi.IUserService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.LinkedList;
import java.util.List;
import java.util.Set;

@Service
public class CommentService extends AbstractService<Comment, Integer> implements ICommentService {

    private static final Logger logger = LoggerFactory.getLogger(CommentService.class);

    @Autowired
    private ICommentDao commentDao;

    @Autowired
    private IUserService userService;

    @Autowired
    private IAdvertService advertService;

    @Override
    protected String getDaoClassName() {
        return "commentDao";
    }

    @Override
    protected Class<Comment> getEntityClass() {
        return Comment.class;
    }

    @Override
    public List<Comment> getByAdvert(Advert advert) {

        try {
            return commentDao.getByAdvert(advert);

        } catch (RuntimeException e) {
            logger.error("Get comment list by advert error: " + e.getMessage());
            throw e;
        }
    }

    @Override
    @Transactional
    public void addFromDto(CommentDto dto) {

        try {
            add(dtoToComment(dto, userService.getById(dto.getUserId()), advertService.getById(dto.getAdvertId())));

        } catch (RuntimeException e) {
            logger.error("Add comment from dto error: " + e.getMessage());
            throw e;
        }
    }

    @Override
    public CommentDto commentToDto(Comment comment) {
        return new CommentDto(comment.getText(), comment.getUser().getId(), comment.getAdvert().getId());
    }

    @Override
    public List<SimpleCommentDto> commentListToDto(List<Comment> commentList) {
        List<SimpleCommentDto> commentDtoList = new LinkedList<>();

        for (Comment comment : commentList) {
            commentDtoList.add(new SimpleCommentDto(comment.getId(), comment.getText()));
        }
        return commentDtoList;
    }

    @Override
    public List<SimpleCommentDto> commentSetToDto(Set<Comment> commentList) {
        List<SimpleCommentDto> commentDtoList = new LinkedList<>();

        for (Comment comment : commentList) {
            commentDtoList.add(new SimpleCommentDto(comment.getId(), comment.getText()));
        }
        return commentDtoList;
    }

    @Override
    public Comment dtoToComment(CommentDto dto, User user, Advert advert) {
        return new Comment(user, advert, dto.getText());
    }
}
