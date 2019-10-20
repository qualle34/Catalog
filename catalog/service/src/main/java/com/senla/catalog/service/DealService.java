package com.senla.catalog.service;

import com.senla.catalog.daoapi.IDealDao;
import com.senla.catalog.dto.user.DealDto;
import com.senla.catalog.entity.Deal;
import com.senla.catalog.service.basic.AbstractService;
import com.senla.catalog.serviceapi.IDealService;
import com.senla.catalog.serviceapi.IUserService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.LinkedList;
import java.util.List;

@Service
public class DealService extends AbstractService<Deal, Long> implements IDealService {

    private static final Logger logger = LoggerFactory.getLogger(DealService.class);

    @Autowired
    private IDealDao dealDao;

    @Autowired
    private IUserService userService;

    @Override
    protected String getDaoClassName() {
        return "dealDao";
    }

    @Override
    protected Class<Deal> getEntityClass() {
        return Deal.class;
    }

    @Override
    public List<DealDto> getBySeller(long sellerId) {

        try {
            return dealListToDto(dealDao.getBySeller(sellerId));

        } catch (RuntimeException e) {
            logger.error("Get deal list by seller error: " + e.getMessage());
            throw e;
        }
    }

    @Override
    public List<DealDto> getBySeller(String token) {
        return getBySeller(userService.getIdByToken(token));
    }

    @Override
    public List<DealDto> getByBuyer(long buyerId) {

        try {
            return dealListToDto(dealDao.getByBuyer(buyerId));

        } catch (RuntimeException e) {
            logger.error("Get deal list by buyer error: " + e.getMessage());
            throw e;
        }
    }

    @Override
    public List<DealDto> getByBuyer(String token) {
        return getByBuyer(userService.getIdByToken(token));
    }

    @Override
    public DealDto dealToDto(Deal deal) {
        DealDto dto = new DealDto(deal.getTitle());
        dto.setId(deal.getId());
        dto.setDate(deal.getDate());
        return dto;
    }

    @Override
    public Deal dtoToDeal(DealDto dto) {
        return new Deal(dto.getTitle(), new Date(), userService.getById(dto.getSellerId()), userService.getById(dto.getBuyerId()));
    }

    @Override
    public List<DealDto> dealListToDto(List<Deal> dealList) {
        List<DealDto> dtoList = new LinkedList<>();

        for (Deal deal : dealList) {
            dtoList.add(dealToDto(deal));
        }
        return dtoList;
    }
}
