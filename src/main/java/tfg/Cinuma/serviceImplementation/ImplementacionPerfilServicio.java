/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package tfg.Cinuma.serviceImplementation;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import tfg.Cinuma.Modelo.Perfil;
import tfg.Cinuma.repository.PerfilRepository;
import tfg.Cinuma.repository.UsuarioRepositorio;
import tfg.Cinuma.service.PerfilServicio;

/**
 *
 * @author jsnie
 */
@Service
public class ImplementacionPerfilServicio implements PerfilServicio{

    @Autowired
    private PerfilRepository perfilRepository;
    
    @Override
    public List<Perfil> findAll() {
        return perfilRepository.findAll();
    }

    @Override
    public Perfil saveOrUpdatePerfil(Perfil perfil) {
        return perfilRepository.save(perfil);
    }
    
    @Override
    public Perfil findByPerfilId(String username) {
        return perfilRepository.findByPerfilId(username);
    }

    @Override
    public void deletePerfilByPerfilId(String perfilId) {
        perfilRepository.deletePerfilByPerfilId(perfilId);
    }
    
}
