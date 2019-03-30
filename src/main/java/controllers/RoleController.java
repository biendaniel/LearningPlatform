package controllers;

import model.Role;
import service.RoleService;

import javax.inject.Inject;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.util.List;
import java.util.Set;

@Path("/roles")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public class RoleController {

    @Inject
    RoleService roleService;

    @GET
    public Response getRoleList() {
        List<Role> roles = roleService.findAll();
    return Response.ok(roles).build();
    }

    @PUT
    public void addRole(Role role) {
            roleService.create(role);
    }
}
