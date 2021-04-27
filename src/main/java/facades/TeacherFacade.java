/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package facades;


import dtos.TeacherDTO;
import entities.Teacher;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.RollbackException;
import security.errorhandling.AuthenticationException;

/**
 *
 * @author Yones
 */
public class TeacherFacade {
    
    
        private static EntityManagerFactory emf;
    private static TeacherFacade instance;

/**
     *
     * @param _emf
     * @return the instance of this facade.
     */
    public static TeacherFacade getTeacherFacade(EntityManagerFactory _emf) {
        if (instance == null) {
            emf = _emf;
            instance = new TeacherFacade();
        }
        return instance;
    }

 
    
    
    public Teacher addNewTeacher(Teacher newTeacher) throws AuthenticationException {
        
    
         EntityManager em = emf.createEntityManager();

      
         
         Teacher teacher = new Teacher(newTeacher.getName(), newTeacher.getEmail());
        
         
       
        try {
          em.getTransaction().begin();
          em.persist(teacher);
          em.getTransaction().commit();

        } catch (RollbackException e) {
            throw new AuthenticationException("Teacher already exist.");

        } catch (Exception e){
              throw new AuthenticationException("Something went wrong. Server may be unavailable at the moment");
        } finally {
            em.close();
        }
        return teacher;


    }
    
    
}
