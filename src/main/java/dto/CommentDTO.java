package dto;

import entities.Comment;

public class CommentDTO {
 
    private String comment;
    private int id;

    public CommentDTO() {
    }
    
    public CommentDTO(Comment comment) {
        this.comment = comment.getComment();
        this.id = comment.getId();
    }

    public String getComment() {
        return comment;
    }

    public void setComment(String comment) {
        this.comment = comment;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
    
}