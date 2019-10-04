package com.senla.catalog.controller;

import com.senla.catalog.dto.AdvertDto;
import com.senla.catalog.dto.SimpleAdvertDto;
import com.senla.catalog.dto.VipInfoDto;
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
        return advertService.getDtoByUserId(id);
    }

    @GetMapping(value = "advert", params = "id") // param - advert id
    public AdvertDto getUserAdvert(@RequestParam int id) {
        return advertService.getDtoByIdWithComments(id);
    }

    @PostMapping(value = "/add")
    public void addAdvert(@RequestBody AdvertDto dto) {
        advertService.add(dto);
    }

    @PostMapping(value = "advert/update")
    public void updateAdvert(@RequestBody AdvertDto dto) {
        advertService.update(dto);
    }

    @DeleteMapping(value = "advert/delete/{id}")
    public void deleteAdvert(@PathVariable(value = "id") int advertId) {
        advertService.delete(advertId);
    }

    @PostMapping(value = "advert/add_vip")
    public void addVipInfo(@RequestBody VipInfoDto dto) {
        advertService.addVip(dto.getId());
    }
}
