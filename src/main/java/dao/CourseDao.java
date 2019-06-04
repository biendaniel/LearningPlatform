package dao;

import model.Course;
import model.CourseChapter;
import model.CourseOpinion;
import model.Subject;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import javax.persistence.Query;
import java.util.List;
import java.util.OptionalDouble;

@ApplicationScoped
public class CourseDao extends DaoAbstract<Course, Integer> {


    @Inject
    SubjectDao subject;
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

    public void updateCourseOpinions(Integer id, CourseOpinion opinion) {
        Course loadedCourse = findById(id);
        loadedCourse.getOpinions().add(opinion);
        update(loadedCourse);
    }

    public List<CourseOpinion> getOpinions(Integer id) {
        Course loadedCourse = findById(id);
        return loadedCourse.getOpinions();
    }

    public double getAvarageOpinions(Integer id) {
        List<CourseOpinion> opinions = getOpinions(id);
        System.out.println("Bylimy tu");
        return opinions
                .stream()
                .mapToDouble(CourseOpinion::getValue)
                .average()
                .orElse(Double.NaN);
    }


    public List<Course> getCoursesBySubject(Integer id) {
        Subject loadedSubject = subject.findById(id);
        connectionDB.openCurrentSession();
        Query query = connectionDB.getCurrentSession().createQuery("FROM Course where subject =: subject");
        List<Course> courses =  query
                .setParameter("subject", loadedSubject)
                .getResultList();
        connectionDB.closeCurrentSession();
        return courses;
    }

    public List<Course> getCoursesByEnteredString(String enteredString) {
        connectionDB.openCurrentSession();
        Query query = connectionDB.getCurrentSession().createQuery("FROM Course where name like :string");
        List<Course> courses =  query
                .setParameter("string", "%" + enteredString + "%")
                .getResultList();
        connectionDB.closeCurrentSession();
        return courses;
    }

}
