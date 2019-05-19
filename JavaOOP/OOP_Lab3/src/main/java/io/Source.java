package io;

public interface Source<T> {
    public void load(T t);
    public void store(T t);
    public void delete(T t);
    public void create(T t);
}
