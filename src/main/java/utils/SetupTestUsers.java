package utils;

import entities.Course;
import entities.Klasse;
import entities.Role;
import entities.Teacher;
import entities.User;
import facades.CourseFacade;
import facades.KlasseFacade;
import facades.TeacherFacade;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.TypedQuery;

public class SetupTestUsers {

        private static CourseFacade instance;

  public static void main(String[] args) {

    EntityManagerFactory emf = EMF_Creator.createEntityManagerFactory();
    EntityManager em = emf.createEntityManager();
 //   KlasseFacade KlasseFACADE = KlasseFacade.getKlasseFacade(emf);
    CourseFacade CourseFACADE = CourseFacade.getCourseFacade(emf);
    KlasseFacade KlasseFACADE = KlasseFacade.getKlasseFacade(emf);
    TeacherFacade TeacherFACADE = TeacherFacade.getTeacherFacade(emf);
  
    
 
    
    
    User user = new User("bobby", "bobby");
    User admin = new User("admin", "test1");
    User both = new User("user_admin", "test1");
    Course course1 = new Course("java","java");
    Course course2 = new Course("Python", "Learn to programme with Python");
    Klasse klasse = new Klasse(1,20, course1);
    Teacher teacher = new Teacher("Thomas","thomas@somewhere");
   
    
   // user.setUserInfo(new UserInfo("Erik Larsen",33,75.5));
   // admin.setUserInfo(new UserInfo("Lars Larsen",33,75.5));
   // both.setUserInfo(new UserInfo("Henrik Larsen",33,75.5));
    //user.addActivity(new Activity("Cross",30.0,13.0,"god tur"));

   //  Course course = new course("React","Learn React");  
   // Klasse klasse = new Klasse("Third Semester", 20, "React");
      //Class klasse = new class("Third Semester",20, "javascropt");  
    
    
    
    
     if(admin.getUserPass().equals("test")||user.getUserPass().equals("test")||both.getUserPass().equals("test"))
      throw new UnsupportedOperationException("You have not changed the passwords");

    em.getTransaction().begin();
    Role userRole = new Role("user");
    Role adminRole = new Role("admin");
    user.addRole(userRole);
    admin.addRole(adminRole);
    both.addRole(userRole);
    both.addRole(adminRole);
    em.persist(userRole);
    em.persist(adminRole);
    em.persist(user);
    em.persist(admin);
    em.persist(both);
    em.persist(course1);
    em.persist(course2);
    em.persist(klasse);
    em.persist(teacher);
    em.getTransaction().commit();
    System.out.println("PW: " + user.getUserPass());
    System.out.println("Testing user with OK password: " + user.verifyPassword("test"));
    System.out.println("Testing user with wrong password: " + user.verifyPassword("test1"));
    System.out.println("Created TEST Users");
    
  
}
}