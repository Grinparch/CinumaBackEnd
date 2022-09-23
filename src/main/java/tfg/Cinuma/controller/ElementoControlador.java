/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package tfg.Cinuma.controller;

import java.util.ArrayList;
import java.util.Collections;
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
import tfg.Cinuma.Modelo.Elemento;
import tfg.Cinuma.Modelo.ElementoEnlistado;
import tfg.Cinuma.Modelo.ListaPersonal;
import tfg.Cinuma.Modelo.Perfil;
import tfg.Cinuma.dto.ElementoDTO;
import tfg.Cinuma.dto.ListaIDElementosDTO;
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
@RequestMapping("/elemento")
public class ElementoControlador {
    
    @Autowired
    private ElementoServicio elementoServicio;
    @Autowired
    private ElementoEnlistadoServicio elementoEnlistadoServicio;
    @Autowired
    private PerfilServicio perfilServicio;
    @Autowired
    private ListaPersonalServicio listaPersonalServicio;
    
    @CrossOrigin(origins = "http://localhost:8100")
    @GetMapping(value = "/")
    public List<ElementoDTO> obtenerTodosLosElementos() {
        return ObjectMapperUtils.mapAll(elementoServicio.findAll(), ElementoDTO.class);
    }
    
    @GetMapping(value = "/{elementoId}")
    public ElementoDTO obtenerElementoPorId(@PathVariable("elementoId") String elementoId) {
        return ObjectMapperUtils.map(elementoServicio.findByElementoId(elementoId), ElementoDTO.class);
    }
    
    @GetMapping(value = "/recomendados/{perfilId}")
    public List<Elemento> obtenerElementosRecomendadosDeUsuario(@PathVariable("perfilId") String perfilId) {
        Perfil perfilCentral = this.perfilServicio.findByPerfilId(perfilId);
        ListaIDElementosDTO recomendados = new ListaIDElementosDTO();
        recomendados.setIdElementos(obtenerElementosCercanos(perfilCentral));
        List<Elemento> elementosRecomendados = new ArrayList<>();
        for (String idElemento : recomendados.getIdElementos()) {
            elementosRecomendados.add(elementoServicio.findByElementoId(idElemento));
        }
        return elementosRecomendados;
    }
    
    @PostMapping(value = "/listaElementos")
    public Elemento[] obtenerUsuariosPorUsername(@RequestBody ListaIDElementosDTO idElementosDTO) {
        List<String> listaIDElementos = idElementosDTO.getIdElementos();
        Elemento[] listaElementos = new Elemento[listaIDElementos.size()];
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
        Elemento elemento = elementoServicio.saveOrUpdateElemento(ObjectMapperUtils.map(elementoDTO, Elemento.class));
        return new ResponseEntity(elemento, HttpStatus.OK);
    }
    
    @CrossOrigin(origins = "http://localhost:8100")
    @PostMapping(value = "/addSerie")
    public ResponseEntity<?> agregarSerie(@RequestBody ElementoDTO elementoDTO) {
        Elemento elemento = elementoServicio.saveOrUpdateElemento(ObjectMapperUtils.map(elementoDTO, Elemento.class));
        return new ResponseEntity(elemento, HttpStatus.OK);
    }
    
    @CrossOrigin(origins = "http://localhost:8100")
    @DeleteMapping(value = "/delete/{elementoId}")
    public ResponseEntity<?> deleteElementoByElementoId(@PathVariable String elementoId) {
        List<ElementoEnlistado> elementosEnlistados = this.elementoEnlistadoServicio.findAll(elementoId);
        for (ElementoEnlistado elementoEnlistado : elementosEnlistados) {
            elementoEnlistadoServicio.deleteElementoEnlistadoByElementoEnlistadoId(elementoEnlistado.getElementoEnlistadoId());
        }
        elementoServicio.deleteElementoByElementoId(elementoId);
        return new ResponseEntity( new RespuestaOKDTO("Elemento eliminado exitosamente"), HttpStatus.OK);
    }
    
    @CrossOrigin(origins = "http://localhost:8100")
    @PostMapping(value = "/editarPelicula")
    public ResponseEntity<?> editarPelicula(@RequestBody ElementoDTO elementoDTO) {
        Elemento elemento = elementoServicio.saveOrUpdateElemento(ObjectMapperUtils.map(elementoDTO, Elemento.class));
        List<ElementoEnlistado> elementosEnlistados = this.elementoEnlistadoServicio.findAll(elemento.getElementoId());
        for (ElementoEnlistado elementoEnlistado : elementosEnlistados) {
            actualizaElementoEnlistado(elemento, elementoEnlistado);
        }
        return new ResponseEntity(elemento, HttpStatus.OK);
    }
    
