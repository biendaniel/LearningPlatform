package dao;

import model.Course;
import model.CourseOpinion;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.hamcrest.Matchers;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.anyInt;
import static org.mockito.BDDMockito.given;

@RunWith(MockitoJUnitRunner.class)
public class CourseDaoTest {

    @Mock
    CourseDao courseDao;


    @Test
    public void getAvarangeOpinionsTestShouldReturnCorrectResult() {
        //given
        courseDao = new CourseDao();
        //when
        System.out.println(getOpinionCourseMock());
        double rating = courseDao.getAvarageOpinions(getOpinionCourseMock());
        //then
        Assert.assertEquals(rating, 2.0, 0.1);
    }

    @Test
    public void getAvarangeOpinionsTestShouldReturnWrongResult1() {
        //when
        courseDao = new CourseDao();
        double rating = courseDao.getAvarageOpinions(getOpinionCourseMock());
        //then
        Assert.assertNotEquals(rating, 2.1, 0.1);
    }

    @Test
    public void getAvarangeOpinionsTestShouldReturnWrongResult2() {
        //when
        courseDao = new CourseDao();
        double rating = courseDao.getAvarageOpinions(getOpinionCourseMock());
        //then
        Assert.assertNotEquals(rating, 1.9, 0.1);
    }

    @Test
    public void findAllTestShouldReturnCorrectLengthOfList() {
        //given
        given(courseDao.findAll()).willReturn(getCoursesMock());
        final int LIST_LENGTH = 5;
        //when
        List<Course> courses = courseDao.findAll();
        //then
        Assert.assertThat(courses, Matchers.hasSize(LIST_LENGTH));
    }

    @Test
    public void findAllTestShouldReturnWrongLengthOfList1() {
        //given
        given(courseDao.findAll()).willReturn(getCoursesMock());
        final int LIST_LENGTH = 4;
        //when
        List<Course> courses = courseDao.findAll();
        //then
        Assert.assertNotEquals(courses, Matchers.hasSize(LIST_LENGTH));
    }

    @Test
    public void findAllTestShouldReturnWrongLengthOfList2() {
        //given
        given(courseDao.findAll()).willReturn(getCoursesMock());
        final int LIST_LENGTH = 6;
        //when
        List<Course> courses = courseDao.findAll();
        //then
        Assert.assertNotEquals(courses, Matchers.hasSize(LIST_LENGTH));
    }

    @Test
    public void findByIdTestShouldReturnEqualsCourseName() {
        //given
        final String COURSE_NAME = "Matma I";
        given(courseDao.findById(anyInt())).willReturn(getCourseMock());
        //when
        Course course = courseDao.findById(1);
        //then
        Assert.assertEquals(course.getName(), COURSE_NAME);
    }

    @Test
    public void findByIdTestShouldReturnNotEqualsCourseName() {
        //given
        final String COURSE_NAME = "Matma 1";
        given(courseDao.findById(anyInt())).willReturn(getCourseMock());
        //when
        Course course = courseDao.findById(1);
        //then
        Assert.assertNotEquals(course.getName(), COURSE_NAME);
    }




    public List<CourseOpinion> getOpinionCourseMock() {
        List<CourseOpinion> opinions = new ArrayList<>();
        CourseOpinion courseOpinion1 = new CourseOpinion();
        courseOpinion1.setValue(1);
        CourseOpinion courseOpinion2 = new CourseOpinion();
        courseOpinion2.setValue(2);
        CourseOpinion courseOpinion3 = new CourseOpinion();
        courseOpinion3.setValue(3);
        CourseOpinion courseOpinion4 = new CourseOpinion();
        courseOpinion4.setValue(2);

        opinions.add(courseOpinion1);
        opinions.add(courseOpinion2);
        opinions.add(courseOpinion3);
        opinions.add(courseOpinion4);

        return opinions;
    }

    public List<Course> getCoursesMock() {

        List<Course> courses = new LinkedList<>();
        courses.add(new Course());
        courses.add(new Course());
        courses.add(new Course());
        courses.add(new Course());
        courses.add(new Course());
        System.out.println(courses.size());
        courses.get(0).setName("aaa");
        return courses;

    }

    public Course getCourseMock() {
        Course course = new Course();
        course.setId(1);
        course.setName("Matma I");
        course.setOpinions(getOpinionCourseMock());
        return course;
    }

}