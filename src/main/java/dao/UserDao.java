package dao;


import model.User;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;
//import org.hibernate.Session;
//import org.hibernate.SessionFactory;
//import org.hibernate.Transaction;
//import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
//import org.hibernate.cfg.Configuration;

import javax.enterprise.context.ApplicationScoped;
import javax.persistence.Query;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;

@ApplicationScoped
public class UserDao implements DaoInterface<User, Integer> {
    private Session currentSession;
    private Transaction currentTransaction;

    public UserDao() {
    }

    private Session getCurrentSession() {
        return currentSession;
    }

    public Session openCurrentSession() {
        currentSession = getSessionFactory().openSession();
        return currentSession;
    }

    public Session openCurrentSessionwithTransaction() {
        currentSession = getSessionFactory().openSession();
        currentTransaction = currentSession.beginTransaction();
        return currentSession;
    }

    public void closeCurrentSession() {
        currentSession.close();
    }

    public void closeCurrentSessionwithTransaction() {
        currentTransaction.commit();
        currentSession.close();
    }

    private static SessionFactory getSessionFactory() {
        Configuration configuration = new Configuration().configure("hibernate.cfg.xml").addAnnotatedClass(User.class);
        StandardServiceRegistryBuilder builder = new StandardServiceRegistryBuilder()
                .applySettings(configuration.getProperties());
        //            SessionFactory sessionFactory = new Configuration()
//                    .configure("hibernate.cfg.xml")
//                    .addAnnotatedClass(User.class)
//                    .buildSessionFactory();
        return configuration.buildSessionFactory(builder.build());
    }

    public void setCurrentSession(Session currentSession) {
        this.currentSession = currentSession;
    }

    public Transaction getCurrentTransaction() {
        return currentTransaction;
    }

    public void setCurrentTransaction(Transaction currentTransaction) {
        this.currentTransaction = currentTransaction;
    }

    @Override
    public void persist(User entity) {
        getCurrentSession().save(entity);
    }

    @Override
    public void update(User entity) {
        getCurrentSession().update(entity);
    }

    @Override
    public User findById(Integer id) {
        User user = getCurrentSession().get(User.class, id);
        return user;
    }

    @SuppressWarnings("unchecked")
    public User findByUsernameAndPassword(String username, String password) {
        Query query = getCurrentSession().createQuery("FROM User WHERE username = :username AND password = :password ");
        query.setParameter("username", username);
        query.setParameter("password", password);
        User user = null;
        try {
        user = (User) query.getSingleResult();
        } catch(Exception e){
            return user;
        }
        return user;
    }

    @Override
    public void delete(User entity) {
        getCurrentSession().delete(entity);
    }

    @SuppressWarnings("unchecked")
    public List<User> findAll() {
        return (List<User>) getCurrentSession().createQuery("from User").list();
    }

    @Override
    public void deleteAll() {
    }

    public int createUser(User user) {
        Query query =   getCurrentSession().createQuery("SELECT MAX(id) FROM User");
        int id = (int) query.getSingleResult();
        persist(user);
        return ++id;
    }
//
//    public int createReservation(Reservation reservation) {
//        Query query =   getCurrentSession().createQuery("SELECT MAX(id) FROM User");
//        int id = (int) query.getSingleResult();
//        reservations.put(id, reservation);
//        return id;
//    }
}

