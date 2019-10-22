package com.senla.catalog.service;

import com.senla.catalog.daoapi.ICommentDao;
import com.senla.catalog.dto.advert.CommentDto;
import com.senla.catalog.dto.advert.SimpleCommentDto;
import com.senla.catalog.entity.Advert;
import com.senla.catalog.entity.Comment;
import com.senla.catalog.entity.User;
import com.senla.catalog.service.basic.AbstractService;
import com.senla.catalog.service.security.token.TokenException;
import com.senla.catalog.service.security.token.TokenUtil;
import com.senla.catalog.serviceapi.IAdvertService;
import com.senla.catalog.serviceapi.ICommentService;
import com.senla.catalog.serviceapi.IUserService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Collection;
import java.util.LinkedList;
import java.util.List;

@Service
public class CommentService extends AbstractService<Comment, Long> implements ICommentService {

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
    public List<Comment> getByAdvert(long advertId) {

        try {
            return commentDao.getByAdvert(advertId);

        } catch (RuntimeException e) {
            logger.error("Get comment list by advert error: " + e.getMessage());
            throw e;
        }
    }

    @Override
    public CommentDto commentToDto(Comment comment) {
        return new CommentDto(comment.getText(), comment.getUser().getId(), comment.getAdvert().getId());
    }

    @Override
    public List<SimpleCommentDto> commentsToDto(Collection<Comment> commentList) {
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

    @Override
    @Transactional
    public void add(CommentDto dto) {

        try {
            add(dtoToComment(dto, userService.getById(dto.getUserId()), advertService.getById(dto.getAdvertId())));

        } catch (RuntimeException e) {
            logger.error("Add comment from dto error: " + e.getMessage());
            throw e;
        }
    }

    @Override
    @Transactional
    public void add(CommentDto dto, String token) {

        if (TokenUtil.isValid(token)) {
            dto.setUserId(userService.getIdByToken(token));
            add(dto);

        } else {
            throw new TokenException("Token exception");
        }
    }

    @Override
    @Transactional
    public void delete(long id) {

        try {
            commentDao.delete(id);

        } catch (RuntimeException e) {
            logger.error("Delete comment from dto error: " + e.getMessage());
            throw e;
        }
    }
}
