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

    @PUT
    public void addRole(Role role) {
        roleService.create(role);
    }

    @GET
    public Response getRoleList() {
        List<Role> roles = roleService.findAll();
    return Response.ok(roles).build();
    }

    @GET
    @Path("/{id}")
    public Role getRoleById(@PathParam("id") Integer id) {
        Role role = roleService.findById(id);
        return role;
    }

    @PATCH
    @Path("/{id}")
    public void editRole(@PathParam("id") Integer id, Role role) {
        Role loadedRole = roleService.findById(id);
        if(role.getName() != null) {
            loadedRole.setName(role.getName());
            roleService.update(loadedRole);
        }
    }

    @DELETE
    @Path("/{id}")
    public void deleteRole(@PathParam("id") Integer id) {
        Role loadedRole = roleService.findById(id);
        roleService.delete(loadedRole);
    }


}
