///*
// * To change this license header, choose License Headers in Project Properties.
// * To change this template file, choose Tools | Templates
// * and open the template in the editor.
// */
//package facades;
//
//import entities.Role;
//import entities.User;
//import entities.UserInfo;
//import javax.persistence.EntityManager;
//import javax.persistence.EntityManagerFactory;
//import org.junit.jupiter.api.AfterAll;
//import static org.junit.jupiter.api.Assertions.assertEquals;
//import org.junit.jupiter.api.BeforeEach;
//import org.junit.jupiter.api.Test;
//import utils.EMF_Creator;
//
//
///**
// *
// * 
// */
//public class UserFacadeTest {
//       private static EntityManagerFactory emf = EMF_Creator.createEntityManagerFactoryForTest();
//
//    private static UserFacade userFacade;
//    
//    public UserFacadeTest() {
//    }
//    
//    @BeforeEach
//    public void setUpClass() {
//        
//        userFacade = UserFacade.getUserFacade(emf);
//         EntityManager em = emf.createEntityManager();
//       
//        try {
//              em.getTransaction().begin();
//            //Delete existing users and roles to get a "fresh" database
//            em.createQuery("delete from User").executeUpdate();
//            em.createQuery("delete from UserInfo").executeUpdate();
//            em.createQuery("delete from Role").executeUpdate();
//            Role userRole = new Role("user");
//            Role adminRole = new Role("admin");
//            User user = new User("user", "test");
//            user.addRole(userRole);
//            User admin = new User("admin", "test");
//            admin.setUserInfo(new UserInfo("Christian", 33, 38.92));
//            admin.addRole(adminRole);
//            User both = new User("user_admin", "test");
//            both.setUserInfo(new UserInfo("Yvonne", 85, 83.33));
//            user.setUserInfo(new UserInfo("Jahn", 22, 76.99));
//            both.addRole(userRole);
//            both.addRole(adminRole);
//            em.persist(userRole);
//            em.persist(adminRole);
//            em.persist(user);
//            em.persist(admin);
//            em.persist(both);
//            //System.out.println("Saved test data to database");
//            em.getTransaction().commit();
//        } finally {
//            em.close();
//        }
//    }
// 
//  @Test  
//  public void testUsersIDB() {
//     
//      assertEquals(3,userFacade.getAllUsers().size());
//     
//      
//      
//      
//  }
//    
//    
//    
//    
//    
//    
//  @AfterAll
//    public static void tearDownClass() {
////        Clean up database after test is done or use a persistence unit with drop-and-create to start up clean on every test
//    }
//
//    
//
//  
// 
//}