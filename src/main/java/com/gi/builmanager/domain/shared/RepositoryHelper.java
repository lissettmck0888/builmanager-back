package com.gi.builmanager.domain.shared;

import java.util.HashMap;
import java.util.Map;

public abstract class RepositoryHelper</*T, */S, I> {

    public interface SourceId<I>{
        I retrieveId(Object domain);
    }
    public interface Action<S> {
        void performAction(S source, Object target);
    }

    private final Map<I, S> entityMap = new HashMap<>();
    private SourceId<I> sourceId;
    private Action<S> action;

    public RepositoryHelper(SourceId<I> sourceId, Action<S> action) {
        this.sourceId = sourceId;
        this.action = action;
    }

    protected void fillObject(Object target, Object domain) {
        I id = sourceId.retrieveId(domain);
        if (!entityMap.containsKey(id)) {
            entityMap.put(id, retrieveObject(id));
        }
        action.performAction(entityMap.get(id), target);
    }

    public void resetCached() {
        entityMap.clear();
    }

    public abstract S retrieveObject(I id);
    //public abstract void performAction(S source, T target);

}
