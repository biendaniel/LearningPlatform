package controllers;

import dao.OpinionDao;
import model.Opinion;

import javax.inject.Inject;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import java.util.List;

@Path("/opinions")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public class OpinionController {

    @Inject
    OpinionDao opinion;

    @GET
    public List<Opinion> getOpinionList() {
        List<Opinion> opinions = opinion.findAll();
        return opinions;
    }

    @POST
    public void addOpinion(Opinion forwardedOpinion) {
        opinion.create(forwardedOpinion);
    }


    @GET
    @Path("/{id}")
    public Opinion getOpinionById(@PathParam("id") Integer id) {
        Opinion loadedOpinion = opinion.findById(id);
        return loadedOpinion;
    }

    @PATCH
    @Path("/{id}")
    public void editOpinion(@PathParam("id") Integer id, Opinion forwardedOpinion) {
        Opinion loadedOpinion = opinion.findById(id);
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
        Opinion loadedOpinion = opinion.findById(id);
        opinion.delete(loadedOpinion);
    }
}

