/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package tfg.Cinuma.serviceImplementation;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import tfg.Cinuma.Modelo.Grupo;
import tfg.Cinuma.repository.GrupoRepository;
import tfg.Cinuma.repository.ListaPersonalRepository;
import tfg.Cinuma.service.GrupoServicio;

/**
 *
 * @author jsnie
 */
@Service
public class ImplementacionGrupoService implements GrupoServicio{
    
    @Autowired
    private GrupoRepository grupoRepository;

    @Override
    public List<Grupo> findAll() {
        return grupoRepository.findAll();
    }

    @Override
    public Grupo saveOrUpdateGrupo(Grupo grupo) {
        return grupoRepository.save(grupo);
    }
    
}
