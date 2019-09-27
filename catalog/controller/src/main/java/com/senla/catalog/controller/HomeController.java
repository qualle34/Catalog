package com.senla.catalog.controller;

import com.senla.catalog.entity.constants.AdvertType;
import com.senla.catalog.serviceapi.IAdvertService;
import com.senla.catalog.serviceapi.ICategoryService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HomeController {

    private static final Logger logger = LoggerFactory.getLogger(HomeController.class);

    @Autowired
    IAdvertService advertService;

    @Autowired
    ICategoryService categoryService;

    @RequestMapping(value = "/")
    public String getPage() {
        return advertService.getAllSorted().toString();
    }

    @RequestMapping(value = "/",  params = "search")
    public String getPageBySearch(@RequestParam String search) {
        return advertService.getByTitle(search).toString();
    }

    @RequestMapping(value = "/",  params = "category")
    public String getPageByCategory (@RequestParam String category) {
        return advertService.getByCategorySorted(categoryService.getByTitle(category)).toString();
    }

    @RequestMapping(value = "/",  params = "type")
    public String getPageByType (@RequestParam String type) {

        if (type.equals("SELL")) {
            return advertService.getByTypeSorted(AdvertType.SELL).toString();
        } else {
            return advertService.getByTypeSorted(AdvertType.BUY).toString();
        }
    }
}
