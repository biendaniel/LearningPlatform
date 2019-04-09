package controllers;

import model.Opinion;
import service.OpinionService;

import javax.inject.Inject;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import java.util.List;

@Path("/opinions")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public class OpinionController {

    @Inject
    OpinionService opinionService;

    @GET
    public List<Opinion> getOpinionList() {
        Opinion opinion = opinionService.findById(1);
        System.out.println(opinion);
        List<Opinion> opinions = opinionService.findAll();
        return opinions;
    }

    @PUT
    public void addOpinion(Opinion opinion) {
        opinionService.create(opinion);
    }


    @GET
    @Path("/{id}")
    public Opinion getOpinionById(@PathParam("id") Integer id) {
        Opinion opinion = opinionService.findById(id);
        return opinion;
    }

    @PATCH
    @Path("/{id}")
    public void editOpinion(@PathParam("id") Integer id, Opinion opinion) {
        Opinion loadedOpinion = opinionService.findById(id);
        if(opinion.getContent() != null) {
            loadedOpinion.setContent(opinion.getContent());
        }
        if(opinion.getValue() != null) {
            loadedOpinion.setValue(opinion.getValue());
        }
        if(opinion.getRaterUser() != null) {
            loadedOpinion.setRaterUser(opinion.getRaterUser());
        }
        opinionService.update(loadedOpinion);
    }

    @DELETE
    @Path("/{id}")
    public void deleteFile(@PathParam("id") Integer id) {
        Opinion loadedOpinion = opinionService.findById(id);
        opinionService.delete(loadedOpinion);
    }
}

