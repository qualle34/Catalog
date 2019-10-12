package com.senla.catalog.dao;

import com.senla.catalog.dao.basic.AbstractDao;
import com.senla.catalog.daoapi.IUserRatingDao;
import com.senla.catalog.entity.UserRating;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

@Repository
public class UserRatingDao extends AbstractDao<UserRating, Long> implements IUserRatingDao {

    @PersistenceContext
    private EntityManager entityManager;

    @Override
    protected Class<UserRating> getEntityClass() {
        return UserRating.class;
    }
}
