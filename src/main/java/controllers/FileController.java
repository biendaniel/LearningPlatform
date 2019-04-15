package controllers;

import dao.FileDao;
import model.File;

import javax.inject.Inject;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import java.util.List;

@Path("/files")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public class FileController {

    @Inject
    FileDao file;

    @GET
    public List<File> getFileList() {
        List<File> files = file.findAll();
        return files;
    }

    @POST
    public void addFile(File forwardedFile) {
        file.create(forwardedFile);
    }

    @GET
    @Path("/{id}")
    public File getFileById(@PathParam("id") Integer id) {
        File loadedFile = file.findById(id);
        return loadedFile;
    }

    @PATCH
    @Path("/{id}")
    public void editFile(@PathParam("id") Integer id, File forwardedFile) {
        File loadedFile = file.findById(id);
        if (forwardedFile.getName() != null) {
            loadedFile.setName(forwardedFile.getName());
        }
        if (forwardedFile.getUrl() != null) {
            loadedFile.setUrl(forwardedFile.getUrl());
        }
        file.update(loadedFile);
    }

    @DELETE
    @Path("/{id}")
    public void deleteFile(@PathParam("id") Integer id) {
        File loadedFile = file.findById(id);
        file.delete(loadedFile);
    }
}
