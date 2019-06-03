import dao.*;
import model.File;
import model.Role;
import model.Subject;

import javax.inject.Inject;

public class Initial {

    @Inject
    RoleDao roleDao;
    @Inject
    SubjectDao subjectDao;
    @Inject
    FileDao fileDao;
    @Inject
    CourseDao courseDao;
    @Inject
    CourseChapterDao courseChapterDao;
    @Inject
    UserDao userDao;
    @Inject
    LessonDao lessonDao;
    @Inject
    LessonDateDao lessonDateDao;

    void initRole() {
        Role role = new Role();
        role.setId(1);
        role.setName("uczeń");

        Role role2 = new Role();
        role2.setId(2);
        role2.setName("nauczyciel");
        roleDao.create(role);
        roleDao.create(role2);
    }
    void initSubject() {
        Subject subject = new Subject();
        subject.setId(1);
        subject.setName("Java");
        Subject subject2 = new Subject();
        subject2.setId(2);
        subject2.setName("SQL");
        subjectDao.create(subject);
        subjectDao.create(subject2);
    }

}
