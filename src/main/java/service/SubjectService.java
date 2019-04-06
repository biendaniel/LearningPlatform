package service;

import hibernate.ConnectionDB;
import dao.SubjectDao;
import model.Subject;

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
        subjectDao = new SubjectDao();
    }

    public List<Subject> findAll() {
        connectionDB.openCurrentSession();
        List<Subject> subjects = subjectDao.findAll();
        connectionDB.closeCurrentSession();
        return subjects;
    }

    public void create(Subject subject) {
        connectionDB.openCurrentSessionwithTransaction();
        subjectDao.create(subject);
        connectionDB.closeCurrentSessionwithTransaction();
    }

    public void update(Subject subject) {
        connectionDB.openCurrentSessionwithTransaction();
        subjectDao.update(subject);
        connectionDB.closeCurrentSessionwithTransaction();
    }

}