    @CrossOrigin(origins = "http://localhost:8100")
    @PostMapping(value = "/editarSerie")
    public ResponseEntity<?> editarSerie(@RequestBody ElementoDTO elementoDTO) {
        Elemento elemento = elementoServicio.saveOrUpdateElemento(ObjectMapperUtils.map(elementoDTO, Elemento.class));
        List<ElementoEnlistado> elementosEnlistados = this.elementoEnlistadoServicio.findAll(elemento.getElementoId());
        for (ElementoEnlistado elementoEnlistado : elementosEnlistados) {
            actualizaElementoEnlistado(elemento, elementoEnlistado);
        }
        return new ResponseEntity(elemento, HttpStatus.OK);
    }
    
    private void actualizaElementoEnlistado(Elemento elemento, ElementoEnlistado elementoEnlistado){
        elementoEnlistado.setActores(elemento.getActores());
        elementoEnlistado.setTitulo(elemento.getTitulo());
        elementoEnlistado.setDuracion(elemento.getDuracion());
        elementoEnlistado.setDirector(elemento.getDirector());
        elementoEnlistado.setIdioma(elemento.getIdioma());
        elementoEnlistado.setGenero(elemento.getGenero());
        
        this.elementoEnlistadoServicio.saveOrUpdateElementoEnlistado(elementoEnlistado);
    }
    
    
    //Obtengo 5 elementos para recomendar al usuario en la pagina principal
    private List<String> obtenerElementosCercanos(Perfil perfilCentral){
        List<Float> listaPuntuaciones = new ArrayList<>();
        ListaPersonal listaPersonalCentral =this.listaPersonalServicio.findByListaPersonalId(perfilCentral.getListaPersonalId());
        List<Elemento> allElementos = this.elementoServicio.findAll();
        List<String> recomendados = new ArrayList<>();
        
        boolean visto = false;
        float puntuacion = 0;
        
        Collections.shuffle(allElementos);
        
        //Estas variables determinan el peso de las coincidencias y el multiplicador que las ajusta
        //para dispersar puntuaciones o mantenerlas cercanas
        float pesoActor = 5;
        float pesoGenero = 10;
        float multiplicador = 5;
        
        
        //Itero sobre todos los elementos
        for (Elemento elemento : allElementos) {
            
            //Verifico si no ha visto el elemento iterando sobre la lista personal
            if(listaPersonalCentral.getElementosVistos()!= null && listaPersonalCentral.getElementosVistos().length>0){
                for (ElementoEnlistado elementoVisto : listaPersonalCentral.getElementosVistos()) {
                    if(elementoVisto.getElementoId().equals(elemento.getElementoId())){
                        visto=true;
                    }
                }
            }
            
            
            //Si no ha visto el elemento calculo la puntuacion del mismo
            if(!visto){
                
                //Verifico si contiene su genero preferido
                if(elemento.getGenero() != null && perfilCentral.getGeneroPreferido()!=null &&
                        elemento.getGenero().length>0){
                    for (String genero : elemento.getGenero()) {
                        if(perfilCentral.getGeneroPreferido().equals(genero)){
                            puntuacion = puntuacion + (pesoGenero * multiplicador);
                        }
                    }
                }
                
                
                //Verifico si hay algun actor que al usuario le guste
                if(elemento.getActores() != null && perfilCentral.getActoresPreferidos()!=null &&
                        elemento.getActores().length>0 && perfilCentral.getActoresPreferidos().length>0){
                    for (String actor : elemento.getActores()) {
                        for (String actorPreferidoCentral : perfilCentral.getActoresPreferidos()) {
                            if(actor.toUpperCase().equals(actorPreferidoCentral.toUpperCase())){
                                puntuacion = puntuacion + (pesoActor * multiplicador);
                            }
                        }
                    }
                }
                
            
                //Se agregan a la lista las puntuaciones y elementos
                listaPuntuaciones.add(puntuacion);
                recomendados.add(elemento.getElementoId());
            }
            
            //Reinicio el contador de puntuaciones y el boolean para verificar si el elemento es nuevo;
            //un elemento ya visto pasara directo hasta aqui
            visto = false;
            puntuacion=0;
        }
        
        //invocar knn con k elementos y traerse esa lista, en este caso es 5
        KNN knn = new KNN(5);
        
        List<String> elementosRecomendados  = knn.usuariosMasCercanos(listaPuntuaciones, recomendados);
        
        return elementosRecomendados;
    }
}
