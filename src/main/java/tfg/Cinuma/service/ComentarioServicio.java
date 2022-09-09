/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package tfg.Cinuma.service;

import java.util.List;
import tfg.Cinuma.Modelo.Comentario;

/**
 *
 * @author jsnie
 */
public interface ComentarioServicio {
    List<Comentario> findAll();
    
    List<Comentario> findAll(String articuloId);
    
    Comentario saveOrUpdateComentario(Comentario comentario);
    
    void deleteComentarioByArticuloId(String articuloId);
}
