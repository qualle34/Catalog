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
import org.springframework.transaction.annotation.Transactional;

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
    public List<Deal> getBySellerId(long sellerId) {

        try {
            return dealDao.getBySellerId(sellerId);

        } catch (RuntimeException e) {
            logger.error("Get deal list by seller error: " + e.getMessage());
            throw e;
        }
    }

    @Override
    public List<Deal> getByBuyerId(long buyerId) {

        try {
            return dealDao.getByBuyerId(buyerId);

        } catch (RuntimeException e) {
            logger.error("Get deal list by buyer error: " + e.getMessage());
            throw e;
        }
    }

    @Override
    public List<DealDto> getDtoBySellerId(long sellerId) {
        return dealListToDto(getBySellerId(sellerId));
    }

    @Override
    public List<DealDto> getDtoByBuyerId(long buyerId) {
        return dealListToDto(getByBuyerId(buyerId));
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
            DealDto dto = dealToDto(deal);
            dtoList.add(dto);
        }
        return dtoList;
    }

    @Override
    @Transactional
    public void delete(long id) {

        try {
            dealDao.delete(id);

        } catch (RuntimeException e) {
            logger.error("Delete deal by id error: " + e.getMessage());
            throw e;
        }
    }
}
