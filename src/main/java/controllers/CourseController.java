package controllers;

import dao.CourseChapterDao;
import dao.CourseDao;
import dao.UserDao;
import model.Course;
import model.CourseChapter;

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
    @Inject
    UserDao user;
    @Inject
    CourseChapterDao chapter;

    @GET
    public List<Course> getCourseList() {
        return course.findAll();
    }

    @POST
    public void addCourse(Course forwardedCourse) {
        course.create(forwardedCourse);
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
            loadedCourse.getChapters().add(forwardedCourse.getChapters().stream().findFirst().get());
        }
        if (forwardedCourse.getOpinions() != null) {
            loadedCourse.getOpinions().add(forwardedCourse.getOpinions().stream().findFirst().get());
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


    @POST
    @Path("/{id}/addChapter")
    public void addChapter(@PathParam("id") Integer id, CourseChapter forwardedChapter) {
        chapter.create(forwardedChapter);
        course.updateCourseChapters(id, forwardedChapter);
    }
}