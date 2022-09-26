/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package tfg.Cinuma.controller;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import tfg.Cinuma.Modelo.Autenticacion;
import tfg.Cinuma.Modelo.Usuario;
import tfg.Cinuma.dto.AutenticacionDTO;
import tfg.Cinuma.dto.RespuestaOKDTO;
import tfg.Cinuma.service.AutenticacionServicio;
import tfg.Cinuma.service.UsuarioServicio;
import tfg.Cinuma.util.ObjectMapperUtils;

/**
 *
 * @author jsnie
 */
@RestController
@RequestMapping("/autenticacion")
public class AutenticacionControlador {
    
    @Autowired
    private AutenticacionServicio autenticacionServicio;
    @Autowired
    private UsuarioServicio usuarioServicio;
    
    
    @GetMapping(value = "/")
    public List<AutenticacionDTO> obtenerTodasLasAutenticaciones() {
        return ObjectMapperUtils.mapAll(autenticacionServicio.findAll(), AutenticacionDTO.class);
    }
    
    @PostMapping(value = "/login")
    public ResponseEntity<?> verificarUsuarioYClaveCorrectas(@RequestBody AutenticacionDTO autenticacionDTO) {
        try{
            Autenticacion authExistente = ObjectMapperUtils.map(autenticacionServicio.findByUsuario(autenticacionDTO.getUsuario()), Autenticacion.class);
            if(authExistente.getClave().equals(autenticacionDTO.getClave())){
                Usuario usuarioExistente = ObjectMapperUtils.map(usuarioServicio.findByUsername(autenticacionDTO.getUsuario()), Usuario.class);
                usuarioExistente.getAutenticacion().setClave(null);
                return new ResponseEntity(usuarioExistente, HttpStatus.OK);
            }else{
                 return new ResponseEntity(new RespuestaOKDTO("Usuario y/o contraseña no validos"), HttpStatus.OK);
            }
        }catch (Exception  e){
             return new ResponseEntity(new RespuestaOKDTO("Usuario y/o contraseña no validos"), HttpStatus.OK);
        }
       
    }
    
    @PostMapping(value = "/add")
    public ResponseEntity<?> agregarAutenticacion(@RequestBody AutenticacionDTO autenticacionDTO) {
        Autenticacion authExistente = autenticacionServicio.findByUsuario(autenticacionDTO.getUsuario());
        if(authExistente == null){
            Autenticacion newauth = autenticacionServicio.saveOrUpdateAutenticacion(ObjectMapperUtils.map(autenticacionDTO, Autenticacion.class));
            return new ResponseEntity(newauth, HttpStatus.OK);
        }else{
            return new ResponseEntity("Usuario ya existe", HttpStatus.OK);
        }
    }
}
