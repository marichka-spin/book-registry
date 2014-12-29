package com.bookregistry.dao;

import java.util.List;

public interface IBaseDao<T> {

    public T findById(Integer id);
    public List<T> findAll();
    public void save(T obj);
    public void update(T obj);
    public void delete(Integer id);

}
