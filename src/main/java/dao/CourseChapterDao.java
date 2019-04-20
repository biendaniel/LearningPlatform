package dao;

import model.Course;
import model.CourseChapter;
import model.File;

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
        CourseChapter courseChapter = connectionDB.getCurrentSession().get(CourseChapter.class, id);
        connectionDB.closeCurrentSession();
        return courseChapter;

    }

    public void updateChapterFiles(Integer id, File file) {
        CourseChapter loadedChapter = findById(id);
        loadedChapter.getFiles().add(file);
        update(loadedChapter);
    }

}
