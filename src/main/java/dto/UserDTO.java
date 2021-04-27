/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dto;

import entities.User;

/**
 *
 * 
 */
public class UserDTO {
    private String userName;
  

    public UserDTO(User user){
        this.userName = user.getUserName();
     
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }
    
    
}