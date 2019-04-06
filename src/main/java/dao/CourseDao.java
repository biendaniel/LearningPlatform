package dao;

import hibernate.ConnectionDB;
import model.Course;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import java.util.List;

@ApplicationScoped
public class CourseDao implements DaoInterface<Course, Integer>{

    @Inject
    ConnectionDB connectionDB;
    @Override
    public Integer create(Course entity) {
        return (Integer) connectionDB.getCurrentSession().save(entity);
    }

    @Override
    public void update(Course entity) {
        connectionDB.getCurrentSession().update(entity);
    }

    @Override
    public Course findById(Integer integer) {
        return connectionDB.getCurrentSession().get(Course.class, integer);
    }

    @Override
    public void delete(Course entity) {
        connectionDB.getCurrentSession().delete(entity);
    }

    @Override
    public List<Course> findAll() {
        return connectionDB.getCurrentSession().createQuery("FROM Course ").list();
    }

    @Override
    public void deleteAll() {

    }
}
