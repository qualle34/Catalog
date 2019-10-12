package com.senla.catalog.dao;

import com.senla.catalog.dao.basic.AbstractDao;
import com.senla.catalog.daoapi.IVipInfoDao;
import com.senla.catalog.entity.VipInfo;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

@Repository
public class VipInfoDao extends AbstractDao<VipInfo, Long> implements IVipInfoDao {

    @PersistenceContext
    private EntityManager entityManager;

    @Override
    protected Class<VipInfo> getEntityClass() {
        return VipInfo.class;
    }
}
