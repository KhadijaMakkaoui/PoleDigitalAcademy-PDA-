package repository;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import entity.Exercice;

public interface IRepository<T> {
    public T add(T o);
    public T find(int id);
    public T update(T o);
    public void delete(T o);
    public void close();
	public List<T> getAllExercice();
}
