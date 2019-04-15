package dao;

import hibernate.ConnectionDB;

import javax.inject.Inject;
import java.io.Serializable;

public class DaoAbstract<T, Id extends Serializable> implements DaoInterface<T, Id> {

    @Inject
    ConnectionDB connectionDB;

    @Override
    public void create(T entity) {
        connectionDB.openCurrentSessionwithTransaction();
        connectionDB.getCurrentSession().save(entity);
        connectionDB.closeCurrentSessionwithTransaction();
    }

    @Override
    public void update(T entity) {
        connectionDB.openCurrentSessionwithTransaction();
        connectionDB.getCurrentSession().update(entity);
        connectionDB.closeCurrentSessionwithTransaction();
    }


    @Override
    public void delete(T entity) {
        connectionDB.openCurrentSessionwithTransaction();
        connectionDB.getCurrentSession().delete(entity);
        connectionDB.closeCurrentSessionwithTransaction();
    }


    @Override
    public void deleteAll() {
    }
}
