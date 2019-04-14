package controllers;

import model.CourseChapter;
import model.File;
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

    @POST
    public void addCourseChapter(CourseChapter courseChapter) {
        courseChapterService.create(courseChapter);
    }


    @GET
    @Path("/{id}")
    public CourseChapter getCourseChapterById(@PathParam("id") Integer id) {
        CourseChapter courseChapter = courseChapterService.findById(id);
        return courseChapter;
    }

    @PATCH
    @Path("/{id}")
    public void editCourseChapter(@PathParam("id") Integer id, CourseChapter courseChapter) {
        CourseChapter loadedCourseChapter = courseChapterService.findById(id);
        if(courseChapter.getName() != null) {
            loadedCourseChapter.setName(courseChapter.getName());
        }
        if(courseChapter.getContent() != null) {
            loadedCourseChapter.setContent(courseChapter.getContent());
        }
        if(courseChapter.getFiles() != null) {
            loadedCourseChapter.setFiles(courseChapter.getFiles());
        }
        courseChapterService.update(loadedCourseChapter);
    }

    @DELETE
    @Path("/{id}")
    public void deleteFile(@PathParam("id") Integer id) {
        CourseChapter loadedCourseChapter = courseChapterService.findById(id);
        courseChapterService.delete(loadedCourseChapter);
    }
}
