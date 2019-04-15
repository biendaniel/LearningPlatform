package controllers;

import dao.UserDao;
import model.User;

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
    public Response getUserList() {
        List<User> users = user.findAll();
        return Response.ok(users).build();
    }


    @Path("/{username}")
    @PATCH
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
        if (forwardedUser.isPremium()) {
            loadedUser.setPremium(true);
        }
        if (forwardedUser.getOpinions() != null) {
            loadedUser.setOpinions(forwardedUser.getOpinions());
        }
        if (forwardedUser.getCourses() != null) {
            loadedUser.setCourses(forwardedUser.getCourses());
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
    public void deleteUser(@PathParam("username") String username) {
        try {
            User loadedUser = user.findByUsername(username);
            user.delete(loadedUser);
        } catch (Exception e) {

        }
    }
}