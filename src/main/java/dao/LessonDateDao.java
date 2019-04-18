package dao;

import model.LessonDate;

import javax.enterprise.context.ApplicationScoped;
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


}
