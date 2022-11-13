package service;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import entity.Exercice;

public interface IService<T> {
    public T add(T o);
    public T find(int id);
    public T update(T o);
    public void delete(T o);
    public List<T> getAll();
}
