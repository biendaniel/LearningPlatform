package service;

import hibernate.ConnectionDB;
import dao.UserDao;
import model.Course;
import model.User;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import java.util.List;


@ApplicationScoped
public class UserService {

    @Inject
    private UserDao userDao;

    @Inject
    private ConnectionDB connectionDB;
    public UserService() {
        userDao = new UserDao();
    }

    public void update(User entity) {
        connectionDB.openCurrentSessionwithTransaction();
        userDao.update(entity);
        connectionDB.closeCurrentSessionwithTransaction();
    }



    public User findByUsername(String username) {
        connectionDB.openCurrentSession();
        User user = userDao.findByUsername(username);
        connectionDB.closeCurrentSession();
        return user;
    }

    public void delete(String username) {
        connectionDB.openCurrentSessionwithTransaction();
        User user = userDao.findByUsername(username);
        userDao.delete(user);
        connectionDB.closeCurrentSessionwithTransaction();
    }

    public List<User> findAll() {
        connectionDB.openCurrentSession();
        List<User> users = userDao.findAll();
        connectionDB.closeCurrentSession();
        return users;
    }

    public User getUserByLoginAndPassword(String username, String password) {
        connectionDB.openCurrentSession();
        User user = userDao.findUserByUsernameAndPassword(username, password);
        connectionDB.closeCurrentSession();
        return user;
    }

    public Integer createUser(User user) {
        connectionDB.openCurrentSessionwithTransaction();
        Integer idUser = userDao.create(user);
        connectionDB.closeCurrentSessionwithTransaction();
        return idUser;
    }

    public boolean checkUniquenessUsername(User user) {
        List<User> users = findAll();
        for(User it: users) {
            if(it.getUsername().equalsIgnoreCase(user.getUsername())) {
                return false;
            }
        }
        return true;
    }
    public UserDao userDao() {
        return userDao;

    }
//    }
}