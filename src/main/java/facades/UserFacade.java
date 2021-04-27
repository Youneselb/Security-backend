// /*
// * To change this license header, choose License Headers in Project Properties.
// * To change this template file, choose Tools | Templates
// * and open the template in the editor.
// */
//package facades;
//
//import dto.UserDTO;
//import dto.UsersDTO;
//import entities.Role;
//import entities.User;
//import java.io.IOException;
//import java.util.List;
//import javax.persistence.EntityManager;
//import javax.persistence.EntityManagerFactory;
//import utils.EMF_Creator;
//
///**
// *
// * @author Yones
// */
//public class UserFacade {
//    
//     private static EntityManagerFactory emf;
//    private static UserFacade instance;
//
//
// private UserFacade() {
//    }
//
//    /**
//     *
//     * @param _emf
//     * @return the instance of this facade.
//     */
//    public static UserFacade getUserFacade(EntityManagerFactory _emf) {
//        if (instance == null) {
//            emf = _emf;
//            instance = new UserFacade();
//        }
//        return instance;
//    }
//    
//    public List<UserDTO> getAllUsers() {
//    
//    EntityManager em = emf.createEntityManager();
//    List<User> UserList = em.createQuery("SELECT u FROM User u", User.class).getResultList();
//    
//    return new UsersDTO(UserList).getAll();
//}
//    
//    
//
//}
//    
    
    

