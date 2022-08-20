/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package tfg.Cinuma.service;

import java.util.List;
import tfg.Cinuma.Modelo.Usuario;

/**
 *
 * @author jsnie
 */
public interface UsuarioServicio {
    
    List<Usuario> findAll();

    Usuario findByUsername(String username);

    Usuario saveOrUpdateUsuario(Usuario usuario);

    void deleteUsuarioByUsername(String username);
}
