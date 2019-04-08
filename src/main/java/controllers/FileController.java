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
        List<File> files = fileService.findAll();
        return files;
    }

    @PUT
    public void addFile(File file) {
        fileService.create(file);
    }

    @GET
    @Path("/{id}")
    public File getFileById(@PathParam("id") Integer id) {
        File file = fileService.findById(id);
        return file;
    }

    @PATCH
    @Path("/{id}")
    public void editFile(@PathParam("id") Integer id, File file) {
        File loadedFile = fileService.findById(id);
        if(file.getName() != null) {
            loadedFile.setName(file.getName());
        }
        if(file.getUrl() != null) {
            loadedFile.setUrl(file.getUrl());
        }
        fileService.update(loadedFile);
    }

    @DELETE
    @Path("/{id}")
    public void deleteFile(@PathParam("id") Integer id) {
        File loadedFile = fileService.findById(id);
        fileService.delete(loadedFile);
    }
}
