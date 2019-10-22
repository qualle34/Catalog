package com.senla.catalog.service;

import com.senla.catalog.daoapi.IAdvertDao;
import com.senla.catalog.dto.advert.AdvertDto;
import com.senla.catalog.dto.advert.SimpleAdvertDto;
import com.senla.catalog.entity.Advert;
import com.senla.catalog.entity.VipInfo;
import com.senla.catalog.entity.enums.AdvertType;
import com.senla.catalog.service.basic.AbstractService;
import com.senla.catalog.serviceapi.IAdvertService;
import com.senla.catalog.serviceapi.ICategoryService;
import com.senla.catalog.serviceapi.ICommentService;
import com.senla.catalog.serviceapi.IUserService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Date;
import java.util.LinkedList;
import java.util.List;

@Service
public class AdvertService extends AbstractService<Advert, Long> implements IAdvertService {

    private static final Logger logger = LoggerFactory.getLogger(AdvertService.class);

    @Autowired
    private IAdvertDao advertDao;

    @Autowired
    private ICommentService commentService;

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
    public List<SimpleAdvertDto> getAllDto() {

        try {
            return advertListToDto(advertDao.getAll());

        } catch (RuntimeException e) {
            logger.error("Get adverts by category error: " + e.getMessage());
            throw e;
        }
    }

    @Override
    public List<SimpleAdvertDto> getByCategory(int categoryId) {

        try {
            return advertListToDto(advertDao.getByCategory(categoryId));

        } catch (RuntimeException e) {
            logger.error("Get adverts by category error: " + e.getMessage());
            throw e;
        }
    }

    @Override
    public List<SimpleAdvertDto> getByType(String type) {

        try {
            return advertListToDto(advertDao.getByType(getType(type)));

        } catch (RuntimeException e) {
            logger.error("Get adverts by type error: " + e.getMessage());
            throw e;
        }
    }

    @Override
    public List<SimpleAdvertDto> getByTitle(String title) {

        try {
            return advertListToDto(advertDao.getByTitle(title));

        } catch (RuntimeException e) {
            logger.error("Get adverts by title error: " + e.getMessage());
            throw e;
        }
    }

    @Override
    public List<SimpleAdvertDto> getByCategoryAndType(int categoryId, String type) {

        try {
            return advertListToDto(advertDao.getByCategoryAndType(categoryId, getType(type)));

        } catch (RuntimeException e) {
            logger.error("Get adverts by category and type error: " + e.getMessage());
            throw e;
        }
    }

    @Override
    public List<SimpleAdvertDto> getByTitleAndType(String title, String type) {

        try {
            return advertListToDto(advertDao.getByTitleAndType(title, getType(type)));

        } catch (RuntimeException e) {
            logger.error("Get sorted adverts by title and type error: " + e.getMessage());
            throw e;
        }
    }

    @Override
    public List<SimpleAdvertDto> getByUser(long userId) {

        try {
            return advertListToDto(advertDao.getByUser(userId));

        } catch (RuntimeException e) {
            logger.error("Get adverts by user error: " + e.getMessage());
            throw e;
        }
    }

    @Override
    public List<SimpleAdvertDto> getByUser(String token) {
        return getByUser(userService.getIdByToken(token));
    }

    @Override
    public AdvertDto getDtoById(long id) {

        try {
            return advertToDto(advertDao.getById(id));

        } catch (RuntimeException e) {
            logger.error("Get advert by id error: " + e.getMessage());
            throw e;
        }
    }

    @Override
    public AdvertDto getWithCommentsById(long id) {

        try {
            Advert advert = advertDao.getWithCommentsById(id);
            AdvertDto dto = advertToDto(advert);
            dto.setComments(commentService.commentsToDto(advert.getCommentSet()));
            return dto;

        } catch (RuntimeException e) {
            logger.error("Get advert by id with comments error: " + e.getMessage());
            throw e;
        }
    }

