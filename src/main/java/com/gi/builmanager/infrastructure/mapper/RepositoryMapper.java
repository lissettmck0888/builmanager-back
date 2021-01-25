package com.gi.builmanager.infrastructure.mapper;

public interface RepositoryMapper<DOMAIN, TYPE> {

    DOMAIN fromRepositoryType(TYPE type);
    TYPE toRepository(DOMAIN domain, RepositoryHelper<DOMAIN, TYPE> repositoryHelper);

    interface RepositoryHelper<D, T>{
        void transactionStarted();
        void transactionFinished();
        void fillEntity(D d, T t);
    }
}
