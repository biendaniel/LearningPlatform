package service;

import dao.CourseChapterDao;
import dao.CourseDao;
import hibernate.ConnectionDB;
import model.Course;
import model.CourseChapter;
import model.File;
import model.Role;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import java.util.List;

@ApplicationScoped
public class CourseService {

    @Inject
    private CourseDao courseDao;

    @Inject
    private ConnectionDB connectionDB;

    public CourseService() {
        courseDao = new CourseDao();
    }

    public List<Course> findAll() {
        connectionDB.openCurrentSession();
        List<Course> courses = courseDao.findAll();
        connectionDB.closeCurrentSession();
        return courses;
    }

    public void create(Course course) {
        connectionDB.openCurrentSessionwithTransaction();
        courseDao.create(course);
        connectionDB.closeCurrentSessionwithTransaction();
    }

    public void update(Course entity) {
        connectionDB.openCurrentSessionwithTransaction();
        courseDao.update(entity);
        connectionDB.closeCurrentSessionwithTransaction();
    }

    public Course findById(Integer id) {
        connectionDB.openCurrentSession();
        Course course = courseDao.findById(id);
        connectionDB.closeCurrentSession();
        return course;
    }

    public void delete(Course course) {
        connectionDB.openCurrentSessionwithTransaction();
        courseDao.delete(course);
        connectionDB.closeCurrentSessionwithTransaction();
    }


}
