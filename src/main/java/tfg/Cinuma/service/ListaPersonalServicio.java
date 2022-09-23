/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package tfg.Cinuma.service;

import java.util.List;
import tfg.Cinuma.Modelo.ListaPersonal;
import tfg.Cinuma.Modelo.Perfil;

/**
 *
 * @author jsnie
 */
public interface ListaPersonalServicio {
    List<ListaPersonal> findAll();
    
    ListaPersonal findByListaPersonalId(String listaPersonalId);
    
    ListaPersonal saveOrUpdateListaPersonal(ListaPersonal listaPersonal);
    
    void deleteListaPersonalByListaPersonalId(String listaPersonalId);
}
