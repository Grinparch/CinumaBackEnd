/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package tfg.Cinuma.repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import tfg.Cinuma.Modelo.Lista;

/**
 *
 * @author jsnie
 */
public interface ListaRepository extends MongoRepository<Lista, String>{
    
    void deleteListaByListaId(String listaId);
    
    Lista findByListaId(String listaId);
}
