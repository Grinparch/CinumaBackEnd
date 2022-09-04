/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package tfg.Cinuma.serviceImplementation;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import tfg.Cinuma.Modelo.Elemento;
import tfg.Cinuma.repository.ElementoRepository;
import tfg.Cinuma.repository.GrupoRepository;
import tfg.Cinuma.service.ElementoServicio;

/**
 *
 * @author jsnie
 */
@Service
public class ImplementacionElementoService implements ElementoServicio{
    
    @Autowired
    private ElementoRepository elementoRepository;

    @Override
    public List<Elemento> findAll() {
        return elementoRepository.findAll();
    }

    @Override
    public Elemento saveOrUpdateElemento(Elemento elemento) {
        return elementoRepository.save(elemento);
    }
    
    @Override
    public void deleteElementoByElementoId(String elementoId) {
        elementoRepository.deleteElementoByElementoId(elementoId);
    }

    @Override
    public Elemento findByElementoId(String elementoId) {
        return elementoRepository.findByElementoId(elementoId);
    }
    
}
