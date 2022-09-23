/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package tfg.Cinuma.controller;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import org.apache.commons.math3.util.Precision;
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
import tfg.Cinuma.Modelo.Elemento;
import tfg.Cinuma.Modelo.ElementoEnlistado;
import tfg.Cinuma.Modelo.ListaPersonal;
import tfg.Cinuma.Modelo.Perfil;
import tfg.Cinuma.dto.ElementoEnlistadoDTO;
import tfg.Cinuma.dto.RespuestaOKDTO;
import tfg.Cinuma.service.ElementoEnlistadoServicio;
import tfg.Cinuma.service.ElementoServicio;
import tfg.Cinuma.service.ListaPersonalServicio;
import tfg.Cinuma.service.PerfilServicio;
import tfg.Cinuma.util.ObjectMapperUtils;

/**
 *
 * @author jsnie
 */
@RestController
@RequestMapping("/elementoEnlistado")
public class ElementoEnlistadoControlador {
    
    @Autowired
    private ElementoEnlistadoServicio elementoEnlistadoServicio;
    @Autowired
    private ElementoServicio elementoServicio;
    @Autowired
    private ListaPersonalServicio listaPersonalServicio;
    @Autowired
    private PerfilServicio perfilServicio;

    @GetMapping(value = "/")
    public List<ElementoEnlistadoDTO> obtenerTodosLosElementosEnlistados() {
        return ObjectMapperUtils.mapAll(elementoEnlistadoServicio.findAll(), ElementoEnlistadoDTO.class);
    }
    
    @CrossOrigin(origins = "http://localhost:8100")
    @PostMapping(value = "/addPelicula")
    public ResponseEntity<?> agregarPelicula(@RequestBody ElementoEnlistadoDTO elementoEnlistadoDTO) {
        ElementoEnlistado elementoEnlistado = elementoEnlistadoServicio.saveOrUpdateElementoEnlistado(
                ObjectMapperUtils.map(elementoEnlistadoDTO, ElementoEnlistado.class));
        
        if(elementoEnlistado.getPuntuacionPersonal()!=null){
            Elemento elemento=this.elementoServicio.findByElementoId(elementoEnlistado.getElementoId());
            elemento = this.actualizarPuntuacionElemento(elemento);
            this.elementoServicio.saveOrUpdateElemento(elemento);
        }
        
        ListaPersonal listaPersonal = listaPersonalServicio.findByListaPersonalId(elementoEnlistado.getListaPersonalId());
        ListaPersonal listaPersonalActualizada;
        if(listaPersonal.getElementosVistos() != null){
            List<ElementoEnlistado> listaArrayList = new LinkedList<>(Arrays.asList(listaPersonal.getElementosVistos()));
            listaArrayList.add(elementoEnlistado);
            ElementoEnlistado[] lista = listaArrayList.toArray(new ElementoEnlistado[listaArrayList.size()]);
            listaPersonal.setElementosVistos(lista);
            listaPersonalActualizada =listaPersonalServicio.saveOrUpdateListaPersonal(listaPersonal);
        }else{
            ElementoEnlistado[] lista = new ElementoEnlistado[1];
            lista[0] = elementoEnlistado;
            listaPersonal.setElementosVistos(lista);
            listaPersonalActualizada =listaPersonalServicio.saveOrUpdateListaPersonal(listaPersonal);
        }
        
        if(elementoEnlistado.getPuntuacionPersonal()!=null){
            actualizarPuntuacionUsuario(listaPersonalActualizada);
        }
        
        return new ResponseEntity(elementoEnlistado, HttpStatus.OK);
    }
    
    @CrossOrigin(origins = "http://localhost:8100")
    @PostMapping(value = "/addSerie")
    public ResponseEntity<?> agregarSerie(@RequestBody ElementoEnlistadoDTO elementoEnlistadoDTO) {
        ElementoEnlistado elementoEnlistado = elementoEnlistadoServicio.saveOrUpdateElementoEnlistado(
                ObjectMapperUtils.map(elementoEnlistadoDTO, ElementoEnlistado.class));
                
        if(elementoEnlistado.getPuntuacionPersonal()!=null){
            Elemento elemento=this.elementoServicio.findByElementoId(elementoEnlistado.getElementoId());
            elemento = this.actualizarPuntuacionElemento(elemento);
            this.elementoServicio.saveOrUpdateElemento(elemento);
        }
        
        ListaPersonal listaPersonal = listaPersonalServicio.findByListaPersonalId(elementoEnlistado.getListaPersonalId());
        ListaPersonal listaPersonalActualizada;
        if(listaPersonal.getElementosVistos() != null){
            List<ElementoEnlistado> listaArrayList = new LinkedList<>(Arrays.asList(listaPersonal.getElementosVistos()));
            listaArrayList.add(elementoEnlistado);
            ElementoEnlistado[] lista = listaArrayList.toArray(new ElementoEnlistado[listaArrayList.size()]);
            listaPersonal.setElementosVistos(lista);
            listaPersonalActualizada = listaPersonalServicio.saveOrUpdateListaPersonal(listaPersonal);
        }else{
            ElementoEnlistado[] lista = new ElementoEnlistado[1];
            lista[0] = elementoEnlistado;
            listaPersonal.setElementosVistos(lista);
            listaPersonalActualizada = listaPersonalServicio.saveOrUpdateListaPersonal(listaPersonal);
        }
        
        if(elementoEnlistado.getPuntuacionPersonal()!=null){
            actualizarPuntuacionUsuario(listaPersonalActualizada);
        }
        
        return new ResponseEntity(elementoEnlistado, HttpStatus.OK);
    }
    
