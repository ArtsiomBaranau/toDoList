package com.gmail.artsiombaranau.model.DAO;

public interface CRUDable<T> {

    boolean create(T t);
    T read(int ID);
    boolean update(int ID, String newData);
    boolean delete(int ID);

}
