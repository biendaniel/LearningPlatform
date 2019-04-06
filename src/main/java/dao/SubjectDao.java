package dao;

import hibernate.ConnectionDB;
import model.Subject;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import java.util.List;

@ApplicationScoped
public class SubjectDao implements DaoInterface<Subject, Integer> {

    @Inject
    private ConnectionDB connectionDB;

    @Override
    public Integer create(Subject entity) {
        return (Integer) connectionDB.getCurrentSession().save(entity);
    }

    @Override
    public void update(Subject entity) {
    }

    @Override
    public Subject findById(Integer integer) {
        return connectionDB.getCurrentSession().get(Subject.class, integer);
    }

    @Override
    public void delete(Subject entity) {

    }

    @Override
    public List<Subject> findAll() {
        return connectionDB.getCurrentSession().createQuery("FROM Subject").list();
    }

    @Override
    public void deleteAll() {

    }
}
