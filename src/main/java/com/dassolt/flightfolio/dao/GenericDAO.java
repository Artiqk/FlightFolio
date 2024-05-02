package com.dassolt.flightfolio.dao;

import java.sql.SQLException;
import java.util.List;

public interface GenericDAO <T> {

    void add(T t) throws SQLException;
    T findByName(String name) throws SQLException;
    List<T> findAll() throws SQLException;
    void update(T t) throws SQLException;
    void delete(T t) throws SQLException;

}
