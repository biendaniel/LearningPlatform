package controllers;

import dao.CourseDao;
import dao.UserDao;
import dao.UserOpinionDao;
import dao.UserReportDao;
import model.Course;
import model.User;
import model.UserOpinion;
import model.UserReport;

import javax.inject.Inject;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.util.List;

@Path("/users")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public class UserController {

    @Inject
    private UserDao user;
    @Inject
    private CourseDao course;
    @Inject
    private UserReportDao report;
    @Inject
    private UserOpinionDao opinion;

    @PUT
    @Path("/authorization")
    public User getUserByLoginAndPassword(User forwardedUser) {
        return user.findUserByUsernameAndPassword(forwardedUser.getUsername(), forwardedUser.getPassword());
    }

    @POST
    @Path("/registration")
    public boolean registrationUser(User forwardedUser) {
        if (user.checkUniquenessUsername(forwardedUser)) {
            user.create(forwardedUser);
            return true;
        }
        return false;
    }

    @GET
    public List<User> getUserList() {
        return user.findAll();
    }

    @POST
    @Path("/{id}/addCourse")
    public Integer addCourse(@PathParam("id") String username, Course newCourse) {
        course.create(newCourse);
        user.updateUserCourses(username, newCourse);
        return 1;
    }

    @POST
    @Path("/{id}/joinCourse")
    public void joinCourse(@PathParam("id") String username, Course course) {
        user.updateStudentCourses(username, course);
    }

    @GET
    @Path("/{id}/reports")
    public List<UserReport> getReports(@PathParam("id") String username) {
        return user.returnUserReports(username);
    }

    @POST
    @Path("/{id}/addReport")
    public void addReport(@PathParam("id") String username, UserReport newReport) {
        report.create(newReport);
        user.updateUserReports(username, newReport);
    }

    @Path("/{username}")
    @POST
    public void editUser(@PathParam("username") String username, User forwardedUser) {
        User loadedUser = user.findByUsername(username);
        if (forwardedUser.getEmail() != null) {
            loadedUser.setEmail(forwardedUser.getEmail());
        }
        if (forwardedUser.getPassword() != null) {
            loadedUser.setPassword(forwardedUser.getPassword());
        }
        if (forwardedUser.isBlocked()) {
            loadedUser.setBlocked(true);
        }
        if (!forwardedUser.isBlocked()) {
            loadedUser.setBlocked(false);
        }
        if (forwardedUser.isPremium()) {
            loadedUser.setPremium(true);
        }
        if (forwardedUser.getOpinions() != null) {
            loadedUser.getOpinions().add(forwardedUser.getOpinions().stream().findFirst().get());
        }
        if (forwardedUser.getCourses() != null) {
            loadedUser.getCourses().add(forwardedUser.getCourses().stream().findFirst().get());
        }

        user.update(loadedUser);
    }

//    @GET
//    @Path("/id/{id}")
//    public User getUserById(@PathParam("id") Integer id) {
//        User user = user.findById(id);
//        return user;
//    }

    @GET
    @Path("/{username}")
    public User getUserByName(@PathParam("username") String username) {
        User loadedUser = user.findByUsername(username);
        return loadedUser;
    }


    @DELETE
    @Path("/{username}")
    public Integer deleteUser(@PathParam("username") String username) {
        try {
            User loadedUser = user.findByUsername(username);
            user.delete(loadedUser);
        } catch (Exception e) {

        }
        return 1;
    }

    @POST
    @Path("/{username}/opinions")
    public void addOpinion(@PathParam("username") String username, UserOpinion forwardedOpinion) {
        opinion.create(forwardedOpinion);
        user.updateUserOpinions(username, forwardedOpinion);
    }

    @GET
    @Path("/{username}/opinions")
    public List<UserOpinion> getOpinions(@PathParam("username") String username) {
        return user.getOpinions(username);
    }

    @GET
    @Path("/{username}/rating")
    public double getRating(@PathParam("username") String username) {
        return user.getAvarangeOpinions(username);
    }
    @GET
    @Path("/text")
    public String getText() {
        return "COS TAM JEST";
    }


    @GET
    @Path("/{name}/find")
    public List<User> getUserByEnteredString(@PathParam("name") String name){
        return user.getUserByEnteredString(name);
    }
}