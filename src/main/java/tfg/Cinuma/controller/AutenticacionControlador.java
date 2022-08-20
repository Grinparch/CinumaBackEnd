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
import tfg.Cinuma.Modelo.Autenticacion;
import tfg.Cinuma.Modelo.Chat;
import tfg.Cinuma.dto.AutenticacionDTO;
import tfg.Cinuma.dto.ChatDTO;
import tfg.Cinuma.service.AutenticacionServicio;
import tfg.Cinuma.service.ChatServicio;
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
    
    
    @CrossOrigin(origins = "http://localhost:8100")
    @GetMapping(value = "/")
    public List<AutenticacionDTO> obtenerTodasLasAutenticaciones() {
        return ObjectMapperUtils.mapAll(autenticacionServicio.findAll(), AutenticacionDTO.class);
    }
    
    @CrossOrigin(origins = "http://localhost:8100")
    @PostMapping(value = "/add")
    public ResponseEntity<?> agregarAutenticacion(@RequestBody AutenticacionDTO autenticacionDTO) {
        autenticacionServicio.saveOrUpdateAutenticacion(ObjectMapperUtils.map(autenticacionDTO, Autenticacion.class));
        return new ResponseEntity("Autenticacion agregada exitosamenta", HttpStatus.OK);
    }
}
