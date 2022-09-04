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
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import tfg.Cinuma.Modelo.ListaPersonal;
import tfg.Cinuma.Modelo.Perfil;
import tfg.Cinuma.dto.ListaPersonalDTO;
import tfg.Cinuma.dto.PerfilDTO;
import tfg.Cinuma.service.ListaPersonalServicio;
import tfg.Cinuma.service.PerfilServicio;
import tfg.Cinuma.util.ObjectMapperUtils;

/**
 *
 * @author jsnie
 */
@RestController
@RequestMapping("/listaPersonal")
public class ListaPersonalControlador {
    
    @Autowired
    private ListaPersonalServicio listaPersonalServicio;
    
    @CrossOrigin(origins = "http://localhost:8100")
    @GetMapping(value = "/")
    public List<ListaPersonalDTO> obtenerTodasLasListasPersonales() {
        return ObjectMapperUtils.mapAll(listaPersonalServicio.findAll(), ListaPersonalDTO.class);
    }
    
    @CrossOrigin(origins = "http://localhost:8100")
    @PostMapping(value = "/add")
    public ResponseEntity<?> agregarListaPersonal(@RequestBody ListaPersonalDTO listaPersonalDTO) {
        listaPersonalServicio.saveOrUpdateListaPersonal(ObjectMapperUtils.map(listaPersonalDTO, ListaPersonal.class));
        return new ResponseEntity("Lista Personal agregada exitosamente", HttpStatus.OK);
    }
    
    @GetMapping(value = "/{listaPersonalId}")
    public ListaPersonalDTO obtenerListaPersonalPorId(@PathVariable("listaPersonalId") String listaPersonalId) {
        return ObjectMapperUtils.map(listaPersonalServicio.findByListaPersonalId(listaPersonalId), ListaPersonalDTO.class);
    }
    
}
