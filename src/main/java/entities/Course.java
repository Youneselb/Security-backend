/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entities;

import java.io.Serializable;
import java.util.List;
import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;

/**
 *
 * @author Yones
 */
@Entity

@NamedQuery(name = "Course.deleteAllRows", query = "DELETE from Course")
@NamedQuery(name = "Course.findById", query = "SELECT c FROM Course c WHERE c.id = :id")
public class Course implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String courseName;
    private String courseDescription;
    

//NOTE: Mapped by skal være på "one" siden ("many" siden indeholder fremmednøglen og er dermed ejersiden)
    @OneToMany(mappedBy= "Course", cascade= CascadeType.PERSIST)
 private List<Klasse> Klasser;
    
    @OneToOne
    private Teacher teacher;

     public void addKlasse(Klasse klasse){
    this.Klasser.add(klasse);
    if (klasse != null){
    klasse.setCourse(this);
    }
    }
    
    
    
    public Course() {
    }

    public Course(String courseName, String courseDescription) {
        this.courseName = courseName;
        this.courseDescription = courseDescription;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getCourseName() {
        return courseName;
    }

    public void setCourseName(String courseName) {
        this.courseName = courseName;
    }

    public String getCourseDescription() {
        return courseDescription;
    }

    public void setCourseDescription(String courseDescription) {
        this.courseDescription = courseDescription;
    }

    public List<Klasse> getKlasser() {
        return Klasser;
    }

    public void setKlasser(List<Klasse> Klasser) {
        this.Klasser = Klasser;
    }

   
    
    
    
    
}
