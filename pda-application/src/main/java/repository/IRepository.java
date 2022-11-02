package repository;

public interface IRepository<T> {
    public T add(T o);
    public T find(int id);
    public T update(T o);
    public void delete(T o);
    public void close();
}
