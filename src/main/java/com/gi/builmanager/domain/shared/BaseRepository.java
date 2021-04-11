package com.gi.builmanager.domain.shared;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public abstract class BaseRepository<D extends AggregateRoot<?>/*, E*/> {

    private final Map<Class<?>, RepositoryHelper> mapMapper = new HashMap<>();

    protected <K,I> void addHelper(Class<K> containerType, RepositoryHelper repositoryHelper) {
        mapMapper.put(containerType, repositoryHelper);
    }

    protected <T> void fillData(T target, D domain) {
        mapMapper.values().forEach(repositoryHelper -> repositoryHelper.fillObject(target, domain));
    }

    protected void startPersistence() {
        mapMapper.values().forEach(repositoryHelper -> repositoryHelper.resetCached());
    }

    public abstract D getById(Integer id);
    public abstract Integer save(D aggregate);
    public abstract Integer saveAll(List<D> aggregate);

}
