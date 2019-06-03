package helpful;

import model.Course;
import model.CourseOpinion;
import model.Opinion;

import java.util.ArrayList;
import java.util.List;

public class Generator {

    public static List<CourseOpinion> getRandomOpinions() {
        List<CourseOpinion> opinions = new ArrayList<>();
        CourseOpinion courseOpinion1 = new CourseOpinion();
        courseOpinion1.setValue(1);
        CourseOpinion courseOpinion2 = new CourseOpinion();
        courseOpinion1.setValue(2);
        CourseOpinion courseOpinion3 = new CourseOpinion();
        courseOpinion1.setValue(3);
        CourseOpinion courseOpinion4 = new CourseOpinion();
        courseOpinion1.setValue(2);

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
