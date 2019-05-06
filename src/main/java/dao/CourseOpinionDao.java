package dao;

import dao.DaoAbstract;
import model.CourseOpinion;

import javax.enterprise.context.ApplicationScoped;
import java.util.List;

@ApplicationScoped
public class CourseOpinionDao extends DaoAbstract<CourseOpinion, Integer> {


    public CourseOpinion findById(Integer id) {
        connectionDB.openCurrentSession();
        CourseOpinion opinion = connectionDB.getCurrentSession().get(CourseOpinion.class, id);
        connectionDB.closeCurrentSession();
        return opinion;
    }

    public List<CourseOpinion> findAll() {
        connectionDB.openCurrentSession();
        List<CourseOpinion> opinions = connectionDB.getCurrentSession().createQuery("from CourseOpinion").list();
        connectionDB.closeCurrentSession();
        return opinions;
    }

}