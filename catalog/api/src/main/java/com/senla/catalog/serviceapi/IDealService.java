package com.senla.catalog.serviceapi;

import com.senla.catalog.dto.user.DealDto;
import com.senla.catalog.entity.Deal;
import com.senla.catalog.serviceapi.basic.IGenericService;

import java.util.List;

public interface IDealService extends IGenericService<Deal, Long> {

    List<Deal> getBySellerId(long sellerId);

    List<Deal> getByBuyerId(long buyerId);

    List<DealDto> getDtoBySellerId(long sellerId);

    List<DealDto> getDtoByBuyerId(long buyerId);

    DealDto dealToDto(Deal deal);

    Deal dtoToDeal(DealDto dto);

    List<DealDto> dealListToDto(List<Deal> dealList);

    void delete(long id);
}