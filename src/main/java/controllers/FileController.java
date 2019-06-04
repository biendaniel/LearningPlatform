package controllers;

//import com.sun.jersey.core.header.FormDataContentDisposition;
//import com.sun.jersey.multipart.FormDataParam;
//import com.sun.jersey.server.impl.model.method.dispatch.MultipartFormDispatchProvider;
import dao.FileDao;
import model.File;

import javax.inject.Inject;
import javax.servlet.http.HttpServletRequest;
import javax.ws.rs.*;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.io.InputStream;
import java.util.List;
//import org.jboss.resteasy.plugins.providers.multipart.MultipartFormDataInput;
//import org.jboss.resteasy.plugins.providers.multipart.InputPart;

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

//    @POST
//    @Path("/img")
//    @Consumes(MediaType.MULTIPART_FORM_DATA)
//    public Response uploadFile(@DefaultValue("true") @FormDataParam("file") InputStream uploadedStream,
//                               @FormDataParam("file") FormDataContentDisposition fileDetail) {
//        String fileName = fileDetail.getFileName();
////        saveToFile(uploadedStream,fileName);
//        String output = "File saved to server location : " + fileName;
//        return Response.status(200).entity(output).build();
//    }

//    @POST
//    @Path("/img")
//    @Consumes("multipart/form-data")
//    public Response uploadFile( MultipartFormDataInput input) {
//        String fileName = "";
////        saveToFile(uploadedStream,fileName);
//        String output = "File saved to server location : " + fileName;
//        return Response.status(200).entity(output).build();
//    }


}
