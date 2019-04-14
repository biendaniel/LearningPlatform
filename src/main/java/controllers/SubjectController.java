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
    public List<Subject> getSubjectList() {
        List<Subject> subjects = subjectService.findAll();
        return subjects;
    }

    @POST
    public void addSubject(Subject subject) {
        subjectService.create(subject);
    }

    @GET
    @Path("/{id}")
    public Subject getSubjectById(@PathParam("id") Integer id) {
        Subject subject = subjectService.findById(id);
        return subject;
    }

    @DELETE
    @Path("/{id}")
    public void removeSubject(@PathParam("id") Integer id) {
        Subject subject = subjectService.findById(id);
        subjectService.delete(subject);
    }
    @PATCH
    @Path("/{id}")
    public void updateSubject(@PathParam("id") Integer id, Subject subject) {

        if(subject.getName() != null) {
            Subject loadedSubject = subjectService.findById(id);
            loadedSubject.setName(subject.getName());
            subjectService.update(loadedSubject);
        }
    }
}
