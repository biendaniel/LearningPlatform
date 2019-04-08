package controllers;

import model.LessonDate;
import service.LessonDateService;

import javax.inject.Inject;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import java.util.List;

@Path("/lessonDates")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public class LessonDateController {

    @Inject
    LessonDateService lessonDateService;

    @GET
    public List<LessonDate> getLessonDateList() {
        List<LessonDate> lessonDates = lessonDateService.findAll();
        return lessonDates;
    }

    @PUT
    public void addLessonDate(LessonDate lessonDate) {
        lessonDateService.create(lessonDate);
    }

    @GET
    @Path("/{id}")
    public LessonDate getLessonDateById(@PathParam("id") Integer id) {
        LessonDate lessonDate = lessonDateService.findById(id);
        return lessonDate;
    }


    /////Wydaje mi się, że update tutaj nie będzie potrzebny
//    @PATCH
//    @Path("/{id}")
//    public void editLessonDate(@PathParam("id") Integer id, LessonDate lessonDate) {
//        LessonDate loadedLessonDate = lessonDateService.findById(id);
//        if(lessonDate.getC() != null) {
//            loadedLessonDate.setName(lessonDate.getName());
//        }
//        if(lessonDate.getUrl() != null) {
//            loadedLessonDate.setUrl(lessonDate.getUrl());
//        }
//        lessonDateService.update(loadedLessonDate);
//    }

    @DELETE
    @Path("/{id}")
    public void deleteLessonDate(@PathParam("id") Integer id) {
        LessonDate loadedLessonDate = lessonDateService.findById(id);
        lessonDateService.delete(loadedLessonDate);
    }
}
