package com.senla.catalog.serviceapi;

import com.senla.catalog.dto.UserDto;
import com.senla.catalog.entity.Creds;
import com.senla.catalog.serviceapi.basic.IGenericService;

public interface ICredsService extends IGenericService<Creds, Integer> {

    Creds dtoToCreds(UserDto dto);
}
