/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package tfg.Cinuma.serviceImplementation;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import tfg.Cinuma.Modelo.ListaPersonal;
import tfg.Cinuma.repository.ListaPersonalRepository;
import tfg.Cinuma.service.ListaPersonalServicio;

/**
 *
 * @author jsnie
 */
@Service
public class ImplementacionListaPersonalServicio implements ListaPersonalServicio{
    
    @Autowired
    private ListaPersonalRepository listaPersonalRepository;

    @Override
    public List<ListaPersonal> findAll() {
        return listaPersonalRepository.findAll();
    }

    @Override
    public ListaPersonal saveOrUpdateListaPersonal(ListaPersonal listaPersonal) {
        return listaPersonalRepository.save(listaPersonal);
    }
    
}
