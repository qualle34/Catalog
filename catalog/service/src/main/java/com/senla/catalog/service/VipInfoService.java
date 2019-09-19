package com.senla.catalog.service;

import com.senla.catalog.IVipInfoDao;
import com.senla.catalog.entity.VipInfo;
import com.senla.catalog.service.basic.AbstractService;
import com.senla.catalog.serviceapi.IVipInfoService;
import org.hibernate.Session;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class VipInfoService extends AbstractService<VipInfo, Integer> implements IVipInfoService {

    private static final Logger logger = LoggerFactory.getLogger(DealService.class);

    @Autowired
    private Session session;

    @Autowired
    private IVipInfoDao vipInfoDao;

    @Override
    protected Class getChildClass() {
        return VipInfoService.class;
    }

    @Override
    protected Class<VipInfo> getEntityClass() {
        return VipInfo.class;
    }
}
