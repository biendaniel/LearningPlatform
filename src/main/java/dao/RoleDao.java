package dao;


import model.Role;

import javax.enterprise.context.ApplicationScoped;
import java.util.List;

@ApplicationScoped
public class RoleDao extends DaoAbstract<Role, Integer> {


    public Role findById(Integer id) {
        connectionDB.openCurrentSession();
        Role role = connectionDB.getCurrentSession().get(Role.class, id);
        connectionDB.closeCurrentSession();
        return role;
    }


    public List<Role> findAll() {
        connectionDB.openCurrentSession();
        List<Role> roles = connectionDB.getCurrentSession().createQuery("from Role").list();
        connectionDB.closeCurrentSession();
        return roles;
    }

}


