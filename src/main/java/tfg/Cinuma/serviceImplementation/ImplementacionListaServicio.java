/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package tfg.Cinuma.serviceImplementation;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import tfg.Cinuma.Modelo.Lista;
import tfg.Cinuma.repository.ListaRepository;
import tfg.Cinuma.service.ListaServicio;

/**
 *
 * @author jsnie
 */
@Service
public class ImplementacionListaServicio implements ListaServicio{
    
    @Autowired
    private ListaRepository listaRepository;

    @Override
    public List<Lista> findAll() {
        return listaRepository.findAll();
    }

    @Override
    public Lista saveOrUpdateLista(Lista lista) {
        return listaRepository.save(lista);
    }

    @Override
    public void deleteListaByListaId(String listaId) {
        listaRepository.deleteListaByListaId(listaId);
    }

    @Override
    public Lista findByListaId(String listaId) {
        return listaRepository.findByListaId(listaId);
    }
    
}
