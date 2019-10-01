package com.senla.catalog.controller;

import com.senla.catalog.dto.AdvertDto;
import com.senla.catalog.dto.SimpleAdvertDto;
import com.senla.catalog.dto.SimpleCommentDto;
import com.senla.catalog.dto.VipInfoDto;
import com.senla.catalog.entity.Advert;
import com.senla.catalog.entity.Comment;
import com.senla.catalog.entity.VipInfo;
import com.senla.catalog.serviceapi.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Date;
import java.util.LinkedList;
import java.util.List;

@RestController
@RequestMapping(value = "/my")
public class UserAdvertController {

    @Autowired
    IAdvertService advertService;

    @Autowired
    ICommentService commentService;

    @Autowired
    ICategoryService categoryService;

    @Autowired
    IUserService userService;

    @Autowired
    IVipInfoService vipInfoService;

    @GetMapping(value = "adverts", params = "id") // param - user id
    public List<SimpleAdvertDto> getUserAdverts(@RequestParam int id) {
        return advertListToDto(advertService.getByUser(userService.getById(id)));
    }

    @GetMapping(value = "advert", params = "id") // param - advert id
    public AdvertDto getUserAdvert(@RequestParam int id) {
        Advert advert = advertService.getById(id);
        List<Comment> commentList = commentService.getByAdvert(advert);
        return advertToDto(advert, commentList);
    }

    @PostMapping(value = "/add")
    public void addAdvert(@RequestBody AdvertDto dto) {
        System.out.println(dto.getTitle());
        advertService.add(dtoToAdvert(dto));
    }

    @PostMapping(value = "advert/update")
    public void updateAdvert(@RequestBody AdvertDto dto) {
        Advert advert = advertService.getById(dto.getId());
        advert.setTitle(dto.getTitle());
        advert.setDescription(dto.getDescription());
        advert.setPrice(dto.getPrice());
        advert.setType(dto.getType());
        advert.setCategory(categoryService.getById(dto.getCategoryId()));
        advertService.update(advert);
    }

    @DeleteMapping(value = "advert/delete")
    public void deleteAdvert(@RequestBody AdvertDto dto) {

        if (vipInfoService.getById(dto.getId()) != null) {
            vipInfoService.delete(vipInfoService.getById(dto.getId()));
        }
        advertService.delete(advertService.getById(dto.getId()));
    }

    // TODO: Fix
    @PostMapping(value = "advert/add_vip")
    public void addVipInfo(@RequestBody VipInfoDto vipInfoDto) {
        vipInfoService.add(dtoToVipInfo(vipInfoDto));
    }

    private Advert dtoToAdvert(AdvertDto dto) {
        return new Advert(dto.getTitle(), dto.getDescription(), dto.getPrice(), dto.getType(),
                userService.getById(dto.getUserId()), categoryService.getById(dto.getCategoryId()));
    }

    private VipInfo dtoToVipInfo(VipInfoDto dto) {
        Advert advert = advertService.getById(dto.getId());
        VipInfo vipInfo = new VipInfo(new Date());
        advert.setVipInfo(vipInfo);
        return vipInfo;
    }

    private List<SimpleAdvertDto> advertListToDto(List<Advert> advertList) {
        List<SimpleAdvertDto> advertDtoList = new LinkedList<>();

        for (Advert a : advertList) {
            advertDtoList.add(new SimpleAdvertDto(a.getId(), a.getTitle(), a.getPrice(), a.getType()));
        }
        return advertDtoList;
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
}
