package dao;

import model.Course;

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
        List<Course> courses = (List<Course>) connectionDB.getCurrentSession().createQuery("FROM Course");
        connectionDB.closeCurrentSession();
        return courses;
    }

    public String findCourseOwner(Integer id) {
        Query query = connectionDB.getCurrentSession().createNativeQuery("SELECT username FROM User u, Course c WHERE c.id = :id AND c.userID = u.id");
        return (String) query.setParameter("id", id).getSingleResult();
    }
}
