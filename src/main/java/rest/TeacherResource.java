/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package rest;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import entities.Course;
import entities.Teacher;
import entities.User;
import errorhandling.API_Exception;
import facades.CourseFacade;
import facades.TeacherFacade;
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
@Path("teacher")
public class TeacherResource {
    
    private static final EntityManagerFactory EMF = EMF_Creator.createEntityManagerFactory();
    private static final Gson GSON = new GsonBuilder().setPrettyPrinting().create();
   private static final TeacherFacade TeacherFACADE =  TeacherFacade.getTeacherFacade(EMF);


   @POST
   @Produces(MediaType.APPLICATION_JSON)
   @Consumes({MediaType.APPLICATION_JSON})
    @Path("newteacher")
   @RolesAllowed("admin")
   
    public String addTeacher(String addteacher) throws AuthenticationException {
          Teacher teacherToAdd = GSON.fromJson(addteacher, Teacher.class);
          Teacher addedTeacher = TeacherFACADE.addNewTeacher(teacherToAdd);
                return "{\"msg\": \"Teacher added  \"}";
    }
     
// @Path("getallteachers")
//    @GET
//    @Produces(MediaType.APPLICATION_JSON)
//    public String getTeachers() {
//    return GSON.toJson(TeacherFACADE.getAllTeachers());
//    }
    
}
    
    
    
