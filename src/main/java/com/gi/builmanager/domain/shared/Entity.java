package com.gi.builmanager.domain.shared;

public interface Entity<T> {

    boolean sameEntityAs(T another);
}
