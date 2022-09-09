/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package tfg.Cinuma.repository;

import java.util.List;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;
import tfg.Cinuma.Modelo.Comentario;

/**
 *
 * @author jsnie
 */
public interface ComentarioRepository extends MongoRepository<Comentario, String>{
    @Query(value="{articuloId:'?0'}", fields="{'comentarioId' : 1, "
            + "'contenido' : 1, 'autorId' : 1, 'autor' : 1, 'fechaCreacion' : 1}")
    List<Comentario> findAll(String articuloId);
    
    void deleteComentarioByArticuloId(String articuloId);

}
