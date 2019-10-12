package com.senla.catalog.serviceapi;

import com.senla.catalog.dto.user.UserDto;
import com.senla.catalog.entity.Creds;
import com.senla.catalog.serviceapi.basic.IGenericService;

public interface ICredsService extends IGenericService<Creds, Long> {

    Creds dtoToCreds(UserDto dto);
}