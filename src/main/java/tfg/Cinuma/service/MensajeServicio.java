/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package tfg.Cinuma.service;

import java.util.List;
import tfg.Cinuma.Modelo.Comentario;
import tfg.Cinuma.Modelo.Mensaje;

/**
 *
 * @author jsnie
 */
public interface MensajeServicio {
    List<Mensaje> findAll();
    
    List<Mensaje> findAll(String receptorId);
    
    Mensaje saveOrUpdateMensaje(Mensaje mensaje);
    
    void deleteMensajeByMensajeId(String mensajeId);
}
