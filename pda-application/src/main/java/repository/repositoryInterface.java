package repository;

import entity.Activite;

public interface repositoryInterface<T> {
    public T add(T o);
    public T find(int id);
    public T update(T o);
    public void delete(T o);
    public void close();
}