    @Override
    public AdvertDto getWithCommentsById(long id, String token) {

        try {
            Advert advert = advertDao.getWithCommentsById(id, userService.getIdByToken(token));
            AdvertDto dto = advertToDto(advert);
            dto.setComments(commentService.commentsToDto(advert.getCommentSet()));
            return dto;

        } catch (RuntimeException e) {
            logger.error("Get advert by id and user with comments error: " + e.getMessage());
            throw e;
        }
    }

    @Override
    public AdvertDto advertToDto(Advert advert) {
        AdvertDto dto = new AdvertDto(advert.getTitle(), advert.getDescription(), advert.getPrice(),
                advert.getType(), advert.getUser().getId(), advert.getCategory().getId());
        dto.setId(advert.getId());
        return dto;
    }

    @Override
    public Advert dtoToAdvert(AdvertDto dto) {
        return new Advert(dto.getTitle(), dto.getDescription(), dto.getPrice(), dto.getType());
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
    @Transactional
    public void add(AdvertDto dto) {

        try {
            Advert advert = dtoToAdvert(dto);
            advert.setUser(userService.getById(dto.getUserId()));
            advert.setCategory(categoryService.getById(dto.getCategoryId()));
            advertDao.add(advert);

        } catch (RuntimeException e) {
            logger.error("Add advert from dto error: " + e.getMessage());
            throw e;
        }
    }

    @Override
    @Transactional
    public void add(AdvertDto dto, String token) {
        dto.setUserId(userService.getIdByToken(token));
        add(dto);
    }

    @Override
    @Transactional
    public void addVip(long id) {

        try {
            Advert advert = super.getById(id);
            advert.setVipInfo(new VipInfo(id, new Date()));
            advertDao.update(advert);

        } catch (RuntimeException e) {
            logger.error("Add vip to advert error: " + e.getMessage());
            throw e;
        }
    }

    @Override
    @Transactional
    public void addVip(long id, String token) {
        addVip(id);
    }

    @Override
    @Transactional
    public void update(AdvertDto dto) {

        try {
            Advert advert = advertDao.getById(dto.getId());
            advert.setTitle(isNotEmpty(dto.getTitle()) ? dto.getTitle() : advert.getTitle());
            advert.setDescription(isNotEmpty(dto.getDescription()) ? dto.getDescription() : advert.getDescription());
            advert.setPrice(isNotEmpty(String.valueOf(dto.getPrice())) ? dto.getPrice() : advert.getPrice());
            advert.setType(isNotEmpty(dto.getType().name()) ? dto.getType() : advert.getType());
            advertDao.update(advert);

        } catch (RuntimeException e) {
            logger.error("Update advert from dto error: " + e.getMessage());
            throw e;
        }
    }

    @Override
    @Transactional
    public void update(AdvertDto dto, String token) {

        try {
            Advert advert = advertDao.getById(dto.getId(), userService.getIdByToken(token));
            advert.setTitle(isNotEmpty(dto.getTitle()) ? dto.getTitle() : advert.getTitle());
            advert.setDescription(isNotEmpty(dto.getDescription()) ? dto.getDescription() : advert.getDescription());
            advert.setPrice(isNotEmpty(String.valueOf(dto.getPrice())) ? dto.getPrice() : advert.getPrice());
            advert.setType(isNotEmpty(dto.getType().name()) ? dto.getType() : advert.getType());
            advertDao.update(advert);

        } catch (RuntimeException e) {
            logger.error("Update advert from dto error: " + e.getMessage());
            throw e;
        }
    }

    @Override
    @Transactional
    public void delete(long id) {

        try {
            advertDao.delete(id);

        } catch (RuntimeException e) {
            logger.error("Delete advert by id error: " + e.getMessage());
            throw e;
        }
    }

    @Override
    @Transactional
    public void delete(long id, String token) {

        try {
            advertDao.delete(id, userService.getIdByToken(token));

        } catch (RuntimeException e) {
            logger.error("Delete advert by id error: " + e.getMessage());
            throw e;
        }
    }

    private AdvertType getType(String type) {

        if (type.equals("SELL") || type.equals("sell")) {
            return AdvertType.SELL;

        } else {
            return AdvertType.BUY;
        }
    }

    private boolean isNotEmpty(String value) {
        return value != null && !value.equals("");
    }
}