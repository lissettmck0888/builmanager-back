package com.gi.builmanager.domain.shared;

import com.gi.builmanager.infrastructure.mapper.RepositoryMapper;

import java.util.List;

public interface BaseRepository<T extends AggregateRoot<?>, E> {

    T getById(Integer id);
    Integer save(T aggregate, RepositoryMapper.RepositoryHelper<T, E> repositoryHelper);
    Integer saveAll(List<T> aggregate, RepositoryMapper.RepositoryHelper<T, E> repositoryHelper);

}
