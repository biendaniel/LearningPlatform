package service;

import dao.UserDao;
import model.User;

import java.util.List;

public class UserService {

    private static UserDao userDao;

    public UserService() {
        userDao = new UserDao();
    }

    public List<User> findAll(){
        System.out.println("tuu");
        userDao.openCurrentSession();
        System.out.println("www");
        List<User> users = userDao.findAll();
        userDao.closeCurrentSession();
        System.out.println("POO");
        System.out.println(users);
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