package com.senla.catalog.controller;

import com.senla.catalog.dto.AdvertDto;
import com.senla.catalog.dto.CommentDto;
import com.senla.catalog.entity.Advert;
import com.senla.catalog.entity.Comment;
import com.senla.catalog.serviceapi.IAdvertService;
import com.senla.catalog.serviceapi.ICommentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.persistence.Column;
import java.util.LinkedList;
import java.util.List;

@RestController
@RequestMapping(value = "/advert")
public class AdvertController {

    @Autowired
    IAdvertService advertService;

    @Autowired
    ICommentService commentService;

    @RequestMapping(params = "id", method = RequestMethod.GET)
    public AdvertDto getAdvertPage(@RequestParam String id) {
        Advert advert = advertService.getById(Integer.parseInt(id));
        List<Comment> commentList = commentService.getByAdvert(advert);

        AdvertDto dto = new AdvertDto(advert.getTitle(), advert.getDescription(), advert.getPrice());
        List<CommentDto> dtoComments = new LinkedList<>();

        for (Comment comment : commentList) {
            dtoComments.add(new CommentDto(comment.getId(), comment.getText()));
        }
        dto.setComments(dtoComments);

        return dto;
    }

    @RequestMapping(params = "comment", method = RequestMethod.POST)
    public void AddComment(CommentDto commentDto) {
        // commentService.add();
    }
}
