package controllers;


import dao.CourseDao;
import helpful.Generator;
import model.Course;
import org.junit.Assert;
import org.junit.Before;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;

import static org.mockito.BDDMockito.given;

@RunWith(MockitoJUnitRunner.class)
public class CourseControllerTest {

    @Mock
    CourseDao courseDao;

    @InjectMocks
    CourseController courseController;

    @Before
    public void init() {
        given(courseDao.findById(1)).willReturn(Generator.getRandomCourse());
    }


    @Test
    public void should_return_correct_name() {

        Course course = courseController.getCourseById(1);
        Assert.assertEquals(course.getName(), "Matma I");

    }


}