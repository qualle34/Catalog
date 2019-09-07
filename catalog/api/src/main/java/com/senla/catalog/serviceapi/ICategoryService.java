package com.senla.catalog.serviceapi;


import com.senla.catalog.entity.Category;

import java.util.List;

public interface ICategoryService {

    List<Category> getAll();

    void add(Category category);

    Category get(Integer id);

    void update(Category category);

    void delete(Category category);
}
