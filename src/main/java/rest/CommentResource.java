package rest;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import dto.CommentDTO;
import entities.Comment;
import errorhandling.NotFoundException;
import facades.CommentFacade;
import javax.annotation.security.RolesAllowed;
import javax.persistence.EntityManagerFactory;
import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import security.errorhandling.AuthenticationException;
import utils.EMF_Creator;

@Path("comment")
public class CommentResource {

    private static final EntityManagerFactory EMF = EMF_Creator.createEntityManagerFactory();
    private static final Gson GSON = new GsonBuilder().setPrettyPrinting().create();
    private static final CommentFacade CommentFACADE = CommentFacade.getCommentFacade(EMF);

    @Path("getall")
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public String getComment() {
        return GSON.toJson(CommentFACADE.getAllComments());
    }

    @Path("comment/{id}")
    @GET
    @Produces({MediaType.APPLICATION_JSON})
    @RolesAllowed("admin")
    public String getComment(@PathParam("id") int id) throws NotFoundException {
        CommentDTO c = CommentFACADE.getComment((int) id);
        return GSON.toJson(c);
    }
   
    @POST
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes({MediaType.APPLICATION_JSON})
    @Path("newcomment")
    public String addComment(String addComment) throws AuthenticationException {
        Comment commentToAdd = GSON.fromJson(addComment, Comment.class);
        CommentFACADE.addNewComment(commentToAdd);
        return "{\"msg\": \"Comment added  \"}";
    }
    
    @PUT 
    @Path("editcomment/{id}")
    @Produces({MediaType.APPLICATION_JSON})
    @Consumes({MediaType.APPLICATION_JSON})
    public String editComment(@PathParam("id") int id, String comment) throws NotFoundException {
        CommentDTO cDTO = GSON.fromJson(comment, CommentDTO.class);
        cDTO.setId((int) id);
        CommentDTO cNew = CommentFACADE.editComment(cDTO);
        return GSON.toJson(cNew);
    }
    
    @DELETE
    @Path("deletecomment/{id}")
    @Produces({MediaType.APPLICATION_JSON})
    @RolesAllowed("admin")
    public String deleteComment(@PathParam("id") int id) throws NotFoundException {
        CommentDTO cDeleted = CommentFACADE.deleteComment((int) id);
        return GSON.toJson(cDeleted);
    }
    
}
