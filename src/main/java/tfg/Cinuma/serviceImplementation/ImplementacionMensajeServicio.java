/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package tfg.Cinuma.serviceImplementation;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import tfg.Cinuma.Modelo.Mensaje;
import tfg.Cinuma.repository.ComentarioRepository;
import tfg.Cinuma.repository.MensajeRepository;
import tfg.Cinuma.service.MensajeServicio;

/**
 *
 * @author jsnie
 */
@Service
public class ImplementacionMensajeServicio implements MensajeServicio{
    
    @Autowired
    private MensajeRepository mensajeRepository;

    @Override
    public List<Mensaje> findAll() {
         return mensajeRepository.findAll();
    }

    @Override
    public List<Mensaje> findAll(String receptorId) {
        return mensajeRepository.findAll(receptorId);
    }

    @Override
    public Mensaje saveOrUpdateMensaje(Mensaje mensaje) {
        return mensajeRepository.insert(mensaje);
    }

    @Override
    public void deleteMensajeByMensajeId(String mensajeId) {
        mensajeRepository.deleteMensajeByMensajeId(mensajeId);
    }
    
}
