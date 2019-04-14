package controllers;

import model.User;
import service.UserService;

import javax.inject.Inject;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.util.List;
import java.util.Set;

@Path("/users")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public class UserController {
    @Inject
    private UserService userService;

    @PUT
    @Path("/authorization")
    public Response getUserByLoginAndPassword(User user) {
        User theUser = userService.getUserByLoginAndPassword(user.getUsername(), user.getPassword());
        return Response.ok(theUser).build();
    }

    @POST
    @Path("/registration")
    public boolean registrationUser(User user) {
        if (userService.checkUniquenessUsername(user)) {
            userService.createUser(user);
            return true;
        }
        return false;
    }

    @GET
    public Response getUserList() {
        List<User> users = userService.findAll();
        return Response.ok(users).build();
    }


    @Path("/{username}")
    @PATCH
    public void editUser(@PathParam("username") String username, User user) {
        User loadedUser = userService.findByUsername(username);
        if (user.getEmail() != null) {
            loadedUser.setEmail(user.getEmail());
        }
        if (user.getPassword() != null) {
            loadedUser.setPassword(user.getPassword());
        }
        if (user.isBlocked()) {
            loadedUser.setBlocked(true);
        }
        if (user.isPremium()) {
            loadedUser.setPremium(true);
        }
        if (user.getOpinions() != null) {
            loadedUser.setOpinions(user.getOpinions());
        }
        if(user.getCourses() != null) {
            loadedUser.setCourses(user.getCourses());
        }

        userService.update(loadedUser);
    }

//    @GET
//    @Path("/id/{id}")
//    public User getUserById(@PathParam("id") Integer id) {
//        User user = userService.findById(id);
//        return user;
//    }

    @GET
    @Path("/{username}")
    public User getUserByName(@PathParam("username") String username) {
        User user = userService.findByUsername(username);
        return user;
    }


    @DELETE
    @Path("/{username}")
    public boolean deleteUser(@PathParam("username") String id) {
        try {
            userService.delete(id);
        } catch (Exception e) {
            return false;
        }
        return true;
    }
}