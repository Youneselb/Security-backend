/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package facades;

import dto.KlasseDTO;
import dto.KlasserDTO;
import entities.Klasse;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.RollbackException;
import javax.persistence.TypedQuery;
import security.errorhandling.AuthenticationException;

/**
 *
 * @author Yones
 */
public class KlasseFacade {
    
    
    
    private static EntityManagerFactory emf;
    private static KlasseFacade instance;


 private KlasseFacade() {
    }

    /**
     *
     * @param _emf
     * @return the instance of this facade.
     */
    public static KlasseFacade getKlasseFacade(EntityManagerFactory _emf) {
        if (instance == null) {
            emf = _emf;
            instance = new KlasseFacade();
        }
        return instance;
    }
    
     public List<KlasseDTO> getAllKlasser() {
    
    EntityManager em = emf.createEntityManager();
    List<Klasse> KlasseList = em.createQuery("SELECT k FROM Klasse k", Klasse.class).getResultList();
    
    return new KlasserDTO(KlasseList).getAll();
    
     }
    
    public Klasse addNewKlasse(Klasse newKlasse) throws AuthenticationException {
        
    
         EntityManager em = emf.createEntityManager();

      
         
         Klasse klasse = new Klasse(newKlasse.getSemester(), newKlasse.getNumberOfStudents(), newKlasse.getCourse());
        
         
       
        try {
          em.getTransaction().begin();
          em.persist(klasse);
          em.getTransaction().commit();

        } catch (RollbackException e) {
            throw new AuthenticationException("Class already exist.");

        } catch (Exception e){
              throw new AuthenticationException("Something went wrong. Server may be unavailable at the moment");
        } finally {
            em.close();
        }
        return klasse;


    }
 
   
    
}
