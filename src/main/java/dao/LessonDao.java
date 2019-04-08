package dao;

import hibernate.ConnectionDB;
import model.Lesson;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import java.util.List;

@ApplicationScoped
public class LessonDao implements DaoInterface<Lesson, Integer>{

    @Inject
    private ConnectionDB connectionDB;

    @Override
    public Integer create(Lesson entity) {
        return (Integer) connectionDB.getCurrentSession().save(entity);
    }

    @Override
    public void update(Lesson entity) {
        connectionDB.getCurrentSession().update(entity);

    }

    @Override
    public Lesson findById(Integer id) {
        Lesson lesson = connectionDB.getCurrentSession().get(Lesson.class, id);
        return lesson;
    }

    @Override
    public void delete(Lesson entity) {
        connectionDB.getCurrentSession().delete(entity);
    }

    @Override
    public List<Lesson> findAll() {
        return connectionDB.getCurrentSession().createQuery("from Lesson").list();
    }

    @Override
    public void deleteAll() {

    }

    @Override
    public Lesson findByName(String name) {
        return null;
    }
}
