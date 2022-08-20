/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package tfg.Cinuma.controller;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import tfg.Cinuma.Modelo.Usuario;
import tfg.Cinuma.dto.UsuarioDTO;
import tfg.Cinuma.service.UsuarioServicio;
import tfg.Cinuma.util.ObjectMapperUtils;

/**
 *
 * @author jsnie
 */
@RestController
@RequestMapping("/usuarios")
public class UsuarioControlador {
    
    @Autowired
    private UsuarioServicio usuarioServicio;

    @CrossOrigin(origins = "http://localhost:8100")
    @GetMapping(value = "/")
    public List<UsuarioDTO> obtenerTodosLosUsuarios() {
        return ObjectMapperUtils.mapAll(usuarioServicio.findAll(), UsuarioDTO.class);
    }
    
    @CrossOrigin(origins = "http://localhost:8100")
    @GetMapping(value = "/byUsername/{username}")
    public UsuarioDTO obtenerUsuarioPorUsername(@PathVariable("username") String username) {
        return ObjectMapperUtils.map(usuarioServicio.findByUsername(username), UsuarioDTO.class);
    }

    @CrossOrigin(origins = "http://localhost:8100")
    @PostMapping(value = "/add")
    public ResponseEntity<?> agregarUsuario(@RequestBody UsuarioDTO usuarioDTO) {
        Usuario newUsuario = usuarioServicio.saveOrUpdateUsuario(ObjectMapperUtils.map(usuarioDTO, Usuario.class));
        return new ResponseEntity(newUsuario, HttpStatus.OK);
    }

    @CrossOrigin(origins = "http://localhost:8100")
    @DeleteMapping(value = "/delete/{username}")
    public ResponseEntity<?> deleteStudentByStudentNumber(@PathVariable String username) {
        usuarioServicio.deleteUsuarioByUsername(usuarioServicio.findByUsername(username).getUsername());
        return new ResponseEntity("Usuario borrado exitosamente", HttpStatus.OK);
    }
}
