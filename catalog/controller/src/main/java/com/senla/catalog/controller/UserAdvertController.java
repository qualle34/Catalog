package com.senla.catalog.controller;

import com.senla.catalog.dto.AdvertDto;
import com.senla.catalog.dto.SimpleAdvertDto;
import com.senla.catalog.dto.VipInfoDto;
import com.senla.catalog.entity.Advert;
import com.senla.catalog.serviceapi.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

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
        return advertService.advertListToDto(advertService.getByUser(userService.getById(id)));
    }

    @GetMapping(value = "advert", params = "id") // param - advert id
    public AdvertDto getUserAdvert(@RequestParam int id) {
        Advert advert = advertService.getById(id);
        AdvertDto advertDto = advertService.advertToDto(advert);
        advertDto.setComments(commentService.CommentListToDto(commentService.getByAdvert(advert)));
        return advertDto;
    }

    @PostMapping(value = "/add")
    public void addAdvert(@RequestBody AdvertDto dto) {
        Advert advert = advertService.dtoToAdvert(dto);
        advert.setUser(userService.getById(dto.getUserId()));
        advert.setCategory(categoryService.getById(dto.getCategoryId()));
        advertService.add(advert);
    }

    @PostMapping(value = "advert/update")
    public void updateAdvert(@RequestBody AdvertDto dto) {
        advertService.update(advertService.updateAdvertFromDto(dto));
    }

    @DeleteMapping(value = "advert/delete/{id}")
    public void deleteAdvert(@PathVariable(value = "id") int advertId) {

        if (vipInfoService.getById(advertId) != null) {
            vipInfoService.delete(vipInfoService.getById(advertId));
        }
        advertService.delete(advertService.getById(advertId));
    }

    // TODO: Fix
    @PostMapping(value = "advert/add_vip")
    public void addVipInfo(@RequestBody VipInfoDto dto) {
        Advert advert = advertService.getById(dto.getId());
        advert.setVipInfo(vipInfoService.dtoToVipInfo(dto));
        advertService.update(advert);
    }
}
