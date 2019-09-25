package com.senla.catalog.dao;

import com.senla.catalog.dao.basic.AbstractDao;
import com.senla.catalog.daoapi.IVipInfoDao;
import com.senla.catalog.entity.VipInfo;
import org.hibernate.Session;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class VipInfoDao extends AbstractDao<VipInfo, Integer> implements IVipInfoDao {

    @Autowired
    private Session session;

    @Override
    protected Class<VipInfo> getEntityClass() {
        return VipInfo.class;
    }
}
