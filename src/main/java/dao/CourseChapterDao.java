package dao;

import hibernate.ConnectionDB;
import model.CourseChapter;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import java.util.List;

@ApplicationScoped
public class CourseChapterDao implements DaoInterface<CourseChapter, Integer> {

    @Inject
    private ConnectionDB connectionDB;

    @Override
    public Integer create(CourseChapter entity) {
        return (Integer) connectionDB.getCurrentSession().save(entity);
    }

    @Override
    public void update(CourseChapter entity) {
        connectionDB.getCurrentSession().update(entity);
    }

    @Override
    public CourseChapter findById(Integer integer) {
        return connectionDB.getCurrentSession().get(CourseChapter.class, integer);
    }

    @Override
    public void delete(CourseChapter entity) {
        connectionDB.getCurrentSession().delete(entity);
    }

    @Override
    public List<CourseChapter> findAll() {
        return connectionDB.getCurrentSession().createQuery("FROM CourseChapter ").list();
    }

    @Override
    public void deleteAll() {
//TODO
    }

    @Override
    public CourseChapter findByName(String name) {
        return null;
    }
}
