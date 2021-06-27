package ru.dstu.application.dao;

import java.util.List;

public interface Dao<T> {
    public List<T> findAll();

    public T findById(long id);

    public void save(T obj);

    public void deleteById(long id);
}
