package com.gi.builmanager.domain.shared;

public interface BaseRepository<T extends AggregateRoot<?>> {

    T getById(Integer id);
    Integer save(T aggregate);

}
