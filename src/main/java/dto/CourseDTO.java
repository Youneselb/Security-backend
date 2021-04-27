/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dto;

import entities.Course;
import javax.persistence.EntityManagerFactory;



/**
 *
 * @author Yones
 */
public class CourseDTO {
 
    private String courseName;
    private String courseDescription;
    private long id;

     private static EntityManagerFactory emf;
    //se constructor
    public CourseDTO(Course course) {
        this.courseName = course.getCourseName();
        this.courseDescription = course.getCourseDescription();
        this.id = course.getId();
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
    
    
    
    
}
