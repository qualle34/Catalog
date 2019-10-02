package com.senla.catalog.serviceapi;

import com.senla.catalog.dto.VipInfoDto;
import com.senla.catalog.entity.Advert;
import com.senla.catalog.entity.VipInfo;
import com.senla.catalog.serviceapi.basic.IGenericService;

public interface IVipInfoService extends IGenericService<VipInfo, Integer> {

    VipInfoDto vipInfoToDto(VipInfo vipInfo);

    VipInfo dtoToVipInfo(VipInfoDto dto);
}
