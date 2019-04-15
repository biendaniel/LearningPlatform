package controllers;

import dao.CourseChapterDao;
import model.CourseChapter;

import javax.inject.Inject;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import java.util.List;

@Path("/coursechapters")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public class CourseChapterController {

    @Inject
    CourseChapterDao chapter;

    @GET
    public List<CourseChapter> getCourseChapterList() {
        return chapter.findAll();
    }

    @POST
    public void addCourseChapter(CourseChapter forwardedChapter) {
        chapter.create(forwardedChapter);
    }


    @GET
    @Path("/{id}")
    public CourseChapter getCourseChapterById(@PathParam("id") Integer id) {
        return chapter.findById(id);
    }

    @PATCH
    @Path("/{id}")
    public void editCourseChapter(@PathParam("id") Integer id, CourseChapter forwardedChapter) {
        CourseChapter loadedCourseChapter = chapter.findById(id);
        if (forwardedChapter.getName() != null) {
            loadedCourseChapter.setName(forwardedChapter.getName());
        }
        if (forwardedChapter.getContent() != null) {
            loadedCourseChapter.setContent(forwardedChapter.getContent());
        }
        if (forwardedChapter.getFiles() != null) {
            loadedCourseChapter.setFiles(forwardedChapter.getFiles());
        }
        chapter.update(loadedCourseChapter);
    }

    @DELETE
    @Path("/{id}")
    public void deleteFile(@PathParam("id") Integer id) {
        CourseChapter loadedCourseChapter = chapter.findById(id);
        chapter.delete(loadedCourseChapter);
    }
}
