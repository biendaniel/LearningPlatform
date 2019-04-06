package service;

import dao.CourseChapterDao;
import hibernate.ConnectionDB;
import model.CourseChapter;
import model.File;
import model.Role;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import java.util.List;

@ApplicationScoped
public class CourseChapterService {

    @Inject
    private CourseChapterDao courseChapterDao;

    @Inject
    private ConnectionDB connectionDB;

    public CourseChapterService() {
        courseChapterDao = new CourseChapterDao();
    }

    public List<CourseChapter> findAll() {
        connectionDB.openCurrentSession();
        List<CourseChapter> courseChapters = courseChapterDao.findAll();
        connectionDB.closeCurrentSession();
        return courseChapters;
    }

    public void create(CourseChapter courseChapter) {
        connectionDB.openCurrentSessionwithTransaction();
        courseChapterDao.create(courseChapter);
        connectionDB.closeCurrentSessionwithTransaction();
    }

    public void update(CourseChapter entity) {
        connectionDB.openCurrentSessionwithTransaction();
        courseChapterDao.update(entity);
        connectionDB.closeCurrentSessionwithTransaction();
    }

    public CourseChapter findById(Integer id) {
        connectionDB.openCurrentSession();
        CourseChapter courseChapter = courseChapterDao.findById(id);
        connectionDB.closeCurrentSession();
        return courseChapter;
    }

    public void delete(Integer id) {
        connectionDB.openCurrentSessionwithTransaction();
        CourseChapter courseChapter = courseChapterDao.findById(id);
        courseChapterDao.delete(courseChapter);
        connectionDB.closeCurrentSessionwithTransaction();
    }


}
