package com.gi.builmanager.domain.shared;

public interface EntityJpaConverter<T> {

    T toJpaEntity();
}
