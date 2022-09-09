/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package tfg.Cinuma.service;

import java.util.List;
import tfg.Cinuma.Modelo.Articulo;
import tfg.Cinuma.Modelo.Autenticacion;

/**
 *
 * @author jsnie
 */
public interface ArticuloServicio {
    List<Articulo> findAll();
    
    Articulo findByArticuloId(String articuloId);
    
    Articulo saveOrUpdateArticulo(Articulo articulo);
    
    void deleteArticuloByArticuloId(String articuloId);
}
