package dao;

import java.io.Serializable;

public interface DaoInterface<T, Id extends Serializable> {
    void create(T entity);

    void update(T entity);

    void delete(T entity);

    void deleteAll();


}

