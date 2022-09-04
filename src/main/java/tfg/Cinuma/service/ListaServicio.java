/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package tfg.Cinuma.service;

import java.util.List;
import tfg.Cinuma.Modelo.Lista;
import tfg.Cinuma.Modelo.Perfil;

/**
 *
 * @author jsnie
 */
public interface ListaServicio {
    List<Lista> findAll();
    
    Lista findByListaId(String listaId);
    
    void deleteListaByListaId(String listaId);
    
    Lista saveOrUpdateLista(Lista lista);
}
