package com.gi.builmanager.domain.shared;

public interface ValueObject<T> {

    boolean sameValueAs(T another);

}
