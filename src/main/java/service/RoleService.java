package service;

import hibernate.ConnectionDB;
import dao.RoleDao;
import model.Role;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import java.util.List;


@ApplicationScoped
public class RoleService {

    @Inject
    private RoleDao roleDao;

    @Inject
    private ConnectionDB connectionDB;
    public RoleService() {
        roleDao = new RoleDao();
    }

    public void update(Role entity) {
        connectionDB.openCurrentSessionwithTransaction();
        roleDao.update(entity);
        connectionDB.closeCurrentSessionwithTransaction();
    }

    public Role findById(Integer id) {
        connectionDB.openCurrentSession();
        Role role = roleDao.findById(id);
        connectionDB.closeCurrentSession();
        return role;
    }

    public List<Role> findAll() {
        connectionDB.openCurrentSession();
        List<Role> roles = roleDao.findAll();
        connectionDB.closeCurrentSession();
        return roles;
    }

    public void create(Role role) {
        connectionDB.openCurrentSessionwithTransaction();
        roleDao.create(role);
        connectionDB.closeCurrentSessionwithTransaction();
    }

    public void delete(Role role) {
        connectionDB.openCurrentSessionwithTransaction();
        roleDao.delete(role);
        connectionDB.closeCurrentSessionwithTransaction();
    }

    public RoleDao roleDao() {
        return roleDao;

    }
}