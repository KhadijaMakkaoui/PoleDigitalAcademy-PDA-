package service;

public interface IService<T> {
    public T add(T o);
    public T find(int id);
    public T update(T o);
    public void delete(T o);
}
