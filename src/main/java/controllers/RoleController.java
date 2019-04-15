package controllers;

import dao.RoleDao;
import model.Role;

import javax.inject.Inject;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import java.util.List;

@Path("/roles")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public class RoleController {

    @Inject
    RoleDao role;

    @POST
    public void addRole(Role forwardedRole) {
        role.create(forwardedRole);
    }

    @GET
    public List<Role> getRoleList() {
        return role.findAll();
    }

    @GET
    @Path("/{id}")
    public Role getRoleById(@PathParam("id") Integer id) {
        return role.findById(id);
    }

    @PATCH
    @Path("/{id}")
    public void editRole(@PathParam("id") Integer id, Role forwardedRole) {

        if (forwardedRole.getName() != null) {
            Role loadedRole = role.findById(id);
            loadedRole.setName(forwardedRole.getName());
            role.update(loadedRole);
        }
    }

    @DELETE
    @Path("/{id}")
    public void deleteRole(@PathParam("id") Integer id) {
        Role loadedRole = role.findById(id);
        role.delete(loadedRole);
    }


}
