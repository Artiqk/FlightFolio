package com.dassolt.flightfolio.dao;

import java.util.List;

public interface GenericDAO <T> {

    void add(T t);
    T findById(int id);
    List<T> findAll();
    void update(T t);
    void delete(T t);

}
