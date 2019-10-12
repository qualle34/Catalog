package com.senla.catalog.controller;

import com.senla.catalog.dto.advert.AdvertDto;
import com.senla.catalog.dto.advert.SimpleAdvertDto;
import com.senla.catalog.dto.advert.VipInfoDto;
import com.senla.catalog.entity.User;
import com.senla.catalog.service.security.token.TokenUtil;
import com.senla.catalog.serviceapi.IAdvertService;
import com.senla.catalog.serviceapi.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/my")
public class UserAdvertController {

    @Autowired
    private IAdvertService advertService;

    @Autowired
    private IUserService userService;

    @GetMapping(value = "adverts")
    public List<SimpleAdvertDto> getUserAdverts(@RequestHeader("token") String token) {
        long id = userService.getWithCredsByLogin(TokenUtil.getLogin(token)).getId();
        return advertService.getDtoByUserId(id);
    }

    @GetMapping(value = "advert", params = "id") // param - advert id
    public AdvertDto getUserAdvert(@RequestHeader("token") String token, @RequestParam int id) {
        return advertService.getDtoWithCommentsById(id);
    }

    @PostMapping(value = "advert/add")
    public void addAdvert(@RequestHeader("token") String token, @RequestBody AdvertDto dto) {
        advertService.add(dto);
    }

    @PutMapping(value = "advert/update")
    public void updateAdvert(@RequestHeader("token") String token, @RequestBody AdvertDto dto) {
        advertService.update(dto);
    }

    @DeleteMapping(value = "advert/delete/{id}")
    public void deleteAdvert(@RequestHeader("token") String token, @PathVariable(value = "id") int advertId) {
        advertService.delete(advertId);
    }

    @PostMapping(value = "advert/add-vip")
    public void addVipInfo(@RequestHeader("token") String token, @RequestBody VipInfoDto dto) {
        advertService.addVip(dto.getId());
    }
}