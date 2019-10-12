package com.senla.catalog.controller;

import com.senla.catalog.dto.advert.CategoryDto;
import com.senla.catalog.serviceapi.ICategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.*;

import java.util.Base64;
import java.util.List;

@RestController
@RequestMapping(value = "/admin")
public class AdminController {

    @Autowired
    private ICategoryService categoryService;

    @GetMapping
    public String getAdminPage() {
        return "admin";
    }

    @GetMapping(value = "category")
    public List<CategoryDto> getCategories() {
        return categoryService.getAllDto();
    }

    @PostMapping(value = "category/add")
    public void deleteCategory(@RequestBody CategoryDto dto) {
        categoryService.add(dto);
    }

    @PutMapping(value = "category/edit")
    public void updateCategory(@RequestBody CategoryDto dto) {
        categoryService.update(dto);
    }

    @DeleteMapping(value = "category/delete/{id}")
    public void deleteCategory(@PathVariable(value = "id") int categoryId) {
        categoryService.delete(categoryId);
    }
}
