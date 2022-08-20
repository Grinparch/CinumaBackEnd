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
import tfg.Cinuma.Modelo.Grupo;
import tfg.Cinuma.Modelo.Lista;
import tfg.Cinuma.dto.GrupoDTO;
import tfg.Cinuma.dto.ListaDTO;
import tfg.Cinuma.service.GrupoServicio;
import tfg.Cinuma.service.ListaServicio;
import tfg.Cinuma.util.ObjectMapperUtils;

/**
 *
 * @author jsnie
 */
@RestController
@RequestMapping("/grupo")
public class GrupoControlador {
    
    @Autowired
    private GrupoServicio grupoServicio;
    
    @CrossOrigin(origins = "http://localhost:8100")
    @GetMapping(value = "/")
    public List<GrupoDTO> obtenerTodosLosGrupos() {
        return ObjectMapperUtils.mapAll(grupoServicio.findAll(), GrupoDTO.class);
    }
    
    @CrossOrigin(origins = "http://localhost:8100")
    @PostMapping(value = "/add")
    public ResponseEntity<?> agregarGrupo(@RequestBody GrupoDTO grupoDTO) {
        grupoServicio.saveOrUpdateGrupo(ObjectMapperUtils.map(grupoDTO, Grupo.class));
        return new ResponseEntity("Grupo agregado exitosamente", HttpStatus.OK);
    }
}
