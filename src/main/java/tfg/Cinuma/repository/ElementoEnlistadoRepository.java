/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package tfg.Cinuma.repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import tfg.Cinuma.Modelo.ElementoEnlistado;
import tfg.Cinuma.Modelo.Usuario;

/**
 *
 * @author jsnie
 */
public interface ElementoEnlistadoRepository  extends MongoRepository<ElementoEnlistado, String>{
    ElementoEnlistado findByListaPersonalId(String listaPersonalId);
    
    ElementoEnlistado findByElementoEnlistadoId(String elementoEnlistadoId);
    
    void deleteElementoEnlistadoByElementoEnlistadoId(String elementoEnlistadoId);
}
