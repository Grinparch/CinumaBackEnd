/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package tfg.Cinuma.repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import tfg.Cinuma.Modelo.Articulo;
import tfg.Cinuma.Modelo.Autenticacion;

/**
 *
 * @author jsnie
 */
public interface ArticuloRepository extends MongoRepository<Articulo, String>{
    
}