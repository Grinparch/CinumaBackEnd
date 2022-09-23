/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package tfg.Cinuma.repository;

import java.util.List;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;
import tfg.Cinuma.Modelo.ElementoEnlistado;
import tfg.Cinuma.Modelo.Mensaje;
import tfg.Cinuma.Modelo.Usuario;

/**
 *
 * @author jsnie
 */
public interface ElementoEnlistadoRepository  extends MongoRepository<ElementoEnlistado, String>{
    ElementoEnlistado findByListaPersonalId(String listaPersonalId);
    
    ElementoEnlistado findByElementoEnlistadoId(String elementoEnlistadoId);
    
    void deleteElementoEnlistadoByElementoEnlistadoId(String elementoEnlistadoId);
    
    @Query(value="{elementoId:'?0'}", fields="{'elementoEnlistadoId' : 1, "
            + "'listaPersonalId' : 1, 'perfilId' : 1, 'puntuacionPersonal' : 1, 'opinion' : 1"
            + ", 'titulo' : 1, 'calificacionPromedio' : 1, 'duracion' : 1, 'genero' : 1, 'idioma' : 1,"
            + " 'director' : 1, 'actores' : 1, 'tipo' : 1, 'capitulos' : 1, 'estreno' : 1, 'estrenoTaquilla' : 1}")
    List<ElementoEnlistado> findAll(String elementoId);
}
