package com.senla.catalog.service;

import com.senla.catalog.daoapi.ICategoryDao;
import com.senla.catalog.dto.advert.CategoryDto;
import com.senla.catalog.entity.Category;
import com.senla.catalog.service.basic.AbstractService;
import com.senla.catalog.serviceapi.ICategoryService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.LinkedList;
import java.util.List;

@Service
public class CategoryService extends AbstractService<Category, Integer> implements ICategoryService {

    private static final Logger logger = LoggerFactory.getLogger(CategoryService.class);

    @Autowired
    private ICategoryDao categoryDao;

    @Override
    protected String getDaoClassName() {
        return "categoryDao";
    }

    @Override
    protected Class<Category> getEntityClass() {
        return Category.class;
    }

    @Override
    public List<Category> getByTitle(String title) {

        try {
            return categoryDao.getByTitle(title);

        } catch (RuntimeException e) {
            logger.error("Get categories with adverts by name error: " + e.getMessage());
            throw e;
        }
    }

    @Override
    public List<CategoryDto> getDtoByTitle(String title) {

        try {
            return categoryListToDto(categoryDao.getByTitle(title));

        } catch (RuntimeException e) {
            logger.error("Get categories dto with adverts by name error: " + e.getMessage());
            throw e;
        }
    }

    @Override
    public List<CategoryDto> getAllDto() {

        try {
            return categoryListToDto(categoryDao.getAll());

        } catch (RuntimeException e) {
            logger.error("Get categories dto error: " + e.getMessage());
            throw e;
        }
    }

    @Override
    public CategoryDto categoryToDto(Category category) {
        CategoryDto dto = new CategoryDto(category.getTitle());
        dto.setId(category.getId());
        return dto;
    }

    @Override
    public Category dtoToCategory(CategoryDto dto) {
        return new Category(dto.getTitle());
    }

    @Override
    public List<CategoryDto> categoryListToDto(List<Category> categoryList) {
        List<CategoryDto> advertDtoList = new LinkedList<>();

        for (Category category : categoryList) {
            advertDtoList.add(categoryToDto(category));
        }
        return advertDtoList;
    }

    @Override
    @Transactional
    public void add(CategoryDto dto) {

        try {
            categoryDao.add(dtoToCategory(dto));

        } catch (RuntimeException e) {
            logger.error("Add category from dto error: " + e.getMessage());
            throw e;
        }
    }

    @Override
    @Transactional
    public void update(CategoryDto dto) {

        try {
            Category category = dtoToCategory(dto);
            category.setId(dto.getId());
            categoryDao.update(category);

        } catch (RuntimeException e) {
            logger.error("Update category from dto error: " + e.getMessage());
            throw e;
        }
    }

    @Override
    @Transactional
    public void delete(int id) {

        try {
            categoryDao.delete(id);

        } catch (RuntimeException e) {
            logger.error("Delete category by id error: " + e.getMessage());
            throw e;
        }
    }
}