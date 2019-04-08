package service;

import hibernate.ConnectionDB;
import dao.SubjectDao;
import model.Subject;
import model.User;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import java.util.List;

@ApplicationScoped
public class SubjectService {

    @Inject
    private SubjectDao subjectDao;

    @Inject
    private ConnectionDB connectionDB;

    public SubjectService() {
        // TODO subjectDao = new SubjectDao();  usunąłem to, bo wydaje się być zbędne
    }

    public void create(Subject subject) {
        connectionDB.openCurrentSessionwithTransaction();
        subjectDao.create(subject);
        connectionDB.closeCurrentSessionwithTransaction();
    }

    public List<Subject> findAll() {
        connectionDB.openCurrentSession();
        List<Subject> subjects = subjectDao.findAll();
        connectionDB.closeCurrentSession();
        return subjects;
    }

    public Subject findById(Integer id) {
        connectionDB.openCurrentSession();
        Subject subject = subjectDao.findById(id);
        connectionDB.closeCurrentSession();
        return subject;
    }

    public void update(Subject subject) {
        connectionDB.openCurrentSessionwithTransaction();
        subjectDao.update(subject);
        connectionDB.closeCurrentSessionwithTransaction();
    }

    public void delete(Subject subject) {
        connectionDB.openCurrentSessionwithTransaction();
        subjectDao.delete(subject);
        connectionDB.closeCurrentSessionwithTransaction();
    }

}
