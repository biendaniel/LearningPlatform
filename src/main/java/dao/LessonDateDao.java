package dao;

import dao.DaoInterface;
import hibernate.ConnectionDB;
import model.LessonDate;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import java.util.List;

@ApplicationScoped
public class LessonDateDao implements DaoInterface<LessonDate, Integer> {

    @Inject
    private ConnectionDB connectionDB;

    @Override
    public Integer create(LessonDate entity) {
        return (Integer) connectionDB.getCurrentSession().save(entity);
    }

    @Override
    public void update(LessonDate entity) {
        connectionDB.getCurrentSession().update(entity);

    }

    @Override
    public LessonDate findById(Integer id) {
        LessonDate lessonDate = connectionDB.getCurrentSession().get(LessonDate.class, id);
        return lessonDate;
    }

    @Override
    public void delete(LessonDate entity) {
        connectionDB.getCurrentSession().delete(entity);
    }

    @Override
    public List<LessonDate> findAll() {
        return connectionDB.getCurrentSession().createQuery("from LessonDate").list();
    }

    @Override
    public void deleteAll() {

    }

}
