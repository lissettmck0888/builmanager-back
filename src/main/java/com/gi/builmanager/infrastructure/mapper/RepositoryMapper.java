package com.gi.builmanager.infrastructure.mapper;

public interface RepositoryMapper<DOMAIN, TYPE> {

    DOMAIN fromRepositoryType(TYPE type);
    TYPE toRepository(DOMAIN domain);

}
