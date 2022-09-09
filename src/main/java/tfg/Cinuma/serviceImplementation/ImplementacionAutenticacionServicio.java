/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package tfg.Cinuma.serviceImplementation;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import tfg.Cinuma.Modelo.Autenticacion;
import tfg.Cinuma.repository.AutenticacionRepository;
import tfg.Cinuma.repository.ChatRepository;
import tfg.Cinuma.service.AutenticacionServicio;

/**
 *
 * @author jsnie
 */
@Service
public class ImplementacionAutenticacionServicio implements AutenticacionServicio{
    
    @Autowired
    private AutenticacionRepository autenticacionRepository;

    @Override
    public List<Autenticacion> findAll() {
        return autenticacionRepository.findAll();
    }

    @Override
    public Autenticacion saveOrUpdateAutenticacion(Autenticacion autenticacion) {
        return autenticacionRepository.save(autenticacion);
    }

    @Override
    public Autenticacion findByUsuario(String usuario) {
        return autenticacionRepository.findByUsuario(usuario);
    }
    
}
