package dao;

import model.Lesson;
import model.LessonDate;
import model.User;

import javax.enterprise.context.ApplicationScoped;
import javax.persistence.Query;
import java.util.List;

@ApplicationScoped
public class LessonDateDao extends DaoAbstract<LessonDate, Integer> {

    public LessonDate findById(Integer id) {
        connectionDB.openCurrentSession();
        LessonDate lessonDate = connectionDB.getCurrentSession().get(LessonDate.class, id);
        connectionDB.closeCurrentSession();
        return lessonDate;
    }

    public List<LessonDate> findAll() {
        connectionDB.openCurrentSession();
        List<LessonDate> lessonDates = (List<LessonDate>) connectionDB.getCurrentSession().createQuery("FROM LessonDate").list();
        connectionDB.closeCurrentSession();
        return lessonDates;
    }
    public List<LessonDate> findByLessonId(Integer id) {
        connectionDB.openCurrentSession();
        Lesson lesson = new Lesson();
        lesson.setId(id);
        Query query = connectionDB.getCurrentSession().createQuery("FROM LessonDate where lesson =: lesson");
        List<LessonDate> lessonsDate =  query
                .setParameter("lesson", lesson)
                .getResultList();
        connectionDB.closeCurrentSession();
        return lessonsDate;
    }

}
