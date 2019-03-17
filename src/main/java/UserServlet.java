import model.User;
import service.UserService;

import javax.inject.Inject;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.net.URI;
import java.net.URISyntaxException;
import java.util.List;

@Path("/users")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public class UserServlet {
    @Inject
    private UserService userService;

    //    @Author("Daniel")
    @GET
    @Path("/login")
    public Response checkLoginAndPassword(User dataFromUser) {

        User user = userService.checkUserData(dataFromUser.getUsername(), dataFromUser.getPassword());
        return Response.ok(user).build();
    }

    @GET
    public Response getUserList() {
        List<User> users = userService.findAll();
        return Response.ok(users).build();
    }

    @PUT
    public Response addUser(User user) {
        int id = userService.createUser(user);
        URI location = null;
        try {
            location = new URI("/" + id);
        } catch (URISyntaxException e) {
            e.printStackTrace();
        }
        return Response.created(location).build();
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
        } catch(Exception e) {
            return false;
        }
        return true;
    }
}