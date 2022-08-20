/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package tfg.Cinuma.serviceImplementation;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import tfg.Cinuma.Modelo.Usuario;
import tfg.Cinuma.repository.UsuarioRepositorio;
import tfg.Cinuma.service.UsuarioServicio;

/**
 *
 * @author jsnie
 */
@Service
public class ImplementacionUsuarioServicio implements UsuarioServicio{
    
    @Autowired
    private UsuarioRepositorio usuarioRepositorio;

    @Override
    public List<Usuario> findAll() {
        return usuarioRepositorio.findAll();
    }

    @Override
    public Usuario findByUsername(String username) {
        return usuarioRepositorio.findByUsername(username);
    }

    @Override
    public Usuario saveOrUpdateUsuario(Usuario usuario) {
        return usuarioRepositorio.save(usuario);
    }

    @Override
    public void deleteUsuarioByUsername(String username) {
        usuarioRepositorio.deleteUsuarioByUsername(username);
    }
    
}
