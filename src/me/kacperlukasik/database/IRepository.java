package me.kacperlukasik.database;

import java.util.List;

public interface IRepository<T>
{
    public List<T> getAll();

    public T getById(String id);

    public boolean create(T object);
}
