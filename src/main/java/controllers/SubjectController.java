package controllers;

import model.Subject;
import service.SubjectService;

import javax.inject.Inject;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.util.List;

@Path("/subjects")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public class SubjectController {

    @Inject
    SubjectService subjectService;

    @GET
    public Response getSubjectList() {
        List<Subject> subjects = subjectService.findAll();
        return Response.ok(subjects).build();
    }

    @PUT
    public void addSubject(Subject subject) {
        subjectService.create(subject);
    }

//    @PATCH
//    @Path("/{id}")
//    public boolean updateSubject(@PathParam("id") Integer id, Subject subject) {
//
//        try {
//            subjectService.update();
//            subjectService.update(subject);
//            return true;
//        }catch(Exception e) {
//            return false;
//        }
//    }
}
