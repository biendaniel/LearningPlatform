package controllers;

import model.CourseChapter;
import service.CourseChapterService;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import java.util.List;

@Path("/coursechapters")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public class CourseChapterController {

    @Inject
    CourseChapterService courseChapterService;

    @GET
    public List<CourseChapter> getCourseChapterList() {
        CourseChapter courseChapter = courseChapterService.findById(1);
        System.out.println(courseChapter);
        List<CourseChapter> courseChapters = courseChapterService.findAll();
        return courseChapters;
    }



    @PUT
    public void addCourseChapter(CourseChapter courseChapter) {
        courseChapterService.create(courseChapter);
    }
}
