package com.senla.catalog.service;

import com.senla.catalog.daoapi.IAdvertDao;
import com.senla.catalog.dto.AdvertDto;
import com.senla.catalog.dto.SimpleAdvertDto;
import com.senla.catalog.entity.Advert;
import com.senla.catalog.entity.Category;
import com.senla.catalog.entity.User;
import com.senla.catalog.entity.VipInfo;
import com.senla.catalog.entity.enums.AdvertType;
import com.senla.catalog.service.basic.AbstractService;
import com.senla.catalog.serviceapi.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Collections;
import java.util.Date;
import java.util.LinkedList;
import java.util.List;

@Service
public class AdvertService extends AbstractService<Advert, Integer> implements IAdvertService {

    private static final Logger logger = LoggerFactory.getLogger(AdvertService.class);

    @Autowired
    private IAdvertDao advertDao;

    @Autowired
    private ICommentService commentService;

    @Autowired
    private IVipInfoService vipInfoService;

    @Autowired
    private IUserService userService;

    @Autowired
    private ICategoryService categoryService;

    @Override
    protected String getDaoClassName() {
        return "advertDao";
    }

    @Override
    protected Class<Advert> getEntityClass() {
        return Advert.class;
    }

    @Override
    public List<Advert> getByCategory(int categoryId) {

        try {
            return advertDao.getByCategory(categoryId);

        } catch (RuntimeException e) {
            logger.error("Get advert list by category error: " + e.getMessage());
            throw e;
        }
    }

    @Override
    public List<Advert> getByType(String type) {

        try {
            return advertDao.getByType(getType(type));

        } catch (RuntimeException e) {
            logger.error("Get advert list by type error: " + e.getMessage());
            throw e;
        }
    }

    @Override
    public List<Advert> getByCategoryAndType(int categoryId, String type) {

        try {
            return advertDao.getByCategoryAndType(categoryId, getType(type));

        } catch (RuntimeException e) {
            logger.error("Get advert list by category and type error: " + e.getMessage());
            throw e;
        }
    }

    @Override
    public List<SimpleAdvertDto> getByTitle(String title) {

        try {
            return advertListToDto(advertDao.getByTitle(title));

        } catch (RuntimeException e) {
            logger.error("Get advert list by title error: " + e.getMessage());
            throw e;
        }
    }

    @Override
    public List<Advert> getByUserId(int userId) {

        try {
            return advertDao.getByUserId(userId);

        } catch (RuntimeException e) {
            logger.error("Get advert list by user error: " + e.getMessage());
            throw e;
        }
    }

    @Override
    public List<Advert> getByTitleAndType(String title, String type) {

        try {
            return advertDao.getByTitleAndType(title, getType(type));

        } catch (RuntimeException e) {
            logger.error("Get advert list by title and type error: " + e.getMessage());
            throw e;
        }
    }

    @Override
    public List<SimpleAdvertDto> getAllSorted() {

        try {
            return advertListToDto(sort(advertDao.getAllWithUser()));

        } catch (RuntimeException e) {
            logger.error("Get adverts with users error: " + e.getMessage());
            throw e;
        }
    }

    @Override
    public List<SimpleAdvertDto> getByCategorySorted(int categoryId) {

        try {
            return advertListToDto(sort(advertDao.getByCategoryWithUser(categoryId)));

        } catch (RuntimeException e) {
            logger.error("Get adverts by category with users error: " + e.getMessage());
            throw e;
        }
    }

    @Override
    public List<SimpleAdvertDto> getByTypeSorted(String type) {

        try {
            return advertListToDto(sort(advertDao.getByTypeWithUser(getType(type))));

        } catch (RuntimeException e) {
            logger.error("Get adverts by type with users error: " + e.getMessage());
            throw e;
        }
    }

    @Override
    public List<SimpleAdvertDto> getByCategoryAndTypeSorted(int categoryId, String type) {

        try {
            return advertListToDto(sort(advertDao.getByCategoryAndTypeWithUser(categoryId, getType(type))));

        } catch (RuntimeException e) {
            logger.error("Get adverts by category and type with users error: " + e.getMessage());
            throw e;
        }
    }

