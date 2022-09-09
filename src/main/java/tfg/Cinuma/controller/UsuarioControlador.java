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
import tfg.Cinuma.Modelo.Autenticacion;
import tfg.Cinuma.Modelo.Elemento;
import tfg.Cinuma.Modelo.ListaPersonal;
import tfg.Cinuma.Modelo.Perfil;
import tfg.Cinuma.Modelo.Usuario;
import tfg.Cinuma.dto.AutenticacionDTO;
import tfg.Cinuma.dto.ListaIDUsuariosDTO;
import tfg.Cinuma.dto.UsuarioDTO;
import tfg.Cinuma.service.AutenticacionServicio;
import tfg.Cinuma.service.ListaPersonalServicio;
import tfg.Cinuma.service.PerfilServicio;
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
    @Autowired
    private AutenticacionServicio autenticacionServicio;
    @Autowired
    private PerfilServicio perfilServicio;
    @Autowired
    private ListaPersonalServicio listaPersonalServicio;

    @GetMapping(value = "/")
    public List<UsuarioDTO> obtenerTodosLosUsuarios() {
        return ObjectMapperUtils.mapAll(usuarioServicio.findAll(), UsuarioDTO.class);
    }
    
    @GetMapping(value = "/byUsername/{username}")
    public UsuarioDTO obtenerUsuarioPorUsername(@PathVariable("username") String username) {
        return ObjectMapperUtils.map(usuarioServicio.findByUsername(username), UsuarioDTO.class);
    }
    
    @GetMapping(value = "/byID/{userId}")
    public UsuarioDTO obtenerUsuarioPorIdUsuario(@PathVariable("userId") String userId) {
        return ObjectMapperUtils.map(usuarioServicio.findByUserId(userId), UsuarioDTO.class);
    }
    
    @PostMapping(value = "/listaUsuarios")
    public Usuario[] obtenerUsuariosDeGrupo(@RequestBody ListaIDUsuariosDTO idUsuariosDTO) {
        String[] listaIDUsuarios = idUsuariosDTO.getIdUsuarios();
        Usuario[] listaUsuarios = new Usuario[listaIDUsuarios.length];
        int i = 0;
        for (String idUsuario : listaIDUsuarios) {
            listaUsuarios[i] = usuarioServicio.findByUserId(idUsuario);
            i++;
        }
        return listaUsuarios;
    }

    @PostMapping(value = "/addUsuarioComun")
    public ResponseEntity<?> agregarUsuario(@RequestBody UsuarioDTO usuarioDTO) {
        Autenticacion authExistente = autenticacionServicio.findByUsuario(usuarioDTO.getUsername());
        if(authExistente == null){
            Autenticacion auth = new Autenticacion(null,usuarioDTO.getUsername(),usuarioDTO.getAutenticacion().getClave());
            Autenticacion newAuth = autenticacionServicio.saveOrUpdateAutenticacion(ObjectMapperUtils.map(auth, Autenticacion.class));
            ListaPersonal listaP = new ListaPersonal();
            ListaPersonal newListaP = listaPersonalServicio.saveOrUpdateListaPersonal(ObjectMapperUtils.map(listaP, ListaPersonal.class));
            Perfil perfil = new Perfil(null,false,newListaP.getListaPersonalId());
            Perfil newPerfil = perfilServicio.saveOrUpdatePerfil(ObjectMapperUtils.map(perfil, Perfil.class));            
            Usuario usuario = new Usuario(null,usuarioDTO.getUsername(),usuarioDTO.getEmail(),
                    usuarioDTO.getPhone(),2,newPerfil.getPerfilId(),newAuth);
            Usuario newUsuario = usuarioServicio.saveOrUpdateUsuario(ObjectMapperUtils.map(usuario, Usuario.class));
            return new ResponseEntity(newUsuario, HttpStatus.OK);
        }
        return new ResponseEntity("Usuario no existente", HttpStatus.BAD_REQUEST);
    }

    @DeleteMapping(value = "/delete/{username}")
    public ResponseEntity<?> deleteStudentByStudentNumber(@PathVariable String username) {
        usuarioServicio.deleteUsuarioByUsername(usuarioServicio.findByUsername(username).getUsername());
        return new ResponseEntity("Usuario borrado exitosamente", HttpStatus.OK);
    }
}
