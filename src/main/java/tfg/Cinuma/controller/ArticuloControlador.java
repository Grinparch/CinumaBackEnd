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
import tfg.Cinuma.Modelo.Articulo;
import tfg.Cinuma.Modelo.Autenticacion;
import tfg.Cinuma.dto.ArticuloDTO;
import tfg.Cinuma.dto.AutenticacionDTO;
import tfg.Cinuma.service.ArticuloServicio;
import tfg.Cinuma.service.AutenticacionServicio;
import tfg.Cinuma.util.ObjectMapperUtils;

/**
 *
 * @author jsnie
 */
@RestController
@RequestMapping("/articulo")
public class ArticuloControlador {
    
    @Autowired
    private ArticuloServicio articuloServicio;
    
    
    @CrossOrigin(origins = "http://localhost:8100")
    @GetMapping(value = "/")
    public List<ArticuloDTO> obtenerTodosLosArticulos() {
        return ObjectMapperUtils.mapAll(articuloServicio.findAll(), ArticuloDTO.class);
    }
    
    @CrossOrigin(origins = "http://localhost:8100")
    @PostMapping(value = "/add")
    public ResponseEntity<?> agregarAutenticacion(@RequestBody ArticuloDTO articuloDTO) {
        articuloServicio.saveOrUpdateArticulo(ObjectMapperUtils.map(articuloDTO, Articulo.class));
        return new ResponseEntity("Articulo agregada exitosamenta", HttpStatus.OK);
    }
}
