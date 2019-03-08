package service;

import dao.UserDao;
import model.User;

import java.util.List;

public class UserService {

    private static UserDao userDao;

    public UserService() {
        userDao = new UserDao();
    }

    public void persist(User entity) {
        userDao.openCurrentSessionwithTransaction();
        userDao.persist(entity);
        userDao.closeCurrentSessionwithTransaction();
    }

    public void update(User entity) {
        userDao.openCurrentSessionwithTransaction();
        userDao.update(entity);
        userDao.closeCurrentSessionwithTransaction();
    }

    public User findById(Integer id) {
        userDao.closeCurrentSession();
        User user = userDao.findById(id);
        userDao.closeCurrentSession();
        return user;
    }

    public void delete(Integer id){
        userDao.openCurrentSessionwithTransaction();
        User user = userDao.findById(id);
        userDao.delete(user);
        userDao.closeCurrentSessionwithTransaction();
    }

    public List<User> findAll(){
        userDao.openCurrentSession();
        List<User> users = userDao.findAll();
        userDao.closeCurrentSession();
        return users;
    }

//    public  UserDao userDao() {
//        return userDao;
//    }
//
//    public  void setUserDao(UserDao userDao) {
//        UserService.userDao = userDao;

    public UserDao userDao(){
        return userDao;

    }
//    }
}