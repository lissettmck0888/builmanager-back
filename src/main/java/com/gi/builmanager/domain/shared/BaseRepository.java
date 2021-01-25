package com.gi.builmanager.domain.shared;

import com.gi.builmanager.infrastructure.mapper.RepositoryMapper;

import java.util.List;

public interface BaseRepository<T extends AggregateRoot<?>> {

    T getById(Integer id);
    Integer save(T aggregate);
    Integer saveAll(List<T> aggregate);

}
