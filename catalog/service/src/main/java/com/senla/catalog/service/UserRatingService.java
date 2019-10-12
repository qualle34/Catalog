package com.senla.catalog.service;

import com.senla.catalog.daoapi.IUserRatingDao;
import com.senla.catalog.entity.UserRating;
import com.senla.catalog.service.basic.AbstractService;
import com.senla.catalog.serviceapi.IUserRatingService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserRatingService extends AbstractService<UserRating, Long> implements IUserRatingService {

    private static final Logger logger = LoggerFactory.getLogger(UserRatingService.class);

    @Autowired
    private IUserRatingDao userRatingDao;

    @Override
    protected String getDaoClassName() {
        return "userRatingDao";
    }

    @Override
    protected Class<UserRating> getEntityClass() {
        return UserRating.class;
    }
}
