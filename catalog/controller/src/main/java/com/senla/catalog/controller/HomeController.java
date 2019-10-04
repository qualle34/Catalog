package com.senla.catalog.controller;

import com.senla.catalog.dto.SimpleAdvertDto;
import com.senla.catalog.serviceapi.IAdvertService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping(value = "/")
public class HomeController {

    @Autowired
    IAdvertService advertService;

    @GetMapping
    public List<SimpleAdvertDto> getAdvertList() {
        return advertService.getAllSorted();
    }

    @GetMapping(params = "search")
    public List<SimpleAdvertDto> getAdvertListBySearch(@RequestParam String search) {
        return advertService.getByTitle(search);
    }

    @GetMapping(params = "category")
    public List<SimpleAdvertDto> getAdvertListByCategory(@RequestParam int category) {
        return advertService.getByCategorySorted(category);
    }

    @GetMapping(params = "type")
    public List<SimpleAdvertDto> getAdvertListByType(@RequestParam String type) {
        return advertService.getByTypeSorted(type);
    }

    @GetMapping(params = {"category", "type"})
    public List<SimpleAdvertDto> getAdvertListByCategoryAndTypeSorted(@RequestParam int category, @RequestParam String type) {
        return advertService.getByCategoryAndTypeSorted(category, type);
    }
}
