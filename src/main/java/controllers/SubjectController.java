package controllers;

import dao.SubjectDao;
import model.Subject;

import javax.inject.Inject;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import java.util.List;

@Path("/subjects")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public class SubjectController {

    @Inject
    SubjectDao subject;

    @GET
    public List<Subject> getSubjectList() {
        List<Subject> subjects = subject.findAll();
        return subjects;
    }

    @POST
    public void addSubject(Subject forwardedSubject) {
        subject.create(forwardedSubject);
    }

    @GET
    @Path("/{id}")
    public Subject getSubjectById(@PathParam("id") Integer id) {
        return subject.findById(id);
    }

    @DELETE
    @Path("/{id}")
    public void removeSubject(@PathParam("id") Integer id) {
        Subject loadedSubject = subject.findById(id);
        subject.delete(loadedSubject);
    }

    @PATCH
    @Path("/{id}")
    public void updateSubject(@PathParam("id") Integer id, Subject forwardedSubject) {

        if (forwardedSubject.getName() != null) {
            Subject loadedSubject = subject.findById(id);
            loadedSubject.setName(forwardedSubject.getName());
            subject.update(loadedSubject);
        }
    }
}
