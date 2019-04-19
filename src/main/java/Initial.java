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
    OpinionDao opinionDao;
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

    void initFile() {
        File file = new File();
        file.setId(1);
        file.setName("Kolos Matma");
        file.setUrl("files/kolos.pdf");
        File file2 = new File();
        file2.setId(2);
        file2.setName("Kolos Polski");
        file2.setUrl("files/kolosPolski.pdf");
        fileDao.create(file);
        fileDao.create(file2);
    }
}
