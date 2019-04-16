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
        connectionDB.openCurrentSession();
        Query query = connectionDB.getCurrentSession().createQuery("FROM User WHERE username = :username AND password = :password ");
        query.setParameter("username", username);
        query.setParameter("password", password);
        return getUserFromQuery(query);
    }

    private User getUserFromQuery(Query query) {
        User user = null;
        try {
            user = (User) query.getSingleResult();
            connectionDB.closeCurrentSession();
            return user;
        } catch (Exception e) {
            connectionDB.closeCurrentSession();
            return user;
        }
    }

    public User findByUsername(String username) {
        connectionDB.openCurrentSession();
        Query query = connectionDB.getCurrentSession().createQuery("FROM User WHERE username = :username ");
        query.setParameter("username", username);
        return getUserFromQuery(query);
    }



    public boolean checkUniquenessUsername(User user) {
        connectionDB.openCurrentSession();
        List<User> users = findAll();
        for (User it : users) {
            if (it.getUsername().equalsIgnoreCase(user.getUsername())) {
                connectionDB.closeCurrentSession();
                return false;
            }
        }
        connectionDB.closeCurrentSession();
        return true;
    }


}


