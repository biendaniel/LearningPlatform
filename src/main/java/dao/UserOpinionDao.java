package dao;

import model.UserOpinion;

import javax.enterprise.context.ApplicationScoped;
import java.util.List;

@ApplicationScoped
public class UserOpinionDao extends DaoAbstract<UserOpinion, Integer> {


    public UserOpinion findById(Integer id) {
        connectionDB.openCurrentSession();
        UserOpinion opinion = connectionDB.getCurrentSession().get(UserOpinion.class, id);
        connectionDB.closeCurrentSession();
        return opinion;
    }

    public List<UserOpinion> findAll() {
        connectionDB.openCurrentSession();
        List<UserOpinion> opinions = connectionDB.getCurrentSession().createQuery("from UserOpinion").list();
        connectionDB.closeCurrentSession();
        return opinions;
    }

}