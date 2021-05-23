package facades;

import dto.CommentDTO;
import dto.CommentsDTO;
import entities.Comment;
import errorhandling.API_Exception;
import errorhandling.NotFoundException;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.RollbackException;
import security.errorhandling.AuthenticationException;

public class CommentFacade {

    private static EntityManagerFactory emf;
    private static CommentFacade instance;

    private CommentFacade() {
    }

    public static CommentFacade getCommentFacade(EntityManagerFactory _emf) {
        if (instance == null) {
            emf = _emf;
            instance = new CommentFacade();
        }
        return instance;
    }

    public List<CommentDTO> getAllComments() {

        EntityManager em = emf.createEntityManager();
        List<Comment> CommentList = em.createQuery("SELECT c FROM Comment c", Comment.class).getResultList();

        return new CommentsDTO(CommentList).getAll();

    }

    public CommentDTO getComment(int id) throws NotFoundException {
        EntityManager em = emf.createEntityManager();
        try {
            Comment comment = em.find(Comment.class, id);
            if (comment == null) {
                throw new NotFoundException(String.format("Comment with id: (%d) not found", id));
            } else {
                return new CommentDTO(comment);
            }
        } finally {
            em.close();
        }
    }
    
    public Comment addNewComment(Comment newComment) throws AuthenticationException {

        if (newComment.getComment().isEmpty()) {
            throw new AuthenticationException("Comment must not be empty");
        }
        EntityManager em = emf.createEntityManager();

        Comment comment = new Comment(newComment.getComment());

        try {
            em.getTransaction().begin();
            em.persist(comment);
            em.getTransaction().commit();

        } catch (RollbackException e) {
            throw new AuthenticationException("Comment already exist.");

        } catch (Exception e) {
            throw new AuthenticationException("Something went wrong. Server may be unavailable at the moment");
        } finally {
            em.close();
        }
        return comment;

    }
 
    public CommentDTO editComment(CommentDTO c) throws NotFoundException {
        EntityManager em = emf.createEntityManager();
        try {
            em.getTransaction().begin();
            Comment comment = em.find(Comment.class, c.getId());
            if (comment == null) {
                throw new NotFoundException(String.format("Comment with that id: (%d) not found", c.getId()));
            } else {
                comment.setComment(c.getComment());
            }
            em.getTransaction().commit();
            return new CommentDTO(comment);
        } finally {
            em.close();
        }
    }
    
    public CommentDTO deleteComment(int id) throws NotFoundException {
        EntityManager em = emf.createEntityManager();;
        Comment comment = em.find(Comment.class, id);
        if (comment == null) {
            throw new NotFoundException(String.format("Comment with id: (%d) not found", id));
        } else {
            try {
                em.getTransaction().begin();
                em.remove(comment);
                em.getTransaction().commit();
            } finally {
                em.close();
            }
            return new CommentDTO(comment);
        }
    }

}
