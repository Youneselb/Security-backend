/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dto;


import entities.Klasse;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Yones
 */
public class KlasserDTO {
    
    List<KlasseDTO> all = new ArrayList();
    
    public KlasserDTO(List<Klasse> klasseEntities) {
        
        klasseEntities.forEach((k) -> {
        all.add(new KlasseDTO(k));
    });
        
  }
     public List<KlasseDTO> getAll() {
    return all;
}

}