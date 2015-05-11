package DAO;

import Entities.Entity;
import Entities.Letter;

import java.sql.SQLException;
import java.util.List;

/**
 * Created by Anton on 5/11/2015.
 */
public interface AbstractDAO<K,T extends Entity> {
    T create() throws SQLException;

    T get(K key) throws SQLException;

    void delete(T entity);

    void update(T entity);

    List<T> getAll() throws SQLException;
}
