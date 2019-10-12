package com.senla.catalog.serviceapi;

import com.senla.catalog.dto.advert.VipInfoDto;
import com.senla.catalog.entity.VipInfo;
import com.senla.catalog.serviceapi.basic.IGenericService;

public interface IVipInfoService extends IGenericService<VipInfo, Long> {

    VipInfoDto vipInfoToDto(VipInfo vipInfo);

    VipInfo dtoToVipInfo(VipInfoDto dto);
}
