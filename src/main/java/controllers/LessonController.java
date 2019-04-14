package controllers;

import model.Lesson;
import service.LessonService;

import javax.inject.Inject;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import java.util.List;

@Path("/lessons")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public class LessonController {

    @Inject
    LessonService lessonService;

    @GET
    public List<Lesson> getLessonList() {
        List<Lesson> lessons = lessonService.findAll();
        return lessons;
    }

    @POST
    public void addLesson(Lesson lesson) {
        lessonService.create(lesson);
    }

    @GET
    @Path("/{id}")
    public Lesson getLessonById(@PathParam("id") Integer id) {
        Lesson lesson = lessonService.findById(id);
        return lesson;
    }


    @PATCH
    @Path("/{id}")
    public void editLesson(@PathParam("id") Integer id, Lesson lesson) {
        Lesson loadedLesson = lessonService.findById(id);
        if(lesson.getName() != null) {
            loadedLesson.setName(lesson.getName());
        }
        if(lesson.getCost() != null) {
            loadedLesson.setCost(lesson.getCost());
        }
        lessonService.update(loadedLesson);
    }

    @DELETE
    @Path("/{id}")
    public void deleteLesson(@PathParam("id") Integer id) {
        Lesson loadedLesson = lessonService.findById(id);
        lessonService.delete(loadedLesson);
    }
}
