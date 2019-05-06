package controllers;

import dao.UserOpinionDao;
import model.UserOpinion;

import javax.inject.Inject;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import java.util.List;

@Path("/opinions")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public class OpinionController {

    @Inject
    UserOpinionDao opinion;

    @GET
    public List<UserOpinion> getOpinionList() {
        List<UserOpinion> opinions = opinion.findAll();
        return opinions;
    }

    @POST
    public void addOpinion(UserOpinion forwardedOpinion) {
        opinion.create(forwardedOpinion);
    }


    @GET
    @Path("/{id}")
    public UserOpinion getOpinionById(@PathParam("id") Integer id) {
        UserOpinion loadedOpinion = opinion.findById(id);
        return loadedOpinion;
    }

    @PATCH
    @Path("/{id}")
    public void editOpinion(@PathParam("id") Integer id, UserOpinion forwardedOpinion) {
        UserOpinion loadedOpinion = opinion.findById(id);
        if (forwardedOpinion.getContent() != null) {
            loadedOpinion.setContent(forwardedOpinion.getContent());
        }
        if (forwardedOpinion.getValue() != null) {
            loadedOpinion.setValue(forwardedOpinion.getValue());
        }
        if (forwardedOpinion.getRaterUser() != null) {
            loadedOpinion.setRaterUser(forwardedOpinion.getRaterUser());
        }
        opinion.update(loadedOpinion);
    }

    @DELETE
    @Path("/{id}")
    public void deleteOpinion(@PathParam("id") Integer id) {
        UserOpinion loadedOpinion = opinion.findById(id);
        opinion.delete(loadedOpinion);
    }
}

