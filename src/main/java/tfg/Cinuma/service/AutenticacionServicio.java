/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package tfg.Cinuma.service;

import java.util.List;
import tfg.Cinuma.Modelo.Autenticacion;

/**
 *
 * @author jsnie
 */
public interface AutenticacionServicio {
    List<Autenticacion> findAll();
    
    Autenticacion findByUsuario(String usuario);
    
    Autenticacion saveOrUpdateAutenticacion(Autenticacion autenticacion);
}
