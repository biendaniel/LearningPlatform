package dao;

import model.Course;
import model.Lesson;
import model.User;

import javax.enterprise.context.ApplicationScoped;
import javax.persistence.Query;
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
    public List<Lesson> findLessonForUser(Integer id) {
        connectionDB.openCurrentSession();
        User user = new User();
        user.setId(id);
        Query query = connectionDB.getCurrentSession().createQuery("FROM Lesson where ownerLesson =: user");
        List<Lesson> lessons =  query
                .setParameter("user", user)
                .getResultList();
        connectionDB.closeCurrentSession();
        return lessons;
    }
    public List<Lesson> findLessonByName(String name, String address) {
        connectionDB.openCurrentSession();
        Query query = connectionDB.getCurrentSession().createQuery("FROM Lesson where name like :name OR city like :address");
        List<Lesson> lessons =  query
                .setParameter("name", "%" + name + "%")
                .setParameter("address", "%" + address + "%")
                .getResultList();
        connectionDB.closeCurrentSession();
        return lessons;
    }
    }

