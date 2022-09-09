/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package tfg.Cinuma.repository;

import java.util.List;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;
import tfg.Cinuma.Modelo.Comentario;
import tfg.Cinuma.Modelo.Mensaje;

/**
 *
 * @author jsnie
 */
public interface MensajeRepository extends MongoRepository<Mensaje, String>{
    @Query(value="{receptorId:'?0'}", fields="{'mensajeId' : 1, "
            + "'autorId' : 1, 'autor' : 1, 'receptor' : 1, 'contenido' : 1"
            + ", 'fechaDeCreacion' : 1}")
    List<Mensaje> findAll(String receptorId);
    
    void deleteMensajeByMensajeId(String mensajeId);
}
