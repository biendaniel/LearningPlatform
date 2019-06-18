package controllers;

import dao.LessonDateDao;
import model.LessonDate;

import javax.inject.Inject;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import java.util.List;

@Path("/lessonDates")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public class LessonDateController {

    @Inject
    LessonDateDao lessonDate;

    @GET
    public List<LessonDate> getLessonDateList() {
        List<LessonDate> lessonDates = lessonDate.findAll();
        return lessonDates;
    }

    @POST
    public Boolean addLessonDate(LessonDate forwardedLessonDate) {
        lessonDate.create(forwardedLessonDate);
        return true;
    }

    @GET
    @Path("/{id}")
    public LessonDate getLessonDateById(@PathParam("id") Integer id) {
        LessonDate loadedLessonDate = lessonDate.findById(id);
        return loadedLessonDate;
    }

    @GET
    @Path("/lesson/{id}")
    public List<LessonDate> getLessonDateByIdLesson(@PathParam("id") Integer id) {
        List<LessonDate> loadedLessonDate = lessonDate.findByLessonId(id);
        return loadedLessonDate;
    }


    ///Wydaje mi się, że update tutaj nie będzie potrzebny //TODO dodać PATCH
//    @PATCH
//    @Path("/{id}")
//    public void editLessonDate(@PathParam("id") Integer id, LessonDate forwardedLessonDate) {
//        LessonDate loadedLessonDate = lessonDate.findById(id);
//        if(forwardedLessonDate.getC() != null) {
//            loadedLessonDate.setName(forwardedLessonDate.getName());
//        }
//        if(forwardedLessonDate.getUrl() != null) {
//            loadedLessonDate.setUrl(forwardedLessonDate.getUrl());
//        }
//        lessonDateService.update(loadedLessonDate);
//    }

    @DELETE
    @Path("/{id}")
    public void deleteLessonDate(@PathParam("id") Integer id) {
        LessonDate loadedLessonDate = lessonDate.findById(id);
        lessonDate.delete(loadedLessonDate);
    }
}
