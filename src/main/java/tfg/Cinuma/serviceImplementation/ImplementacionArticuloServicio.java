/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package tfg.Cinuma.serviceImplementation;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import tfg.Cinuma.Modelo.Articulo;
import tfg.Cinuma.repository.ArticuloRepository;
import tfg.Cinuma.repository.AutenticacionRepository;
import tfg.Cinuma.service.ArticuloServicio;

/**
 *
 * @author jsnie
 */
@Service
public class ImplementacionArticuloServicio implements ArticuloServicio{
    
    @Autowired
    private ArticuloRepository articuloRepository;

    @Override
    public List<Articulo> findAll() {
        return articuloRepository.findAll();
    }

    @Override
    public Articulo saveOrUpdateArticulo(Articulo articulo) {
        return articuloRepository.save(articulo);
    }

    @Override
    public void deleteArticuloByArticuloId(String articuloId) {
        articuloRepository.deleteArticuloByArticuloId(articuloId);
    }

    @Override
    public Articulo findByArticuloId(String articuloId) {
        return articuloRepository.findByArticuloId(articuloId);
    }
    
}
