/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package rest;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import entities.Course;
import entities.User;
import errorhandling.API_Exception;
import facades.CourseFacade;
import java.io.IOException;
import java.util.List;
import java.util.concurrent.ExecutionException;
import javax.annotation.security.RolesAllowed;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.TypedQuery;
import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.SecurityContext;
import javax.ws.rs.core.UriInfo;
import security.errorhandling.AuthenticationException;
import utils.EMF_Creator;

/**
 *
 * @author Yones
 */
@Path("course")
public class CourseResource {
    
    private static final EntityManagerFactory EMF = EMF_Creator.createEntityManagerFactory();
    private static final Gson GSON = new GsonBuilder().setPrettyPrinting().create();
   private static final CourseFacade CourseFACADE =  CourseFacade.getCourseFacade(EMF);


   @Path("getall")
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public String getCourses() {
    return GSON.toJson(CourseFACADE.getAllCourses());
    }
    
   @POST
   @Produces(MediaType.APPLICATION_JSON)
   @Consumes({MediaType.APPLICATION_JSON})
    @Path("newcourse")
   @RolesAllowed("admin")
   
    public String addCourse(String addcourse) throws AuthenticationException {
          Course courseToAdd = GSON.fromJson(addcourse, Course.class);
          Course addedCourse = CourseFACADE.addNewCourse(courseToAdd);
                return "{\"msg\": \"Course added  \"}";
    }
     
//     @PUT
//    @Path("update/{id}")
//      @RolesAllowed("user")
//    @Produces({MediaType.APPLICATION_JSON})
//    @Consumes({MediaType.APPLICATION_JSON})
//    public String updatePerson(@PathParam("id") Long id, String activity) throws API_Exception{
//     return courseFacade.editCourse(id,GSON.fromJson(course, Course.class));
//}
  

    
}
    
    
    
