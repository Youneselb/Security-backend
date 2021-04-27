///*
// * To change this license header, choose License Headers in Project Properties.
// * To change this template file, choose Tools | Templates
// * and open the template in the editor.
// */
//package rest;
//
//import com.google.gson.Gson;
//import com.google.gson.GsonBuilder;
//import entities.User;
//import errorhandling.API_Exception;
//import java.io.IOException;
//import java.util.List;
//import java.util.concurrent.ExecutionException;
//import javax.annotation.security.RolesAllowed;
//import javax.persistence.EntityManager;
//import javax.persistence.EntityManagerFactory;
//import javax.persistence.TypedQuery;
//import javax.ws.rs.DELETE;
//import javax.ws.rs.GET;
//import javax.ws.rs.Path;
//import javax.ws.rs.Produces;
//import javax.ws.rs.core.Context;
//import javax.ws.rs.core.MediaType;
//import javax.ws.rs.core.SecurityContext;
//import javax.ws.rs.core.UriInfo;
//import utils.EMF_Creator;
//
///**
// *
// * @author Yones
// */
//@Path("User")
//public class UserResource {
//    
//    private static final EntityManagerFactory EMF = EMF_Creator.createEntityManagerFactory();
//    private static final Gson GSON = new GsonBuilder().setPrettyPrinting().create();
//   private static final UserFacade UserFACADE =  UserFacade.getUserFacade(EMF);
//   private static final FetchFacade FetchFACADE =  FetchFacade.getFetchFacade(EMF);
//
//   @Path("getall")
//    @GET
//    @Produces(MediaType.APPLICATION_JSON)
//    public String getUsers() {
//    return GSON.toJson(UserFACADE.getAllUsers());
//    }
//    @Path("chuck")
//    @GET
//    @Produces(MediaType.APPLICATION_JSON)
//    public String getChuck() throws IOException {
//    return GSON.toJson(FetchFACADE.chuckJokes());
//}
//    
//  
//    }
//    
//    
