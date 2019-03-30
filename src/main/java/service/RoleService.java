package service;

import dao.ConnectionDB;
import dao.RoleDao;
import dao.UserDao;
import model.Role;
import model.User;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import java.util.List;
import java.util.Set;


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

//    public void delete(Integer id) {
//        connectionDB.openCurrentSessionwithTransaction();
//        User user = userDao.findById(id);
//        userDao.delete(user);
//        connectionDB.closeCurrentSessionwithTransaction();
//    }

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
//
//    public boolean checkUniquenessUsername(User user) {
//        List<User> users = findAll();
//        for(User it: users) {
//            if(it.getUsername().equalsIgnoreCase(user.getUsername())) {
//                return false;
//            }
//        }
//        return true;
//    }
    public RoleDao roleDao() {
        return roleDao;

    }
//    }
}