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
import org.springframework.web.bind.annotation.PostMapping;
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
        perfilServicio.saveOrUpdatePerfil(ObjectMapperUtils.map(perfilDTO, Perfil.class));
        return new ResponseEntity("Perfil agregado exitosamente", HttpStatus.OK);
    }
}