    @CrossOrigin(origins = "http://localhost:8100")
    @PostMapping(value = "/editarPelicula")
    public ResponseEntity<?> editarPelicula(@RequestBody ElementoEnlistadoDTO elementoEnlistadoDTO) {
        ElementoEnlistado elementoEnlistadoAnterior=this.elementoEnlistadoServicio.findByElementoEnlistadoId(elementoEnlistadoDTO.getElementoEnlistadoId());

        ElementoEnlistado elementoEnlistado = elementoEnlistadoServicio.saveOrUpdateElementoEnlistado(
                ObjectMapperUtils.map(elementoEnlistadoDTO, ElementoEnlistado.class));
        
        if(elementoEnlistado.getPuntuacionPersonal()!=null && elementoEnlistadoAnterior.getPuntuacionPersonal()!=null){
            if( elementoEnlistadoAnterior.getPuntuacionPersonal()!=elementoEnlistado.getPuntuacionPersonal()){
                 Elemento elemento=this.elementoServicio.findByElementoId(elementoEnlistado.getElementoId());
                elemento = this.actualizarPuntuacionElemento(elemento);
                this.elementoServicio.saveOrUpdateElemento(elemento);
            }
        }
        
        ListaPersonal listaPersonal = listaPersonalServicio.findByListaPersonalId(elementoEnlistado.getListaPersonalId());
        ListaPersonal listaPersonalActualizada;
        
        List<ElementoEnlistado> listaArrayList = new LinkedList<>(Arrays.asList(listaPersonal.getElementosVistos()));
        listaArrayList = this.actualizarElementoDeLista(elementoEnlistado,listaArrayList);
        ElementoEnlistado[] lista = listaArrayList.toArray(new ElementoEnlistado[listaArrayList.size()]);
        listaPersonal.setElementosVistos(lista);
        listaPersonalActualizada = listaPersonalServicio.saveOrUpdateListaPersonal(listaPersonal);
        

        if(elementoEnlistado.getPuntuacionPersonal()!=null && elementoEnlistadoAnterior.getPuntuacionPersonal()!=null){
            if( elementoEnlistadoAnterior.getPuntuacionPersonal()!=elementoEnlistado.getPuntuacionPersonal()){
                actualizarPuntuacionUsuario(listaPersonalActualizada);
            }
        }

        
        return new ResponseEntity(elementoEnlistado, HttpStatus.OK);
    }
    
    @CrossOrigin(origins = "http://localhost:8100")
    @PostMapping(value = "/editarSerie")
    public ResponseEntity<?> editarSerie(@RequestBody ElementoEnlistadoDTO elementoEnlistadoDTO) {
        ElementoEnlistado elementoEnlistadoAnterior=this.elementoEnlistadoServicio.findByElementoEnlistadoId(elementoEnlistadoDTO.getElementoEnlistadoId());
        
        ElementoEnlistado elementoEnlistado = elementoEnlistadoServicio.saveOrUpdateElementoEnlistado(
                ObjectMapperUtils.map(elementoEnlistadoDTO, ElementoEnlistado.class));
        
        if(elementoEnlistado.getPuntuacionPersonal()!=null && elementoEnlistadoAnterior.getPuntuacionPersonal()!=null){
            if( elementoEnlistadoAnterior.getPuntuacionPersonal()!=elementoEnlistado.getPuntuacionPersonal()){
                 Elemento elemento=this.elementoServicio.findByElementoId(elementoEnlistado.getElementoId());
                elemento = this.actualizarPuntuacionElemento(elemento);
                this.elementoServicio.saveOrUpdateElemento(elemento);
            }
        }
        
        ListaPersonal listaPersonal = listaPersonalServicio.findByListaPersonalId(elementoEnlistado.getListaPersonalId());
        ListaPersonal listaPersonalActualizada;
        
        List<ElementoEnlistado> listaArrayList = new LinkedList<>(Arrays.asList(listaPersonal.getElementosVistos()));
        listaArrayList = this.actualizarElementoDeLista(elementoEnlistado,listaArrayList);
        ElementoEnlistado[] lista = listaArrayList.toArray(new ElementoEnlistado[listaArrayList.size()]);
        listaPersonal.setElementosVistos(lista);
        listaPersonalActualizada = listaPersonalServicio.saveOrUpdateListaPersonal(listaPersonal);
        
        if(elementoEnlistado.getPuntuacionPersonal()!=null && elementoEnlistadoAnterior.getPuntuacionPersonal()!=null){
            if( elementoEnlistadoAnterior.getPuntuacionPersonal()!=elementoEnlistado.getPuntuacionPersonal()){
                actualizarPuntuacionUsuario(listaPersonalActualizada);
            }
        }
        
        return new ResponseEntity(elementoEnlistado, HttpStatus.OK);
    }
    
