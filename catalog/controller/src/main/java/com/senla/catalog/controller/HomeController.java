package com.senla.catalog.controller;

import com.senla.catalog.dto.SimpleAdvertDto;
import com.senla.catalog.entity.Advert;
import com.senla.catalog.entity.Category;
import com.senla.catalog.entity.enums.AdvertType;
import com.senla.catalog.serviceapi.IAdvertService;
import com.senla.catalog.serviceapi.ICategoryService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping(value = "/")
public class HomeController {

    private static final Logger logger = LoggerFactory.getLogger(HomeController.class);

    @Autowired
    IAdvertService advertService;

    @Autowired
    ICategoryService categoryService;

    @RequestMapping
    public List<SimpleAdvertDto> getPage() {
        return ObjectListToDto(advertService.getAllSorted());
    }

    @RequestMapping(params = "search")
    public List<SimpleAdvertDto> getPageBySearch(@RequestParam String search) {
        return ObjectListToDto(advertService.getByTitle(search));
    }

    @RequestMapping(params = "category")
    public List<SimpleAdvertDto> getPageByCategory(@RequestParam int id) {
        Category category = categoryService.getById(id);
        return ObjectListToDto(advertService.getByCategorySorted(category));
    }

    @RequestMapping(params = "type")
    public List<SimpleAdvertDto> getPageByType(@RequestParam String type) {

        if (type.equals("SELL") || type.equals("sell")) {
            return ObjectListToDto(advertService.getByTypeSorted(AdvertType.SELL));
        } else {
            return ObjectListToDto(advertService.getByTypeSorted(AdvertType.BUY));
        }
    }

    private List<SimpleAdvertDto> ObjectListToDto(List<Advert> advertList) {
        List<SimpleAdvertDto> advertDtoList = new ArrayList<>();

        for (Advert a : advertList) {
            advertDtoList.add(new SimpleAdvertDto(a.getId(), a.getTitle(), a.getPrice(), a.getType()));
        }
        return advertDtoList;
    }
}
