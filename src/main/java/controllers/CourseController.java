package controllers;

import model.Course;
import service.CourseService;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import java.util.List;

@Path("/courses")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public class CourseController {

    @Inject
    CourseService courseService;

    @GET
    public List<Course> getCourseList() {
        List<Course> courses = courseService.findAll();
        return courses;
    }



    @PUT
    public void addCourse(Course course) {
        courseService.create(course);
    }
}
