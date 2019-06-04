package controllers;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import dao.CourseDao;
import helpful.Generator;
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
        given(courseDao.findById(anyInt())).willReturn(Generator.getRandomCourse());
//        given(courseDao.getOpinions(anyInt())).willReturn(Generator.getRandomOpinions());
    }


    @Test
    public void should_return_correct_name() {
        Course course = courseController.getCourseById(1);
        Assert.assertEquals(course.getName(), "Matma I");
    }

    @Test
    public void should_return_pass_result() {
        double rating = courseController.getRating(1);
        courseController
                .getCourseById(1)
                .getOpinions()
                .stream()
                .mapToInt(CourseOpinion::getValue)
                .forEach(System.out::println);
//
        System.out.println(rating);
        Assert.assertEquals(rating, 2.0, 0.1);
    }


}