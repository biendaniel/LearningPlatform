package service;

import dao.UserDao;
import model.User;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import java.util.List;


@ApplicationScoped
public class UserService {

    @Inject
    private UserDao userDao;

    public UserService() {
        userDao = new UserDao();
    }

    public void persist(User entity) {
        userDao.openCurrentSessionwithTransaction();
        userDao.createUser(entity);
        userDao.closeCurrentSessionwithTransaction();
    }

    public void update(User entity) {
        userDao.openCurrentSessionwithTransaction();
        userDao.update(entity);
        userDao.closeCurrentSessionwithTransaction();
    }

    public User findById(Integer id) {
        userDao.openCurrentSession();
        User user = userDao.findById(id);
        userDao.closeCurrentSession();
        return user;
    }

    public void delete(Integer id) {
        userDao.openCurrentSessionwithTransaction();
        User user = userDao.findById(id);
        userDao.delete(user);
        userDao.closeCurrentSessionwithTransaction();
    }

    public List<User> findAll() {
        userDao.openCurrentSession();
        List<User> users = userDao.findAll();
        userDao.closeCurrentSession();
        return users;
    }

    public User getUserByLoginAndPassword(String username, String password) {
        userDao.openCurrentSession();
        User user = userDao.findUserByUsernameAndPassword(username, password);
        userDao.closeCurrentSession();
        return user;
    }

    public Integer createUser(User user) {
        userDao.openCurrentSessionwithTransaction();
        Integer idUser = userDao.createUser(user);
        userDao.closeCurrentSessionwithTransaction();
        return idUser;
    }

    public UserDao userDao() {
        return userDao;

    }
//    }
}