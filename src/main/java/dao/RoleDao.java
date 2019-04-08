package dao;


import hibernate.ConnectionDB;
import model.Role;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import java.util.List;

@ApplicationScoped
public class RoleDao implements DaoInterface<Role, Integer> {
    @Inject
    private ConnectionDB connectionDB;

    public RoleDao() {
        connectionDB = new ConnectionDB();
    }

    @Override
    public Integer create(Role entity) {
        return (Integer) connectionDB.getCurrentSession().save(entity);
    }

    @Override
    public void update(Role entity) {
        connectionDB.getCurrentSession().update(entity);
    }

    @Override
    public Role findById(Integer id) {
        Role role = connectionDB.getCurrentSession().get(Role.class, id);
        return role;
    }

    @Override
    public void delete(Role entity) {
        connectionDB.getCurrentSession().delete(entity);
    }

    @SuppressWarnings("unchecked")
    public List<Role> findAll() {
        return (List<Role>) connectionDB.getCurrentSession().createQuery("from Role").list();
    }

    @Override
    public void deleteAll() {
    }

    @Override
    public Role findByName(String name) {
        return null;
    }

}


