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
import tfg.Cinuma.Modelo.Elemento;
import tfg.Cinuma.Modelo.Grupo;
import tfg.Cinuma.dto.ElementoDTO;
import tfg.Cinuma.dto.GrupoDTO;
import tfg.Cinuma.service.ElementoServicio;
import tfg.Cinuma.service.GrupoServicio;
import tfg.Cinuma.util.ObjectMapperUtils;

/**
 *
 * @author jsnie
 */
@RestController
@RequestMapping("/elemento")
public class ElementoControlador {
    
    @Autowired
    private ElementoServicio elementoServicio;
    
    @CrossOrigin(origins = "http://localhost:8100")
    @GetMapping(value = "/")
    public List<ElementoDTO> obtenerTodosLosElementos() {
        return ObjectMapperUtils.mapAll(elementoServicio.findAll(), ElementoDTO.class);
    }
    
    @CrossOrigin(origins = "http://localhost:8100")
    @PostMapping(value = "/add")
    public ResponseEntity<?> agregarElemento(@RequestBody ElementoDTO elementoDTO) {
        elementoServicio.saveOrUpdateElemento(ObjectMapperUtils.map(elementoDTO, Elemento.class));
        return new ResponseEntity("Elemento agregado exitosamente", HttpStatus.OK);
    }
}
