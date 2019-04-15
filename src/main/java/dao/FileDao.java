package dao;

import model.File;

import javax.enterprise.context.ApplicationScoped;
import java.util.List;

@ApplicationScoped
public class FileDao extends DaoAbstract<File, Integer> {

    public File findById(Integer id) {
        return connectionDB.getCurrentSession().get(File.class, id);
    }

    public List<File> findAll() {
        connectionDB.openCurrentSession();
        List<File> files = (List<File>) connectionDB.getCurrentSession().createQuery("FROM File").list();
        connectionDB.closeCurrentSession();
        return files;
    }
}
