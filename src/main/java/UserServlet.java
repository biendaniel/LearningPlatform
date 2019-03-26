import model.User;
import service.UserService;
import service.UserServiceH2;

import javax.inject.Inject;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.net.URI;
import java.net.URISyntaxException;
import java.util.LinkedList;
import java.util.List;

@Path("/users")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public class UserServlet {
    @Inject
    private UserService userService;

    @GET
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

    @PUT
    public void createUser(User user) {
        userService.createUser(user);
    }

    @GET
    @Path("/{id}")
    public Response getUserById(@PathParam("id") Integer id) {
        User user = userService.findById(id);
        return Response.ok(user).build();
    }


    @DELETE
    @Path("/{id}")
    public boolean deleteUser(@PathParam("id") Integer id) {
        try {
            userService.delete(id);
        } catch (Exception e) {
            return false;
        }
        return true;
    }
}