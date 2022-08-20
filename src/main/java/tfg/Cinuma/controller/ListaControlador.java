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
import tfg.Cinuma.Modelo.Lista;
import tfg.Cinuma.Modelo.ListaPersonal;
import tfg.Cinuma.dto.ListaDTO;
import tfg.Cinuma.dto.ListaPersonalDTO;
import tfg.Cinuma.service.ListaPersonalServicio;
import tfg.Cinuma.service.ListaServicio;
import tfg.Cinuma.util.ObjectMapperUtils;

/**
 *
 * @author jsnie
 */
@RestController
@RequestMapping("/lista")
public class ListaControlador {
    
    @Autowired
    private ListaServicio listaServicio;
    
    @CrossOrigin(origins = "http://localhost:8100")
    @GetMapping(value = "/")
    public List<ListaDTO> obtenerTodasLasListas() {
        return ObjectMapperUtils.mapAll(listaServicio.findAll(), ListaDTO.class);
    }
    
    @CrossOrigin(origins = "http://localhost:8100")
    @PostMapping(value = "/add")
    public ResponseEntity<?> agregarLista(@RequestBody ListaDTO listaDTO) {
        listaServicio.saveOrUpdateLista(ObjectMapperUtils.map(listaDTO, Lista.class));
        return new ResponseEntity("Lista agregada exitosamente", HttpStatus.OK);
    }
}
