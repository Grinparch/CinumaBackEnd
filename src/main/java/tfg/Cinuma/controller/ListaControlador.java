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
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import tfg.Cinuma.Modelo.Lista;
import tfg.Cinuma.Modelo.ListaPersonal;
import tfg.Cinuma.Modelo.Perfil;
import tfg.Cinuma.dto.ListaDTO;
import tfg.Cinuma.dto.ListaPersonalDTO;
import tfg.Cinuma.service.ListaPersonalServicio;
import tfg.Cinuma.service.ListaServicio;
import tfg.Cinuma.service.PerfilServicio;
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
    @Autowired
    private PerfilServicio perfilServicio;
    
    @CrossOrigin(origins = "http://localhost:8100")
    @GetMapping(value = "/")
    public List<ListaDTO> obtenerTodasLasListas() {
        return ObjectMapperUtils.mapAll(listaServicio.findAll(), ListaDTO.class);
    }
    
    @GetMapping(value = "/{listaId}")
    public ListaDTO obtenerListaPorId(@PathVariable("listaId") String listaId) {
        return ObjectMapperUtils.map(listaServicio.findByListaId(listaId), ListaDTO.class);
    }
    
    @CrossOrigin(origins = "http://localhost:8100")
    @DeleteMapping(value = "/delete/{listaId}")
    public ResponseEntity<?> deleteListaByListaId(@PathVariable("listaId") String listaId) {
        Lista lista = listaServicio.findByListaId(listaId);
        Perfil perfil = perfilServicio.findByPerfilId(lista.getPerfilId());
        listaServicio.deleteListaByListaId(listaId);
        List<String> listaDeListas = new LinkedList<>(Arrays.asList(perfil.getListasCreadas()));
        listaDeListas = this.buscarYEliminarElementoEnLista(listaDeListas, listaId);
        String[] listaDeListasAAgregar= listaDeListas.toArray(new String[listaDeListas.size()]);
        perfil.setListasCreadas(listaDeListasAAgregar);
        perfilServicio.saveOrUpdatePerfil(perfil);
        return new ResponseEntity("Elemento borrado exitosamente", HttpStatus.OK);
    }
    
    @CrossOrigin(origins = "http://localhost:8100")
    @PostMapping(value = "/add")
    public ResponseEntity<?> agregarLista(@RequestBody ListaDTO listaDTO) {
        Lista lista = listaServicio.saveOrUpdateLista(ObjectMapperUtils.map(listaDTO, Lista.class));
        Perfil perfil = perfilServicio.findByPerfilId(lista.getPerfilId());
        if(perfil.getListasCreadas() == null){
            String[] listaListaId = new String[1];
            listaListaId[0]= lista.getListaId();
            perfil.setListasCreadas(listaListaId);
        }else{
            List<String> listaListaId = new LinkedList<>(Arrays.asList(perfil.getListasCreadas()));
            listaListaId.add(lista.getListaId());
            String[] listaListaIdAAgregar = listaListaId.toArray(new String[listaListaId.size()]);
            perfil.setListasCreadas(listaListaIdAAgregar);
        }
        perfilServicio.saveOrUpdatePerfil(perfil);
        return new ResponseEntity("Lista agregada exitosamente", HttpStatus.OK);
    }
    
    @CrossOrigin(origins = "http://localhost:8100")
    @PostMapping(value = "/editarLista")
    public ResponseEntity<?> editarLista(@RequestBody ListaDTO listaDTO) {
        listaServicio.saveOrUpdateLista(ObjectMapperUtils.map(listaDTO, Lista.class));
        return new ResponseEntity("Lista editada exitosamente", HttpStatus.OK);
    }
    
    private List buscarYEliminarElementoEnLista(List<String> listaDeListas, String listaIdAEliminar){
        int i=0;
        List<String> listaArrayListRemovido = new LinkedList<>(listaDeListas);
        for(String lista : listaArrayListRemovido){
            if(lista.equals(listaIdAEliminar)){
                listaArrayListRemovido.remove(i);
            }
            i++;
        }
        return listaArrayListRemovido;
    }
}
