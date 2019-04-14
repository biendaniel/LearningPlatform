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
        Course course = courseService.findById(1);
        System.out.println(course);
        List<Course> courses = courseService.findAll();
        return courses;
    }

    @POST
    public void addCourse(Course course) {
        courseService.create(course);
    }


    @GET
    @Path("/{id}")
    public Course getCourseById(@PathParam("id") Integer id) {
        Course course = courseService.findById(id);
        return course;
    }

    @PATCH
    @Path("/{id}")
    public void editCourse(@PathParam("id") Integer id, Course course) {
        Course loadedCourse = courseService.findById(id);
        if(course.getName() != null) {
            loadedCourse.setName(course.getName());
        }
        if(course.getSubject() != null) {
            loadedCourse.setSubject(course.getSubject());
        }
        if(course.getChapters() != null) {
            loadedCourse.setChapters(course.getChapters());
        }
        if(course.getOpinions() != null) {
            loadedCourse.setOpinions(course.getOpinions());
        }
        courseService.update(loadedCourse);
    }

    @DELETE
    @Path("/{id}")
    public void deleteFile(@PathParam("id") Integer id) {
        Course loadedCourse = courseService.findById(id);
        courseService.delete(loadedCourse);
    }
}
