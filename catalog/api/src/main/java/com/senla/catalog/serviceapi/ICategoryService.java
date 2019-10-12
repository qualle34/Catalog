package com.senla.catalog.serviceapi;

import com.senla.catalog.dto.advert.CategoryDto;
import com.senla.catalog.entity.Category;
import com.senla.catalog.serviceapi.basic.IGenericService;

import java.util.List;

public interface ICategoryService extends IGenericService<Category, Integer> {

    List<Category> getByTitle(String title);

    List<CategoryDto> getDtoByTitle(String title);

    List<CategoryDto> getAllDto();

    CategoryDto categoryToDto(Category category);

    Category dtoToCategory(CategoryDto dto);

    List<CategoryDto> categoryListToDto(List<Category> categoryList);

    void add(CategoryDto dto);

    void update(CategoryDto dto);

    void delete(int id);
}
