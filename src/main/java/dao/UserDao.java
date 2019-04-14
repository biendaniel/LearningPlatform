package dao;


import hibernate.ConnectionDB;
import model.Course;
import model.User;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import javax.persistence.Query;
import java.util.List;

@ApplicationScoped
public class UserDao implements DaoInterface<User, Integer> {
    @Inject
    private ConnectionDB connectionDB;

    public UserDao() {
        connectionDB = new ConnectionDB();
    }

    @Override
    public Integer create(User entity) {
        return (Integer) connectionDB.getCurrentSession().save(entity);
    }

    @Override
    public void update(User entity) {
        connectionDB.getCurrentSession().update(entity);
    }

    @Override
    public User findById(Integer integer) {
        return null;
    }


    @SuppressWarnings("unchecked")
    public User findUserByUsernameAndPassword(String username, String password) {
        Query query = connectionDB.getCurrentSession().createQuery("FROM User WHERE username = :username AND password = :password ");
        query.setParameter("username", username);
        query.setParameter("password", password);
        User user = null;
        try {
            user = (User) query.getSingleResult();
            return user;
        } catch (Exception e) {
            return user;
        }
    }

    @Override
    public void delete(User entity) {
        connectionDB.getCurrentSession().delete(entity);
    }

    @SuppressWarnings("unchecked")
    public List<User> findAll() {
        return (List<User>) connectionDB.getCurrentSession().createQuery("from User").list();
    }


    @Override
    public void deleteAll() {
    }


    public User findByUsername(String username) {
        Query query = connectionDB.getCurrentSession().createQuery("FROM User WHERE username = :username ");
        query.setParameter("username", username);
        User user = null;
        try {
            user = (User) query.getSingleResult();
            return user;
        } catch(Exception e) {
            return user;
        }

    }

}


