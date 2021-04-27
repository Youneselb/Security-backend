/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dto;

import entities.User;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Yones
 */
public class UsersDTO {
           
    List<UserDTO> all = new ArrayList();
        
        public UsersDTO(List<User> userEntities) {
  //For hvert element af element i listen userEntitties,  tilføjer vi en user
  //og returerner listen all i en liste(userDTO)
            userEntities.forEach((p) -> {
            all.add(new UserDTO(p));
        });
}

    public List<UserDTO> getAll() {
        return all;
    }
}