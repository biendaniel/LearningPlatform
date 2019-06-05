package dao;

import model.Course;
import model.CourseOpinion;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.junit.MockitoJUnitRunner;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.anyInt;
import static org.mockito.BDDMockito.given;

@RunWith(MockitoJUnitRunner.class)
public class CourseDaoTest {

    private CourseDao courseDao;

    @Before
    public void init() {
        courseDao = new CourseDao();
    }
    @Test
    public void should_return_pass_result() {
        //when
        double rating = courseDao.getAvarageOpinions(getOpinionCourseMock());
        //then
        Assert.assertEquals(rating, 2.0, 0.1);
    }

    public static List<CourseOpinion> getOpinionCourseMock() {
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

}