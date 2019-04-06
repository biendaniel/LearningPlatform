package controllers;

import model.File;
import service.FileService;

import javax.inject.Inject;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import java.util.List;

@Path("/files")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public class FileController {

    @Inject
    FileService fileService;

    @GET
    public List<File> getFileList() {
        File file = fileService.findById(1);
        System.out.println(file);
        List<File> files = fileService.findAll();
        return files;
    }

    @PUT
    public void addFile(File file) {
        fileService.create(file);
    }

}
