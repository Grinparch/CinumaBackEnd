/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package tfg.Cinuma.service;

import java.util.List;
import tfg.Cinuma.Modelo.Perfil;

/**
 *
 * @author jsnie
 */
public interface PerfilServicio {
    List<Perfil> findAll();
    
    Perfil saveOrUpdatePerfil(Perfil perfil);
}
