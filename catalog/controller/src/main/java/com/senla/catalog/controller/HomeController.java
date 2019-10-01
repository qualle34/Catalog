package com.senla.catalog.controller;

import com.senla.catalog.dto.SimpleAdvertDto;
import com.senla.catalog.entity.Advert;
import com.senla.catalog.entity.enums.AdvertType;
import com.senla.catalog.serviceapi.IAdvertService;
import com.senla.catalog.serviceapi.ICategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.LinkedList;
import java.util.List;

@RestController
@RequestMapping(value = "/")
public class HomeController {

    @Autowired
    IAdvertService advertService;

    @Autowired
    ICategoryService categoryService;

    @GetMapping
    public List<SimpleAdvertDto> getAdvertList() {
        return AdvertListToDto(advertService.getAllSorted());
    }

    @GetMapping(params = "search")
    public List<SimpleAdvertDto> getAdvertListBySearch(@RequestParam String search) {
        return AdvertListToDto(advertService.getByTitle(search));
    }

    @GetMapping(params = "category")
    public List<SimpleAdvertDto> getAdvertListByCategory(@RequestParam int category) {
        return AdvertListToDto(advertService.getByCategorySorted(categoryService.getById(category)));
    }

    @GetMapping(params = "type")
    public List<SimpleAdvertDto> getAdvertListByType(@RequestParam String type) {

        if (type.equals("SELL") || type.equals("sell")) {
            return AdvertListToDto(advertService.getByTypeSorted(AdvertType.SELL));
        } else {
            return AdvertListToDto(advertService.getByTypeSorted(AdvertType.BUY));
        }
    }

    @GetMapping(params = {"category", "type"})
    public List<SimpleAdvertDto> getAdvertListByCategoryAndTypeSorted(@RequestParam int category, @RequestParam String type) {

        if (type.equals("SELL") || type.equals("sell")) {
            return AdvertListToDto(advertService.getByCategoryAndTypeSorted(categoryService.getById(category), AdvertType.SELL));
        } else {
            return AdvertListToDto(advertService.getByCategoryAndTypeSorted(categoryService.getById(category), AdvertType.BUY));
        }
    }

    private List<SimpleAdvertDto> AdvertListToDto(List<Advert> advertList) {
        List<SimpleAdvertDto> advertDtoList = new LinkedList<>();

        for (Advert a : advertList) {
            advertDtoList.add(new SimpleAdvertDto(a.getId(), a.getTitle(), a.getPrice(), a.getType()));
        }
        return advertDtoList;
    }
}
