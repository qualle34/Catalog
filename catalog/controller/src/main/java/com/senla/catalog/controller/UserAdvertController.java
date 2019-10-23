package com.senla.catalog.controller;

import com.senla.catalog.dto.advert.AdvertDto;
import com.senla.catalog.dto.advert.SimpleAdvertDto;
import com.senla.catalog.dto.advert.VipInfoDto;
import com.senla.catalog.serviceapi.IAdvertService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/my")
public class UserAdvertController {

    @Autowired
    private IAdvertService advertService;

    @GetMapping(value = "adverts")
    public List<SimpleAdvertDto> getUserAdverts(@RequestHeader("token") String token) {
        return advertService.getByUser(token);
    }

    @GetMapping(value = "advert", params = "id") // param - advert id
    public AdvertDto getUserAdvert(@RequestHeader("token") String token, @RequestParam int id) {
        return advertService.getWithCommentsById(id, token);
    }

    @PostMapping(value = "advert/add")
    public void addAdvert(@RequestHeader("token") String token, @RequestBody AdvertDto dto) {
        advertService.add(dto, token);
    }

    @PutMapping(value = "advert/update")
    public void updateAdvert(@RequestHeader("token") String token, @RequestBody AdvertDto dto) {
        advertService.update(dto, token);
    }

    @DeleteMapping(value = "advert/delete/{id}")
    public void deleteAdvert(@RequestHeader("token") String token, @PathVariable(value = "id") int advertId) {
        advertService.delete(advertId, token);
    }

    @PostMapping(value = "advert/add-vip")
    public void addVipInfo(@RequestHeader("token") String token, @RequestBody VipInfoDto dto) {
        advertService.addVip(dto.getId(), token);
    }

    @ExceptionHandler(RuntimeException.class)
    public ResponseEntity handleUserAdvertException() {
        return new ResponseEntity(null, HttpStatus.FORBIDDEN);
    }
}