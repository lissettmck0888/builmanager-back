package com.gi.builmanager.infrastructure.hibernate.mapper;

public interface RepositoryMapper<DOMAIN, TYPE> {

    DOMAIN fromRepositoryType(TYPE type);
    TYPE toRepository(DOMAIN domain);

}
