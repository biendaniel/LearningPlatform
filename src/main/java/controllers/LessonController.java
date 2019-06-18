package controllers;

import dao.LessonDao;
import model.Lesson;

import javax.inject.Inject;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import java.util.List;

@Path("/lessons")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public class LessonController {

    @Inject
    LessonDao lesson;

    @GET
    public List<Lesson> getLessonList() {
        List<Lesson> lessons = lesson.findAll();
        return lessons;
    }

    @POST
    public boolean addLesson(Lesson forwardedLesson) {
        lesson.create(forwardedLesson);
        return true;
    }

    @GET
    @Path("/{id}")
    public Lesson getLessonById(@PathParam("id") Integer id) {
        Lesson loadedLesson = lesson.findById(id);
        return loadedLesson;
    }


    @PATCH
    @Path("/{id}")
    public void editLesson(@PathParam("id") Integer id, Lesson forwardedLesson) {
        Lesson loadedLesson = lesson.findById(id);
        if (forwardedLesson.getName() != null) {
            loadedLesson.setName(forwardedLesson.getName());
        }
        if (forwardedLesson.getCost() != null) {
            loadedLesson.setCost(forwardedLesson.getCost());
        }
        lesson.update(loadedLesson);
    }

    @DELETE
    @Path("/{id}")
    public void deleteLesson(@PathParam("id") Integer id) {
        Lesson loadedLesson = lesson.findById(id);
        lesson.delete(loadedLesson);
    }

    @GET
    @Path("/user/{id}")
    public List<Lesson> getLessonForUser(@PathParam("id") Integer id) {
        List<Lesson> loadedLesson = lesson.findLessonForUser(id);
        return loadedLesson;
    }

    @GET
    @Path("/find/{name}/{address}")
    public List<Lesson> getLessonForUser(@PathParam("name") String name ,@PathParam("address") String address) {
        List<Lesson> loadedLesson = lesson.findLessonByName(name,address);
        return loadedLesson;
    }
}
