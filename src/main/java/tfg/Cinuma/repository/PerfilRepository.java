/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package tfg.Cinuma.repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import tfg.Cinuma.Modelo.Perfil;

/**
 *
 * @author jsnie
 */
public interface PerfilRepository extends MongoRepository<Perfil, String>{
    
    Perfil findByPerfilId(String perfilId);
    
    void deletePerfilByPerfilId(String perfilId);

}
