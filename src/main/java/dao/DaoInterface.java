package dao;

import java.io.Serializable;
import java.util.List;
import java.util.Set;

public interface DaoInterface<T, Id extends Serializable> {
     Integer create(T entity);

     void update(T entity);

     T findById(Id id);

     void delete(T entity);

     List<T> findAll();

     void deleteAll();

    }

