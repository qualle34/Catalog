package com.senla.catalog.service;

import com.senla.catalog.daoapi.ICredsDao;
import com.senla.catalog.dto.UserDto;
import com.senla.catalog.entity.Creds;
import com.senla.catalog.service.basic.AbstractService;
import com.senla.catalog.serviceapi.ICredsService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CredsService extends AbstractService<Creds, Integer> implements ICredsService {

    private static final Logger logger = LoggerFactory.getLogger(CredsService.class);

    @Autowired
    private ICredsDao credsDao;

    @Override
    protected String getDaoClassName() {
        return "credsDao";
    }

    @Override
    protected Class<Creds> getEntityClass() {
        return Creds.class;
    }

    @Override
    public Creds dtoToCreds(UserDto dto) {
        return new Creds(dto.getLogin(), dto.getPassword(), dto.getRole(), dto.getEmail());
    }
}
