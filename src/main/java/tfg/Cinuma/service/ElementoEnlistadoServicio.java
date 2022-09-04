/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package tfg.Cinuma.service;

import java.util.List;
import tfg.Cinuma.Modelo.Elemento;
import tfg.Cinuma.Modelo.ElementoEnlistado;

/**
 *
 * @author jsnie
 */
public interface ElementoEnlistadoServicio {
    
    List<ElementoEnlistado> findAll();
    
    ElementoEnlistado saveOrUpdateElementoEnlistado(ElementoEnlistado elementoEnlistadoId);
    
    ElementoEnlistado findByListaPersonalId(String listaPersonalId);
    
    ElementoEnlistado findByElementoEnlistadoId(String elementoEnlistadoId);
    
    void deleteElementoEnlistadoByElementoEnlistadoId(String elementoEnlistadoId);
}
