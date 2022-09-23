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
import tfg.Cinuma.Modelo.Mensaje;
import tfg.Cinuma.dto.MensajeDTO;
import tfg.Cinuma.dto.RespuestaOKDTO;
import tfg.Cinuma.service.MensajeServicio;
import tfg.Cinuma.service.UsuarioServicio;
import tfg.Cinuma.util.ObjectMapperUtils;

/**
 *
 * @author jsnie
 */
@RestController
@RequestMapping("/mensaje")
public class MensajeControlador {
    
    @Autowired
    private MensajeServicio mensajeServicio;
    @Autowired
    private UsuarioServicio usuarioServicio;
    
    
    @CrossOrigin(origins = "http://localhost:8100")
    @GetMapping(value = "/")
    public List<MensajeDTO> obtenerTodosLosMensajes() {
        return ObjectMapperUtils.mapAll(mensajeServicio.findAll(), MensajeDTO.class);
    }
    
    @CrossOrigin(origins = "http://localhost:8100")
    @GetMapping(value = "/allMensajes/{receptorId}")
    public List<MensajeDTO> obtenerTodosLosMensajesDeReceptor(@PathVariable("receptorId") String receptorId) {
        return ObjectMapperUtils.mapAll(mensajeServicio.findAll(receptorId), MensajeDTO.class);
    }
    
    @CrossOrigin(origins = "http://localhost:8100")
    @PostMapping(value = "/add")
    public ResponseEntity<?> agregarMensaje(@RequestBody MensajeDTO mensajeDTO) {
        String receptorId = usuarioServicio.findByUsername(mensajeDTO.getReceptor()).getUserId();
        mensajeDTO.setReceptorId(receptorId);
        return new ResponseEntity(mensajeServicio.saveOrUpdateMensaje(ObjectMapperUtils.map(mensajeDTO, Mensaje.class)), HttpStatus.OK);
    }
    
    @CrossOrigin(origins = "http://localhost:8100")
    @DeleteMapping(value = "/delete/{mensajeId}")
    public ResponseEntity<?> deleteMensajeByMensajeId(@PathVariable String mensajeId) {
        mensajeServicio.deleteMensajeByMensajeId(mensajeId);
        return new ResponseEntity(new RespuestaOKDTO("Mensaje borrado exitosamente"), HttpStatus.OK);
    }
}
