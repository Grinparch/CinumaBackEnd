/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package tfg.Cinuma.repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import tfg.Cinuma.Modelo.Autenticacion;
import tfg.Cinuma.Modelo.ListaPersonal;

/**
 *
 * @author jsnie
 */
public interface AutenticacionRepository extends MongoRepository<Autenticacion, String>{
    Autenticacion findByUsuario(String usuario);
    
    void deleteAutenticacionByAutenticacionId(String autenticacionId);
}
