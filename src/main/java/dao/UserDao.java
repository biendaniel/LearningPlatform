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

import java.util.List;

    public class UserDao implements DaoInterface<User, Integer> {
        private Session currentSession;
        private Transaction currentTransaction;

        public UserDao() {
        }

        public Session getCurrentSession() {
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
            SessionFactory sessionFactory = configuration.buildSessionFactory(builder.build());
//            SessionFactory sessionFactory = new Configuration()
//                    .configure("hibernate.cfg.xml")
//                    .addAnnotatedClass(User.class)
//                    .buildSessionFactory();
            return sessionFactory;
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


        @Override
        public void delete(User entity) {
        getCurrentSession().delete(entity);
        }

        @SuppressWarnings("unchecked")
        public List<User> findAll() {
            List<User> users = (List<User>) getCurrentSession().createQuery("from User").list();
            return users;
        }

        @Override
        public void deleteAll() {

        }
    }

