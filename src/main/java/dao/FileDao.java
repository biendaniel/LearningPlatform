package dao;

import hibernate.ConnectionDB;
import model.File;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import java.util.List;
@ApplicationScoped
public class FileDao implements DaoInterface<File, Integer>{

    @Inject
    private ConnectionDB connectionDB;

    @Override
    public Integer create(File entity) {
        return (Integer) connectionDB.getCurrentSession().save(entity);
    }

    @Override
    public void update(File entity) {
        connectionDB.getCurrentSession().update(entity);

    }

    @Override
    public File findById(Integer id) {
        File file = connectionDB.getCurrentSession().get(File.class, id);
        return file;
    }

    @Override
    public void delete(File entity) {
        connectionDB.getCurrentSession().delete(entity);
    }

    @Override
    public List<File> findAll() {
        return connectionDB.getCurrentSession().createQuery("from File").list();
    }

    @Override
    public void deleteAll() {

    }

}
