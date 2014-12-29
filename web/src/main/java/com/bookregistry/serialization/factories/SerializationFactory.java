package com.bookregistry.serialization.factories;

import java.util.List;

public interface SerializationFactory<B,M> {

    public B serialize(M model);
    public List<B> serializeAll(List<M> models);
}
