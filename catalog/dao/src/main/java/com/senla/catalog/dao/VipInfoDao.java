package com.senla.catalog.dao;

import com.senla.catalog.IVipInfoDao;
import com.senla.catalog.dao.basic.AbstractDao;
import com.senla.catalog.entity.VipInfo;
import org.hibernate.Session;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class VipInfoDao extends AbstractDao<VipInfo, Integer> implements IVipInfoDao {

    private static final Logger logger = LoggerFactory.getLogger(DealDao.class);

    @Autowired
    private Session session;

    @Override
    protected Class getChildClass() {
        return VipInfoDao.class;
    }

    @Override
    protected Class<VipInfo> getEntityClass() {
        return VipInfo.class;
    }
}
