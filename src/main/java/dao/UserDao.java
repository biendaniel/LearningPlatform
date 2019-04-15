package dao;


import model.User;

import javax.enterprise.context.ApplicationScoped;
import javax.persistence.Query;
import java.util.List;

@ApplicationScoped
public class UserDao extends DaoAbstract<User, Integer> {

    public List<User> findAll() {
        connectionDB.openCurrentSession();
        List<User> users = connectionDB.getCurrentSession().createQuery("from User").list();
        connectionDB.closeCurrentSession();
        return users;
    }

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


    public User findByUsername(String username) {
        Query query = connectionDB.getCurrentSession().createQuery("FROM User WHERE username = :username ");
        query.setParameter("username", username);
        User user = null;
        try {
            user = (User) query.getSingleResult();
            return user;
        } catch (Exception e) {
            return user;
        }
    }

    public boolean checkUniquenessUsername(User user) {
        List<User> users = findAll();
        for (User it : users) {
            if (it.getUsername().equalsIgnoreCase(user.getUsername())) {
                return false;
            }
        }
        return true;
    }


}


