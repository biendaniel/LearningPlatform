package dao;

import model.Lesson;

import javax.enterprise.context.ApplicationScoped;
import java.util.List;

@ApplicationScoped
public class LessonDao extends DaoAbstract<Lesson, Integer> {

    public Lesson findById(Integer id) {
        connectionDB.openCurrentSession();
        Lesson lesson = connectionDB.getCurrentSession().get(Lesson.class, id);
        connectionDB.closeCurrentSession();
        return lesson;
    }

    public List<Lesson> findAll() {
        connectionDB.openCurrentSession();
        List<Lesson> lessons = (List<Lesson>) connectionDB.getCurrentSession().createQuery("FROM Lesson").list();
        connectionDB.closeCurrentSession();
        return lessons;
    }
}
