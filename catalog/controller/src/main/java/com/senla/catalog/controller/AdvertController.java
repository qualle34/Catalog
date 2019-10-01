package com.senla.catalog.controller;

import com.senla.catalog.dto.AdvertDto;
import com.senla.catalog.dto.CommentDto;
import com.senla.catalog.dto.SimpleCommentDto;
import com.senla.catalog.entity.Advert;
import com.senla.catalog.entity.Comment;
import com.senla.catalog.serviceapi.IAdvertService;
import com.senla.catalog.serviceapi.ICommentService;
import com.senla.catalog.serviceapi.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.LinkedList;
import java.util.List;

@RestController
@RequestMapping(value = "/advert")
public class AdvertController {

    @Autowired
    IAdvertService advertService;

    @Autowired
    ICommentService commentService;

    @Autowired
    IUserService userService;

    @GetMapping(params = "id")
    public AdvertDto getAdvertData(@RequestParam int id) {
        Advert advert = advertService.getById(id);
        List<Comment> commentList = commentService.getByAdvert(advert);
        return advertToDto(advert, commentList);
    }

    @PostMapping(params = "comment")
    public void AddComment(@RequestBody CommentDto commentDto) {
         commentService.add(commentDtoToObject(commentDto));
    }

    private AdvertDto advertToDto(Advert advert, List<Comment> commentList) {
        AdvertDto dto = new AdvertDto(advert.getTitle(), advert.getDescription(), advert.getPrice(),
                advert.getType(), advert.getUser().getId(), advert.getCategory().getId());
        dto.setId(advert.getId());
        List<SimpleCommentDto> commentDtoList = new LinkedList<>();

        for (Comment comment : commentList) {
            commentDtoList.add(new SimpleCommentDto(comment.getId(), comment.getText()));
        }
        dto.setComments(commentDtoList);

        return dto;
    }

    private Comment commentDtoToObject(CommentDto dto) {
        return new Comment(userService.getById(dto.getUserId()), advertService.getById(dto.getId()), dto.getText());
    }
}
