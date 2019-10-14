package com.senla.catalog.controller;

import com.senla.catalog.dto.advert.CategoryDto;
import com.senla.catalog.dto.advert.SimpleAdvertDto;
import com.senla.catalog.serviceapi.IAdvertService;
import com.senla.catalog.serviceapi.ICategoryService;
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
    private IAdvertService advertService;

    @Autowired
    private ICategoryService categoryService;

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

    @GetMapping(value = "categories")
    public List<CategoryDto> getCategories() {
        return categoryService.getAllDto();
    }
}