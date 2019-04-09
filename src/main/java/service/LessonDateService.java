package service;

import dao.LessonDateDao;
import hibernate.ConnectionDB;
import model.LessonDate;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import java.util.List;

@ApplicationScoped
public class LessonDateService {

    @Inject
    private LessonDateDao lessonDateDao;

    @Inject
    private ConnectionDB connectionDB;

    public LessonDateService() {
        lessonDateDao = new LessonDateDao();
    }

    public void update(LessonDate entity) {
        connectionDB.openCurrentSessionwithTransaction();
        lessonDateDao.update(entity);
        connectionDB.closeCurrentSessionwithTransaction();
    }

    public LessonDate findById(Integer id) {
        connectionDB.openCurrentSession();
        LessonDate lessonDate = lessonDateDao.findById(id);
        connectionDB.closeCurrentSession();
        return lessonDate;
    }

    public List<LessonDate> findAll() {
        connectionDB.openCurrentSession();
        List<LessonDate> lessonDates = lessonDateDao.findAll();
        connectionDB.closeCurrentSession();
        return lessonDates;
    }

    public void create(LessonDate lessonDate) {
        connectionDB.openCurrentSessionwithTransaction();
        lessonDateDao.create(lessonDate);
        connectionDB.closeCurrentSessionwithTransaction();
    }

    public void delete(LessonDate lessonDate) {
        connectionDB.openCurrentSessionwithTransaction();
        lessonDateDao.delete(lessonDate);
        connectionDB.closeCurrentSessionwithTransaction();
    }

    public LessonDateDao lessonDateDao() {
        return lessonDateDao;

    }
}
