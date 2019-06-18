package controllers;

import dao.CourseDao;
import dao.SubjectDao;
import model.Course;
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
    @Inject
    CourseDao course;

    @GET
    public List<Subject> getSubjectList() {
        List<Subject> subjects = subject.findAll();
        return subjects;
    }

    @POST
    public boolean addSubject(Subject forwardedSubject) {
        subject.create(forwardedSubject);
        return true;
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

    @GET
    @Path("/{id}/courses")
    public List<Course> getSubjectCourses (@PathParam("id") Integer id) {
        return course.getCoursesBySubject(id);
    }
}
