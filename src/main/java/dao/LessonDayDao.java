package dao;

import model.Lesson;
import model.LessonDate;
import model.LessonDay;
import model.User;

import javax.enterprise.context.ApplicationScoped;
import javax.persistence.Query;
import java.util.List;

@ApplicationScoped
public class LessonDayDao extends DaoAbstract<LessonDate, Integer> {

    public LessonDay findById(Integer id) {
        connectionDB.openCurrentSession();
        LessonDay lessonDay = connectionDB.getCurrentSession().get(LessonDay.class, id);
        connectionDB.closeCurrentSession();
        return lessonDay;
    }

    public List<LessonDay> findAll() {
        connectionDB.openCurrentSession();
        List<LessonDay> lessonsDay = (List<LessonDay>) connectionDB.getCurrentSession().createQuery("FROM LessonDay ").list();
        connectionDB.closeCurrentSession();
        return lessonsDay;
    }
}
