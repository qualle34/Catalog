package com.senla.catalog.controller;

import com.senla.catalog.dto.AdvertDto;
import com.senla.catalog.dto.CommentDto;
import com.senla.catalog.serviceapi.IAdvertService;
import com.senla.catalog.serviceapi.ICommentService;
import com.senla.catalog.serviceapi.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

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
    public AdvertDto getAdvert(@RequestParam int id) {
        return advertService.getDtoByIdWithComments(id);
    }

    @PostMapping(value = "comment")
    public void AddComment(@RequestBody CommentDto dto) {
        commentService.addFromDto(dto);
    }
}
