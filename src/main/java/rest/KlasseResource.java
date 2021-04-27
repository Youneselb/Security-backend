    /*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package rest;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import entities.Course;
import entities.Klasse;
import errorhandling.API_Exception;
import facades.CourseFacade;
import facades.KlasseFacade;
import java.io.IOException;
import javax.annotation.security.RolesAllowed;
import javax.persistence.EntityManagerFactory;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import security.errorhandling.AuthenticationException;
import utils.EMF_Creator;

/**
 *
 * @author Yones
 */
@Path("klasser")
public class KlasseResource {
  
    
   private static final EntityManagerFactory EMF = EMF_Creator.createEntityManagerFactory();
   private static final Gson GSON = new GsonBuilder().setPrettyPrinting().create();
   private static final KlasseFacade KlasseFACADE =  KlasseFacade.getKlasseFacade(EMF);
 
@Path("getall")
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public String getKlasser() {
    return GSON.toJson(KlasseFACADE.getAllKlasser());
    }
    
   
    @POST
   @Produces(MediaType.APPLICATION_JSON)
     @Consumes({MediaType.APPLICATION_JSON})
    @Path("newklasse")
   @RolesAllowed("admin")
   
    public String addKlasse(String addklasse) throws AuthenticationException {
        System.out.println(addklasse);  
        Klasse klasseToAdd = GSON.fromJson(addklasse, Klasse.class);
          System.out.println(klasseToAdd.getNumberOfStudents());
          
          Klasse addedKlasse = KlasseFACADE.addNewKlasse(klasseToAdd);
                return "{\"msg\": \"Class added  \"}";
    }
        

            
    }
    
    
    
    

