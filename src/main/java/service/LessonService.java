package service;

import dao.LessonDao;
import hibernate.ConnectionDB;
import model.Lesson;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import java.util.List;

@ApplicationScoped
public class LessonService {

    @Inject
    private LessonDao lessonDao;

    @Inject
    private ConnectionDB connectionDB;

    public LessonService() {
        lessonDao = new LessonDao();
    }

    public void update(Lesson entity) {
        connectionDB.openCurrentSessionwithTransaction();
        lessonDao.update(entity);
        connectionDB.closeCurrentSessionwithTransaction();
    }

    public Lesson findById(Integer id) {
        connectionDB.openCurrentSession();
        Lesson lesson = lessonDao.findById(id);
        connectionDB.closeCurrentSession();
        return lesson;
    }

    public List<Lesson> findAll() {
        connectionDB.openCurrentSession();
        List<Lesson> lessons = lessonDao.findAll();
        connectionDB.closeCurrentSession();
        return lessons;
    }

    public void create(Lesson lesson) {
        connectionDB.openCurrentSessionwithTransaction();
        lessonDao.create(lesson);
        connectionDB.closeCurrentSessionwithTransaction();
    }

    public void delete(Lesson lesson) {
        connectionDB.openCurrentSessionwithTransaction();
        lessonDao.delete(lesson);
        connectionDB.closeCurrentSessionwithTransaction();
    }

    public LessonDao lessonDao() {
        return lessonDao;

    }
}