    @Override
    public List<SimpleAdvertDto> getDtoByUserId(int userId) {

        try {
            return advertListToDto(advertDao.getByUserId(userId));

        } catch (RuntimeException e) {
            logger.error("Get adverts dto by user error: " + e.getMessage());
            throw e;
        }
    }

    @Override
    public AdvertDto getDtoByIdWithComments(int id) {

        try {
            Advert advert = advertDao.getByIdWithComments(id);
            AdvertDto dto = advertToDto(advert);
            dto.setComments(commentService.commentSetToDto(advert.getCommentSet()));
            return dto;

        } catch (RuntimeException e) {
            logger.error("Get advert by id with comments error: " + e.getMessage());
            throw e;
        }
    }

    @Override
    public AdvertDto getDtoById(int id) {

        try {
            return advertToDto(advertDao.getById(id));

        } catch (RuntimeException e) {
            logger.error("Get advert by id error: " + e.getMessage());
            throw e;
        }
    }

    @Override
    public List<SimpleAdvertDto> advertListToDto(List<Advert> advertList) {
        List<SimpleAdvertDto> advertDtoList = new LinkedList<>();

        for (Advert advert : advertList) {
            advertDtoList.add(new SimpleAdvertDto(advert.getId(), advert.getTitle(), advert.getPrice(), advert.getType()));
        }
        return advertDtoList;
    }

    @Override
    public AdvertDto advertToDto(Advert advert) {
        AdvertDto dto = new AdvertDto(advert.getTitle(), advert.getDescription(), advert.getPrice(),
                advert.getType(), advert.getUser().getId(), advert.getCategory().getId());
        dto.setId(advert.getId());
        return dto;
    }

    @Override
    @Transactional
    public void update(AdvertDto dto) {

        try {
            Advert advert = advertDao.getById(dto.getId());
            advert.setTitle(dto.getTitle());
            advert.setDescription(dto.getDescription());
            advert.setPrice(dto.getPrice());
            advert.setType(dto.getType());
            advertDao.update(advert);

        } catch (RuntimeException e) {
            logger.error("Update advert from dto error: " + e.getMessage());
            throw e;
        }
    }

    @Override
    @Transactional
    public void add(AdvertDto dto) {

        try {
            Advert advert = dtoToAdvert(dto);
            advert.setUser(userService.getById(dto.getUserId()));
            advert.setCategory(categoryService.getById(dto.getCategoryId()));
            add(advert);

        } catch (RuntimeException e) {
            logger.error("Add advert from dto error: " + e.getMessage());
            throw e;
        }
    }

    @Override
    @Transactional
    public void addVip(int id) {

        try {
            Advert advert = getById(id);
            advert.setVipInfo(new VipInfo(id, new Date()));
            advertDao.update(advert);

        } catch (RuntimeException e) {
            logger.error("Add vip to advert error: " + e.getMessage());
            throw e;
        }
    }

    @Override
    @Transactional
    public void delete(int id) {

        try {
            Advert advert = getById(id);

            if (vipInfoService.getById(id) != null) {
                vipInfoService.delete(vipInfoService.getById(id));
            }
            advertDao.delete(advert);

        } catch (RuntimeException e) {
            logger.error("Delete advert by id error: " + e.getMessage());
            throw e;
        }
    }

    @Override
    public Advert dtoToAdvert(AdvertDto dto) {
        return new Advert(dto.getTitle(), dto.getDescription(), dto.getPrice(), dto.getType());
    }

    private List<Advert> sort(List<Advert> advertList) {
        advertList.sort(Collections.reverseOrder());
        return advertList;
    }

    private AdvertType getType(String type) {

        if (type.equals("SELL") || type.equals("sell")) {
            return AdvertType.SELL;
        } else {
            return AdvertType.BUY;
        }
    }
}