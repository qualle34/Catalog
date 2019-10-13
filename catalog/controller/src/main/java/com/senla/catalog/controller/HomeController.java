package com.senla.catalog.controller;

import com.senla.catalog.dto.advert.SimpleAdvertDto;
import com.senla.catalog.serviceapi.IAdvertService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/")
@CrossOrigin(origins = "http://localhost:4200")
public class HomeController {

    @Autowired
    private IAdvertService advertService;

    @GetMapping
    public List<SimpleAdvertDto> getAdvertList() {
        return advertService.getAllDtoSorted();
    }

    @GetMapping(params = "search")
    public List<SimpleAdvertDto> getAdvertListBySearch(@RequestParam String search) {
        return advertService.getDtoByTitle(search);
    }

    @GetMapping(params = "category")
    public List<SimpleAdvertDto> getAdvertListByCategory(@RequestParam int category) {
        return advertService.getDtoByCategorySorted(category);
    }

    @GetMapping(params = "type")
    public List<SimpleAdvertDto> getAdvertListByType(@RequestParam String type) {
        return advertService.getDtoByTypeSorted(type);
    }

    @GetMapping(params = {"category", "type"})
    public List<SimpleAdvertDto> getAdvertListByCategoryAndTypeSorted(@RequestParam int category, @RequestParam String type) {
        return advertService.getDtoByCategoryAndTypeSorted(category, type);
    }
}