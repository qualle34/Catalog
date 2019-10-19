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
        return advertService.getAllSorted();
    }

    @GetMapping(params = "category")
    public List<SimpleAdvertDto> getAdvertListByCategory(@RequestParam int category) {
        return advertService.getByCategory(category);
    }

    @GetMapping(params = "type")
    public List<SimpleAdvertDto> getAdvertListByType(@RequestParam String type) {
        return advertService.getByType(type);
    }

    @GetMapping(params = "search")
    public List<SimpleAdvertDto> getAdvertListByTitle(@RequestParam String search) {
        return advertService.getByTitle(search);
    }

    @GetMapping(params = {"category", "type"})
    public List<SimpleAdvertDto> getAdvertListByCategoryAndType(@RequestParam int category, @RequestParam String type) {
        return advertService.getByCategoryAndType(category, type);
    }

    @GetMapping(params = {"search", "type"})
    public List<SimpleAdvertDto> getAdvertListByTitleAndType(@RequestParam String search, @RequestParam String type) {
        return advertService.getByTitleAndType(search, type);
    }

    @GetMapping(value = "categories")
    public List<CategoryDto> getCategories() {
        return categoryService.getAllDto();
    }
}