package dao;

import model.Course;
import model.CourseChapter;

import javax.enterprise.context.ApplicationScoped;
import javax.persistence.Query;
import java.util.List;

@ApplicationScoped
public class CourseDao extends DaoAbstract<Course, Integer> {

    public Course findById(Integer id) {
        connectionDB.openCurrentSession();
        Course course = connectionDB.getCurrentSession().get(Course.class, id);
        connectionDB.closeCurrentSession();
        return course;
    }

    public List<Course> findAll() {
        connectionDB.openCurrentSession();
        List<Course> courses = (List<Course>) connectionDB.getCurrentSession().createQuery("FROM Course").list();
        connectionDB.closeCurrentSession();
        return courses;
    }

    public String findCourseOwner(Integer id) {
        connectionDB.openCurrentSession();
        Query query = connectionDB.getCurrentSession().createNativeQuery("SELECT username FROM User u, Course c WHERE c.id = :id AND c.userID = u.id");
        String username =(String) query.setParameter("id", id).getSingleResult();
        connectionDB.closeCurrentSession();
        return username;
    }

    public void updateCourseChapters(Integer id, CourseChapter chapter) {
        Course loadedCourse = findById(id);
        loadedCourse.getChapters().add(chapter);
        update(loadedCourse);
    }
}
