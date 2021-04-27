/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dto;

import entities.Klasse;

/**
 *
 * @author Yones
 */
public class KlasseDTO {
    
    private int semester;
    private int numberOfStudents;
    private long id;
    

    //se constructor
    public KlasseDTO(Klasse k) {
        this.semester = k.getSemester();
        this.numberOfStudents = k.getNumberOfStudents();
        this.id = k.getId();
        
        
    }

    public int getSemester() {
        return semester;
    }

    public void setSemester(int semester) {
        this.semester = semester;
    }

    public int getNumberOfStudents() {
        return numberOfStudents;
    }

    public void setNumberOfStudents(int numberOfStudents) {
        this.numberOfStudents = numberOfStudents;
    }

    
   
    
}
