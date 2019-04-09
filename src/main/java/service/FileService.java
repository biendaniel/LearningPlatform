package service;

import dao.FileDao;
import dao.RoleDao;
import hibernate.ConnectionDB;
import model.File;
import model.Role;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import java.util.List;

@ApplicationScoped
public class FileService {

    @Inject
    private FileDao fileDao;

    @Inject
    private ConnectionDB connectionDB;

    public FileService() {
        fileDao = new FileDao();
    }

    public void update(File entity) {
        connectionDB.openCurrentSessionwithTransaction();
        fileDao.update(entity);
        connectionDB.closeCurrentSessionwithTransaction();
    }

    public File findById(Integer id) {
        connectionDB.openCurrentSession();
        File file = fileDao.findById(id);
        connectionDB.closeCurrentSession();
        return file;
    }

    public List<File> findAll() {
        connectionDB.openCurrentSession();
        List<File> files = fileDao.findAll();
        connectionDB.closeCurrentSession();
        return files;
    }

    public void create(File file) {
        connectionDB.openCurrentSessionwithTransaction();
        fileDao.create(file);
        connectionDB.closeCurrentSessionwithTransaction();
    }

    public void delete(File file) {
        connectionDB.openCurrentSessionwithTransaction();
        fileDao.delete(file);
        connectionDB.closeCurrentSessionwithTransaction();
    }

    public FileDao fileDao() {
        return fileDao;

    }
}
