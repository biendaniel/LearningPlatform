package controllers;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import dao.CourseDao;
import model.Course;
import model.CourseOpinion;
import org.junit.Assert;
import org.junit.Before;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;

import static org.mockito.ArgumentMatchers.anyInt;
import static org.mockito.BDDMockito.given;

@RunWith(MockitoJUnitRunner.class)
public class CourseControllerTest {

    @Mock
    CourseDao courseDao;

    @InjectMocks
    CourseController courseController;

    @Before
    public void init() {
        given(courseDao.findById(anyInt())).willReturn(getCourseMock());
    }


    @Test
    public void should_return_correct_name() {
        Course course = courseController.getCourseById(1);
        Assert.assertEquals(course.getName(), "Matma I");
    }



    public static List<CourseOpinion> getCourseOpinionsMock() {
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

    public static Course getCourseMock() {
        Course course = new Course();
        course.setId(1);
        course.setName("Matma I");
        course.setOpinions(getCourseOpinionsMock());
        return course;
    }


}