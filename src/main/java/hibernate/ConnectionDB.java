package hibernate;

import model.*;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;

import javax.enterprise.context.ApplicationScoped;

@ApplicationScoped
public class ConnectionDB {

    private Session currentSession;
    private Transaction currentTransaction;

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
        Configuration configuration = new Configuration().configure("hibernate.cfg.xml").
                addAnnotatedClass(User.class)
                .addAnnotatedClass(Role.class)
                .addAnnotatedClass(Course.class)
                .addAnnotatedClass(Subject.class)
                .addAnnotatedClass(CourseChapter.class)
                .addAnnotatedClass(File.class)
                .addAnnotatedClass(UserOpinion.class)
                .addAnnotatedClass(CourseOpinion.class)
                .addAnnotatedClass(Opinion.class)
                .addAnnotatedClass(Lesson.class)
                .addAnnotatedClass(LessonDate.class)
                .addAnnotatedClass(UserReport.class);
        StandardServiceRegistryBuilder builder = new StandardServiceRegistryBuilder()
                .applySettings(configuration.getProperties());
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

}
