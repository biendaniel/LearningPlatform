package dao;

import model.Subject;

import javax.enterprise.context.ApplicationScoped;
import java.util.List;

@ApplicationScoped
public class SubjectDao extends DaoAbstract<Subject, Integer> {

    public Subject findById(Integer id) {
        connectionDB.openCurrentSession();
        Subject subject = connectionDB.getCurrentSession().get(Subject.class, id);
        connectionDB.closeCurrentSession();
        return subject;
    }

    public List<Subject> findAll() {
        connectionDB.openCurrentSession();
        List<Subject> subjects = (List<Subject>) connectionDB.getCurrentSession().createQuery("FROM Subject");
        connectionDB.closeCurrentSession();
        return subjects;
    }

}
