package dao;

import model.Opinion;

import javax.enterprise.context.ApplicationScoped;
import java.util.List;

@ApplicationScoped
public class OpinionDao extends DaoAbstract<Opinion, Integer> {


    public Opinion findById(Integer id) {
        connectionDB.openCurrentSession();
        Opinion opinion = connectionDB.getCurrentSession().get(Opinion.class, id);
        connectionDB.closeCurrentSession();
        return opinion;
    }

    public List<Opinion> findAll() {
        connectionDB.openCurrentSession();
        List<Opinion> opinions = connectionDB.getCurrentSession().createQuery("from Opinion").list();
        connectionDB.closeCurrentSession();
        return opinions;
    }

}