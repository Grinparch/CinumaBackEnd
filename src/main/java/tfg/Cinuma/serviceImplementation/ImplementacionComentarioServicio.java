/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package tfg.Cinuma.serviceImplementation;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import tfg.Cinuma.Modelo.Comentario;
import tfg.Cinuma.repository.ArticuloRepository;
import tfg.Cinuma.repository.ComentarioRepository;
import tfg.Cinuma.service.ComentarioServicio;

/**
 *
 * @author jsnie
 */
@Service
public class ImplementacionComentarioServicio implements ComentarioServicio{
    
    @Autowired
    private ComentarioRepository comentarioRepository;

    @Override
    public List<Comentario> findAll() {
        return comentarioRepository.findAll();
    }

    @Override
    public Comentario saveOrUpdateComentario(Comentario comentario) {
        return comentarioRepository.insert(comentario);
    }

    @Override
    public List<Comentario> findAll(String articuloId) {
        return comentarioRepository.findAll(articuloId);
    }

    @Override
    public void deleteComentarioByArticuloId(String articuloId) {
        comentarioRepository.deleteComentarioByArticuloId(articuloId);
    }
    
}
