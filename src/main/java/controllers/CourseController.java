package controllers;

import dao.CourseDao;
import model.Course;

import javax.inject.Inject;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import java.util.List;

@Path("/courses")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public class CourseController {
    @Inject
    CourseDao course;

    @GET
    public List<Course> getCourseList() {
        return course.findAll();
    }

    @POST
    public void addCourse(Course newCourse) {
        course.create(newCourse);
    }


    @GET
    @Path("/{id}")
    public Course getCourseById(@PathParam("id") Integer id) {
        return course.findById(id);
    }

    @PATCH
    @Path("/{id}")
    public void editCourse(@PathParam("id") Integer id, Course forwardedCourse) {
        Course loadedCourse = course.findById(id);
        if (forwardedCourse.getName() != null) {
            loadedCourse.setName(forwardedCourse.getName());
        }
        if (forwardedCourse.getSubject() != null) {
            loadedCourse.setSubject(forwardedCourse.getSubject());
        }
        if (forwardedCourse.getChapters() != null) {
            loadedCourse.setChapters(forwardedCourse.getChapters());
        }
        if (forwardedCourse.getOpinions() != null) {
            loadedCourse.setOpinions(forwardedCourse.getOpinions());
        }
        course.update(loadedCourse);
    }

    @DELETE
    @Path("/{id}")
    public void deleteFile(@PathParam("id") Integer id) {
        Course loadedCourse = course.findById(id);
        course.delete(loadedCourse);
    }

    @GET
    @Path("/{id}/owner")
    public String getCourseOwnerUsername(@PathParam("id") Integer id) {
        return course.findCourseOwner(id);
    }
}
