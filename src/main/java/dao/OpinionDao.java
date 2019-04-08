package dao;

import hibernate.ConnectionDB;
import model.Opinion;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import java.util.List;

@ApplicationScoped
public class OpinionDao implements DaoInterface<Opinion, Integer> {

    @Inject
    private ConnectionDB connectionDB;

    @Override
    public Integer create(Opinion entity) {
        return (Integer) connectionDB.getCurrentSession().save(entity);
    }

    @Override
    public void update(Opinion entity) {
        connectionDB.getCurrentSession().update(entity);

    }

    @Override
    public Opinion findById(Integer id) {
        Opinion opinion = connectionDB.getCurrentSession().get(Opinion.class, id);
        return opinion;
    }

    @Override
    public void delete(Opinion entity) {
        connectionDB.getCurrentSession().delete(entity);
    }

    @Override
    public List<Opinion> findAll() {
        return connectionDB.getCurrentSession().createQuery("from Opinion").list();
    }

    @Override
    public void deleteAll() {

    }

    @Override
    public Opinion findByName(String name) {
        return null;
    }
}