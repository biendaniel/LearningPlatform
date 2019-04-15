package dao;

import model.Role;
import org.junit.Before;

import java.util.LinkedList;
import java.util.List;

class RoleDaoTest {

    RoleDao roleDao = new RoleDao();

    @Before
    void fillRoleList() {
        List<Role> roles = new LinkedList<>();
        roles.add(new Role("aaa", 1));
        roles.add(new Role("bb", 2));
    }


}