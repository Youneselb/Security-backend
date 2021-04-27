package facades;

import entities.User;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import security.errorhandling.AuthenticationException;


public class User_Facade {

    private static EntityManagerFactory emf;
    private static User_Facade instance;

    private User_Facade() {
    }

  public User getVeryfiedUser(String username, String password) throws AuthenticationException {
        EntityManager em = emf.createEntityManager();
        User user;
        try {
            user = em.find(User.class, username);
            if (user == null || !user.verifyPassword(password)) {
                throw new AuthenticationException("Invalid user name or password");
            }
        } finally {
            em.close();
        }
        return user;
    }
  public static User_Facade getUser_Facade(EntityManagerFactory _emf) {
        if (instance == null) {
            emf = _emf;
            instance = new User_Facade();
        }
        return instance;
    }
    }