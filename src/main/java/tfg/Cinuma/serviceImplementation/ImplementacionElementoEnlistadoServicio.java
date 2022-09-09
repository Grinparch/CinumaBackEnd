/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package tfg.Cinuma.serviceImplementation;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import tfg.Cinuma.Modelo.Elemento;
import tfg.Cinuma.Modelo.ElementoEnlistado;
import tfg.Cinuma.repository.ElementoEnlistadoRepository;
import tfg.Cinuma.repository.UsuarioRepositorio;
import tfg.Cinuma.service.ElementoEnlistadoServicio;

/**
 *
 * @author jsnie
 */
@Service
public class ImplementacionElementoEnlistadoServicio implements ElementoEnlistadoServicio{
    
    @Autowired
    private ElementoEnlistadoRepository elementoEnlistadoRepository;

    @Override
    public ElementoEnlistado findByListaPersonalId(String listaPersonalId) {
        return elementoEnlistadoRepository.findByListaPersonalId(listaPersonalId);
    }

    @Override
    public void deleteElementoEnlistadoByElementoEnlistadoId(String elementoEnlistadoId) {
        elementoEnlistadoRepository.deleteElementoEnlistadoByElementoEnlistadoId(elementoEnlistadoId);
    }

    @Override
    public List<ElementoEnlistado> findAll() {
        return elementoEnlistadoRepository.findAll();
    }

    @Override
    public ElementoEnlistado saveOrUpdateElementoEnlistado(ElementoEnlistado elementoEnlistadoId) {
        return elementoEnlistadoRepository.save(elementoEnlistadoId);
    }

    @Override
    public ElementoEnlistado findByElementoEnlistadoId(String elementoEnlistadoId) {
        return elementoEnlistadoRepository.findByElementoEnlistadoId(elementoEnlistadoId);
    }
    
}
