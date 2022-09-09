/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package tfg.Cinuma.controller;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
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
import tfg.Cinuma.Modelo.Elemento;
import tfg.Cinuma.Modelo.Grupo;
import tfg.Cinuma.dto.ElementoDTO;
import tfg.Cinuma.dto.GrupoDTO;
import tfg.Cinuma.dto.ListaIDElementosDTO;
import tfg.Cinuma.service.ElementoServicio;
import tfg.Cinuma.service.GrupoServicio;
import tfg.Cinuma.service.ListaServicio;
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
    @Autowired
    private ListaServicio listaServicio;
    
    @CrossOrigin(origins = "http://localhost:8100")
    @GetMapping(value = "/")
    public List<ElementoDTO> obtenerTodosLosElementos() {
        return ObjectMapperUtils.mapAll(elementoServicio.findAll(), ElementoDTO.class);
    }
    
    @GetMapping(value = "/{elementoId}")
    public ElementoDTO obtenerElementoPorId(@PathVariable("elementoId") String elementoId) {
        return ObjectMapperUtils.map(elementoServicio.findByElementoId(elementoId), ElementoDTO.class);
    }
    
    @PostMapping(value = "/listaElementos")
    public Elemento[] obtenerUsuariosPorUsername(@RequestBody ListaIDElementosDTO idElementosDTO) {
        String[] listaIDElementos = idElementosDTO.getIdElementos();
        Elemento[] listaElementos = new Elemento[listaIDElementos.length];
        int i = 0;
        for (String idElemento : listaIDElementos) {
            listaElementos[i] = elementoServicio.findByElementoId(idElemento);
            i++;
        }
        return listaElementos;
    }
    
    @CrossOrigin(origins = "http://localhost:8100")
    @PostMapping(value = "/addPelicula")
    public ResponseEntity<?> agregarPelicula(@RequestBody ElementoDTO elementoDTO) {
        elementoServicio.saveOrUpdateElemento(ObjectMapperUtils.map(elementoDTO, Elemento.class));
        return new ResponseEntity("Pelicula agregada exitosamente", HttpStatus.OK);
    }
    
    @CrossOrigin(origins = "http://localhost:8100")
    @PostMapping(value = "/addSerie")
    public ResponseEntity<?> agregarSerie(@RequestBody ElementoDTO elementoDTO) {
        elementoServicio.saveOrUpdateElemento(ObjectMapperUtils.map(elementoDTO, Elemento.class));
        return new ResponseEntity("Serie agregada exitosamente", HttpStatus.OK);
    }
    
    @CrossOrigin(origins = "http://localhost:8100")
    @DeleteMapping(value = "/delete/{elementoId}")
    public ResponseEntity<?> deleteElementoByElementoId(@PathVariable String elementoId) {
        elementoServicio.deleteElementoByElementoId(elementoId);
        return new ResponseEntity("Elemento borrado exitosamente", HttpStatus.OK);
    }
    
    @CrossOrigin(origins = "http://localhost:8100")
    @PostMapping(value = "/editarPelicula")
    public ResponseEntity<?> editarPelicula(@RequestBody ElementoDTO elementoDTO) {
        System.out.println(elementoDTO.getEstrenoTaquilla());
        elementoServicio.saveOrUpdateElemento(ObjectMapperUtils.map(elementoDTO, Elemento.class));
        return new ResponseEntity("Pelicula Editada exitosamente", HttpStatus.OK);
    }
    
    @CrossOrigin(origins = "http://localhost:8100")
    @PostMapping(value = "/editarSerie")
    public ResponseEntity<?> editarSerie(@RequestBody ElementoDTO elementoDTO) {
        elementoServicio.saveOrUpdateElemento(ObjectMapperUtils.map(elementoDTO, Elemento.class));
        return new ResponseEntity("Serie Editada exitosamente", HttpStatus.OK);
    }
}
