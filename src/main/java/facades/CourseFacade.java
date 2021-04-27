package facades;

import dto.CourseDTO;
import dto.CoursesDTO;
import entities.Course;
import errorhandling.API_Exception;
import java.io.IOException;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.RollbackException;
import security.errorhandling.AuthenticationException;
import utils.EMF_Creator;

/**
 *
 * @author Yones
 */
public class CourseFacade {
    
     private static EntityManagerFactory emf;
    private static CourseFacade instance;


 private CourseFacade() {
    }

    /**
     *
     * @param _emf
     * @return the instance of this facade.
     */
    public static CourseFacade getCourseFacade(EntityManagerFactory _emf) {
        if (instance == null) {
            emf = _emf;
            instance = new CourseFacade();
        }
        return instance;
    }
 
    
    public List<CourseDTO> getAllCourses() {
    
    EntityManager em = emf.createEntityManager();
    List<Course> CourseList = em.createQuery("SELECT c FROM Course c", Course.class).getResultList();
    
    return new CoursesDTO(CourseList).getAll();
    
    
    }
    
    public Course addNewCourse(Course newCourse) throws AuthenticationException {
        
        if (newCourse.getCourseName().isEmpty() || newCourse.getCourseDescription().isEmpty() ) {
                throw new AuthenticationException("Course name or description must not be empty");
            }
         EntityManager em = emf.createEntityManager();

      
         
         Course course = new Course(newCourse.getCourseName(), newCourse.getCourseDescription());
        
         
       
        
        try {
          em.getTransaction().begin();
          em.persist(course);
          em.getTransaction().commit();

        } catch (RollbackException e) {
            throw new AuthenticationException("Course already exist.");

        } catch (Exception e){
              throw new AuthenticationException("Something went wrong. Server may be unavailable at the moment");
        } finally {
            em.close();
        }
        return course;


    }
      public String editCourse(long id, Course course) throws API_Exception{
       
     EntityManager em = emf.createEntityManager();
       
       try {
            em.getTransaction().begin();
            
           Course c = em.find(Course.class, id);
           c.setId(course.getId());
           c.setCourseName(course.getCourseName());
           c.setCourseDescription(course.getCourseDescription());
             em.getTransaction().commit();
       } catch (Exception e){
           
           throw new API_Exception(e.getMessage());
           
       } finally {
           em.close();
       }
       
       return "complete";
   




}
        
    }