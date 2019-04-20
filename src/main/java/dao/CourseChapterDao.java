package dao;

import model.CourseChapter;

import javax.enterprise.context.ApplicationScoped;
import java.util.List;

@ApplicationScoped
public class CourseChapterDao extends DaoAbstract<CourseChapter, Integer> {

    public List<CourseChapter> findAll() {
        connectionDB.openCurrentSession();
        List<CourseChapter> chapters = (List<CourseChapter>) connectionDB.getCurrentSession().createQuery("FROM CourseChapter").list();
        connectionDB.closeCurrentSession();
        return chapters;
    }

    public CourseChapter findById(Integer id) {
        connectionDB.openCurrentSession();
        CourseChapter chapter = connectionDB.getCurrentSession().get(CourseChapter.class, id);
        connectionDB.closeCurrentSession();
        return chapter;
    }
}
