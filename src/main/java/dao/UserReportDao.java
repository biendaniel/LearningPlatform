package dao;

import model.UserReport;

import javax.enterprise.context.ApplicationScoped;
import java.util.List;

@ApplicationScoped
public class UserReportDao extends DaoAbstract<UserReport, Integer> {

    public List<UserReport> findAll() {
        connectionDB.openCurrentSession();
        List<UserReport> reports = (List<UserReport>) connectionDB.getCurrentSession().createQuery("FROM UserReport").list();
        connectionDB.closeCurrentSession();
        return reports;
    }
}
