package service;

import dao.OpinionDao;
import hibernate.ConnectionDB;
import model.Opinion;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import java.util.List;

@ApplicationScoped
public class OpinionService {

    @Inject
    private OpinionDao opinionDao;

    @Inject
    private ConnectionDB connectionDB;

    public OpinionService() {
        opinionDao = new OpinionDao();
    }

    public void update(Opinion entity) {
        connectionDB.openCurrentSessionwithTransaction();
        opinionDao.update(entity);
        connectionDB.closeCurrentSessionwithTransaction();
    }

    public Opinion findById(Integer id) {
        connectionDB.openCurrentSession();
        Opinion opinion = opinionDao.findById(id);
        connectionDB.closeCurrentSession();
        return opinion;
    }

    public List<Opinion> findAll() {
        connectionDB.openCurrentSession();
        List<Opinion> opinions = opinionDao.findAll();
        connectionDB.closeCurrentSession();
        return opinions;
    }

    public void create(Opinion opinion) {
        connectionDB.openCurrentSessionwithTransaction();
        opinionDao.create(opinion);
        connectionDB.closeCurrentSessionwithTransaction();
    }

    public void delete(Opinion opinion) {
        connectionDB.openCurrentSessionwithTransaction();
        opinionDao.delete(opinion);
        connectionDB.closeCurrentSessionwithTransaction();
    }

    public OpinionDao opinionDao() {
        return opinionDao;

    }
}
