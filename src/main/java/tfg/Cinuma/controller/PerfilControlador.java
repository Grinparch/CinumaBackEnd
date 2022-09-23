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
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import tfg.Cinuma.Modelo.Perfil;
import tfg.Cinuma.dto.PerfilDTO;
import tfg.Cinuma.service.PerfilServicio;
import tfg.Cinuma.util.ObjectMapperUtils;

/**
 *
 * @author jsnie
 */
@RestController
@RequestMapping("/perfil")
public class PerfilControlador {
    
    @Autowired
    private PerfilServicio perfilServicio;
    
    @CrossOrigin(origins = "http://localhost:8100")
    @GetMapping(value = "/")
    public List<PerfilDTO> obtenerTodosLosPerfiles() {
        return ObjectMapperUtils.mapAll(perfilServicio.findAll(), PerfilDTO.class);
    }
    
    @CrossOrigin(origins = "http://localhost:8100")
    @PostMapping(value = "/add")
    public ResponseEntity<?> agregarPerfiles(@RequestBody PerfilDTO perfilDTO) {
        return new ResponseEntity(perfilServicio.saveOrUpdatePerfil(ObjectMapperUtils.map(perfilDTO, Perfil.class)), HttpStatus.OK);
    }
    
    @CrossOrigin(origins = "http://localhost:8100")
    @PutMapping(value = "/update")
    public ResponseEntity<?> actualizarPerfiles(@RequestBody PerfilDTO perfilDTO) {
        return new ResponseEntity(perfilServicio.saveOrUpdatePerfil(ObjectMapperUtils.map(perfilDTO, Perfil.class)), HttpStatus.OK);
    }
    
    @GetMapping(value = "/byPerfilId/{perfilId}")
    public PerfilDTO obtenerPerfilPorPerfilId(@PathVariable("perfilId") String perfilId) {
        return ObjectMapperUtils.map(perfilServicio.findByPerfilId(perfilId), PerfilDTO.class);
    }
}
