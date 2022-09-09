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
import tfg.Cinuma.Modelo.Articulo;
import tfg.Cinuma.Modelo.Autenticacion;
import tfg.Cinuma.Modelo.Comentario;
import tfg.Cinuma.dto.ArticuloDTO;
import tfg.Cinuma.dto.AutenticacionDTO;
import tfg.Cinuma.dto.ComentarioDTO;
import tfg.Cinuma.service.ArticuloServicio;
import tfg.Cinuma.service.AutenticacionServicio;
import tfg.Cinuma.service.ComentarioServicio;
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
    @Autowired
    private ComentarioServicio comentarioServicio;
    
    
    @CrossOrigin(origins = "http://localhost:8100")
    @GetMapping(value = "/")
    public List<ArticuloDTO> obtenerTodosLosArticulos() {
        return ObjectMapperUtils.mapAll(articuloServicio.findAll(), ArticuloDTO.class);
    }
    
    @CrossOrigin(origins = "http://localhost:8100")
    @GetMapping(value = "/allComentarios/{articuloId}")
    public List<ComentarioDTO> obtenerTodosLosComentariosDeArticulo(@PathVariable("articuloId") String articuloId) {
        return ObjectMapperUtils.mapAll(comentarioServicio.findAll(articuloId), ComentarioDTO.class);
    }
    
    @GetMapping(value = "/{articuloId}")
    public ArticuloDTO obtenerArticuloPorIdArticulo(@PathVariable("articuloId") String articuloId) {
        return ObjectMapperUtils.map(articuloServicio.findByArticuloId(articuloId), ArticuloDTO.class);
    }
    
    @CrossOrigin(origins = "http://localhost:8100")
    @PostMapping(value = "/add")
    public ResponseEntity<?> agregarAutenticacion(@RequestBody ArticuloDTO articuloDTO) {
        articuloServicio.saveOrUpdateArticulo(ObjectMapperUtils.map(articuloDTO, Articulo.class));
        return new ResponseEntity("Articulo agregado exitosamenta", HttpStatus.OK);
    }
    
    @CrossOrigin(origins = "http://localhost:8100")
    @PostMapping(value = "/addComentario")
    public ResponseEntity<?> agregarComentario(@RequestBody ComentarioDTO comentarioDTO) {
        comentarioServicio.saveOrUpdateComentario(ObjectMapperUtils.map(comentarioDTO, Comentario.class));
        return new ResponseEntity("Comentario agregado exitosamenta", HttpStatus.OK);
    }
    
    @CrossOrigin(origins = "http://localhost:8100")
    @DeleteMapping(value = "/delete/{articuloId}")
    public ResponseEntity<?> deleteArticuloByArticuloId(@PathVariable String articuloId) {
        articuloServicio.deleteArticuloByArticuloId(articuloId);
        comentarioServicio.deleteComentarioByArticuloId(articuloId);
        return new ResponseEntity("Elemento borrado exitosamente", HttpStatus.OK);
    }
}
