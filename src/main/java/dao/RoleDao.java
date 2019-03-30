package dao;


import model.Role;
import model.User;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import javax.persistence.Query;
import java.util.List;
import java.util.Set;

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

}


