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
        given(courseDao.findById(anyInt())).willReturn(getRandomCourse());
        given(courseDao.getOpinions(anyInt())).willReturn(getRandomOpinions());
    }


    @Test
    public void should_return_correct_name() {
        Course course = courseController.getCourseById(1);
        Assert.assertEquals(course.getName(), "Matma I");
    }

    @Test
    public void should_return_pass_result() {
        double rating = courseController.getRating(1);
        Assert.assertEquals(rating, 2.0, 0.1);
    }

    public static List<CourseOpinion> getRandomOpinions() {
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

    public static Course getRandomCourse() {
        Course course = new Course();
        course.setId(1);
        course.setName("Matma I");
        course.setOpinions(getRandomOpinions());
        return course;
    }


}