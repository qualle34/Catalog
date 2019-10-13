package com.senla.catalog.controller;

import com.senla.catalog.dto.advert.AdvertDto;
import com.senla.catalog.dto.advert.CommentDto;
import com.senla.catalog.serviceapi.IAdvertService;
import com.senla.catalog.serviceapi.ICommentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(value = "/advert")
@CrossOrigin(origins = "http://localhost:4200")
public class AdvertController {

    @Autowired
    private IAdvertService advertService;

    @Autowired
    private ICommentService commentService;

    @GetMapping(params = "id")
    public AdvertDto getAdvert(@RequestParam int id) {
        return advertService.getDtoWithCommentsById(id);
    }

    @PostMapping(value = "comment")
    public void AddComment(@RequestBody CommentDto dto) {
        commentService.add(dto);
    }
}