    @DeleteMapping(value = "/delete/{elementoEnlistadoId}")
    public ResponseEntity<?> deleteElementoEnlistadoByElementoEnlistadoId(@PathVariable String elementoEnlistadoId) {
        ElementoEnlistado elementoEnlistado = elementoEnlistadoServicio.findByElementoEnlistadoId(elementoEnlistadoId);
        ListaPersonal listaPersonal = listaPersonalServicio.findByListaPersonalId(elementoEnlistado.getListaPersonalId());
        List<ElementoEnlistado> listaArrayList = new LinkedList<>(Arrays.asList(listaPersonal.getElementosVistos()));
        listaArrayList = this.borrarElementoDeLista(elementoEnlistado,listaArrayList);
        ElementoEnlistado[] lista = listaArrayList.toArray(new ElementoEnlistado[listaArrayList.size()]);
        listaPersonal.setElementosVistos(lista);
        listaPersonalServicio.saveOrUpdateListaPersonal(listaPersonal);
        elementoEnlistadoServicio.deleteElementoEnlistadoByElementoEnlistadoId(
                elementoEnlistado.getElementoEnlistadoId());
        return new ResponseEntity(new RespuestaOKDTO("Usuario borrado exitosamente"), HttpStatus.OK);
    }
    
    private Elemento actualizarPuntuacionElemento(Elemento elemento){
        List<ElementoEnlistado> elementosEnlistados = this.elementoEnlistadoServicio.findAll(elemento.getElementoId());
        float resultado = 0;
        int cantidadDeSumados = 0;
        for (ElementoEnlistado elementoEnlistado : elementosEnlistados) {
            if(elementoEnlistado.getPuntuacionPersonal()!=null){
                resultado= resultado+elementoEnlistado.getPuntuacionPersonal();
                cantidadDeSumados++;
            }
        }
        if(resultado!=0){
            resultado=resultado/cantidadDeSumados;
        }
        elemento.setCalificacionPromedio(resultado);
        return elemento;
    }
    
    private List borrarElementoDeLista(ElementoEnlistado elementoEnlistado, List<ElementoEnlistado> listaArrayList){
        int i=0;
        List<ElementoEnlistado> listaArrayListRemovido = new LinkedList<>(listaArrayList);
        for(ElementoEnlistado elemento : listaArrayList){
            if(elementoEnlistado.getElementoEnlistadoId().equals(elemento.getElementoEnlistadoId())){
                listaArrayListRemovido.remove(i);
            }
            i++;
        }
        return listaArrayListRemovido;
    }
    
    private List actualizarElementoDeLista(ElementoEnlistado elementoEnlistado, List<ElementoEnlistado> listaArrayList){
        int i=0;
        List<ElementoEnlistado> listaArrayListModificada = new LinkedList<>(listaArrayList);
        for(ElementoEnlistado elemento : listaArrayList){
            if(elementoEnlistado.getElementoEnlistadoId().equals(elemento.getElementoEnlistadoId())){
                listaArrayListModificada.set(i, elementoEnlistado);
            }
            i++;
        }
        return listaArrayListModificada;
    }
    
    private void actualizarPuntuacionUsuario(ListaPersonal listaPersonalActualizada){
       float total = 0;
       int cantidadPuntuados = 0;
       
        for (ElementoEnlistado elementoVisto : listaPersonalActualizada.getElementosVistos()) {
            if(elementoVisto.getPuntuacionPersonal() != null){
                total = total + elementoVisto.getPuntuacionPersonal();
                cantidadPuntuados++;
            }
        }
        
        if(total>0){
            total = total/cantidadPuntuados;
            Precision.round(total, 2);
            Perfil perfil = this.perfilServicio.findByPerfilId(listaPersonalActualizada.getElementosVistos()[0].getPerfilId());
            perfil.setPuntuacionPromedio(total);
            this.perfilServicio.saveOrUpdatePerfil(perfil);
        }
        
    }
    
    
}
