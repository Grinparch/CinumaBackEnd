/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package tfg.Cinuma.controller;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import tfg.Cinuma.Modelo.Grupo;
import tfg.Cinuma.Modelo.Lista;
import tfg.Cinuma.dto.GrupoDTO;
import tfg.Cinuma.dto.ListaDTO;
import tfg.Cinuma.dto.ListaIDUsuariosDTO;
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
    
    @GetMapping(value = "/{grupoId}")
    public GrupoDTO obtenerGrupoPorId(@PathVariable("grupoId") String grupoId) {
        return ObjectMapperUtils.map(grupoServicio.findByGrupoId(grupoId), GrupoDTO.class);
    }
    
    @CrossOrigin(origins = "http://localhost:8100")
    @PostMapping(value = "/add")
    public ResponseEntity<?> agregarGrupo(@RequestBody GrupoDTO grupoDTO) {
        grupoServicio.saveOrUpdateGrupo(ObjectMapperUtils.map(grupoDTO, Grupo.class));
        return new ResponseEntity("Grupo agregado exitosamente", HttpStatus.OK);
    }
    
    @CrossOrigin(origins = "http://localhost:8100")
    @PostMapping(value = "/editarGrupo")
    public ResponseEntity<?> editarGrupo(@RequestBody GrupoDTO grupoDTO) {
        grupoServicio.saveOrUpdateGrupo(ObjectMapperUtils.map(grupoDTO, Grupo.class));
        return new ResponseEntity("Grupo agregado exitosamente", HttpStatus.OK);
    }
    
    @CrossOrigin(origins = "http://localhost:8100")
    @PutMapping(value = "/unirseAGrupo/{grupoId}")
    public ResponseEntity<?> editarGrupo(@RequestBody ListaIDUsuariosDTO listaDeUnID,@PathVariable String grupoId) {
        Grupo grupo = grupoServicio.findByGrupoId(grupoId);
        List<String> listaMiembrosId = new LinkedList<>(Arrays.asList(grupo.getMiembros()));
        listaMiembrosId.add(listaDeUnID.getIdUsuarios()[0]);
        String[] listaMiembrosIdAAgregar = listaMiembrosId.toArray(new String[listaMiembrosId.size()]);
        grupo.setMiembros(listaMiembrosIdAAgregar);
        grupoServicio.saveOrUpdateGrupo(ObjectMapperUtils.map(grupo, Grupo.class));
        return new ResponseEntity("Grupo agregado exitosamente", HttpStatus.OK);
    }
    
    @CrossOrigin(origins = "http://localhost:8100")
    @DeleteMapping(value = "/delete/{grupoId}")
    public ResponseEntity<?> deleteElementoByElementoId(@PathVariable String grupoId) {
        grupoServicio.deleteGrupoByGrupoId(grupoId);
        return new ResponseEntity("Grupo borrado exitosamente", HttpStatus.OK);
    }
}
