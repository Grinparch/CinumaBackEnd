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
import tfg.Cinuma.Modelo.Articulo;
import tfg.Cinuma.Modelo.Comentario;
import tfg.Cinuma.Modelo.Perfil;
import tfg.Cinuma.dto.ArticuloDTO;
import tfg.Cinuma.dto.ComentarioDTO;
import tfg.Cinuma.dto.RespuestaOKDTO;
import tfg.Cinuma.service.ArticuloServicio;
import tfg.Cinuma.service.ComentarioServicio;
import tfg.Cinuma.service.PerfilServicio;
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
    @Autowired
    private PerfilServicio perfilServicio;
    
    
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
    
    @GetMapping(value = "/recomendados/{perfilId}")
    public List<Articulo> obtenerElementosRecomendadosDeUsuario(@PathVariable("perfilId") String perfilId) {
        Perfil perfilCentral = this.perfilServicio.findByPerfilId(perfilId);
        List<String> recomendados;
        recomendados = (obtenerArticulosCercanos(perfilCentral));
        List<Articulo> articulosRecomendados = new ArrayList<>();
        for (String idArticulo : recomendados) {
            articulosRecomendados.add(articuloServicio.findByArticuloId(idArticulo));
        }
        return articulosRecomendados;
    }
    
    @CrossOrigin(origins = "http://localhost:8100")
    @PostMapping(value = "/add")
    public ResponseEntity<?> agregarAutenticacion(@RequestBody ArticuloDTO articuloDTO) {
        return new ResponseEntity(articuloServicio.saveOrUpdateArticulo(ObjectMapperUtils.map(articuloDTO, Articulo.class)), HttpStatus.OK);
    }
    
    @CrossOrigin(origins = "http://localhost:8100")
    @PostMapping(value = "/addComentario")
    public ResponseEntity<?> agregarComentario(@RequestBody ComentarioDTO comentarioDTO) {
        return new ResponseEntity(comentarioServicio.saveOrUpdateComentario(ObjectMapperUtils.map(comentarioDTO, Comentario.class)), HttpStatus.OK);
    }
    
    @CrossOrigin(origins = "http://localhost:8100")
    @DeleteMapping(value = "/delete/{articuloId}")
    public ResponseEntity<?> deleteArticuloByArticuloId(@PathVariable String articuloId) {
        articuloServicio.deleteArticuloByArticuloId(articuloId);
        comentarioServicio.deleteComentarioByArticuloId(articuloId);
        return new ResponseEntity(new RespuestaOKDTO("Elemento borrado exitosamente"), HttpStatus.OK);
    }
    
    //Obtengo 5 articulos para recomendar al usuario en la pagina principal
    private List<String> obtenerArticulosCercanos(Perfil perfilCentral){
        List<Float> listaPuntuaciones = new ArrayList<>();
        List<Articulo> allArticulos = this.articuloServicio.findAll();
        List<String> recomendados = new ArrayList<>();
        
        boolean autor = false;
        float puntuacion = 0;
        
        Collections.shuffle(allArticulos);
        
        //Estas variables determinan el peso de las coincidencias y el multiplicador que las ajusta
        //para dispersar puntuaciones o mantenerlas cercanas
        float pesoGenero = 10;
        float multiplicador = 5;
        
        
        //Itero sobre todos los articulos
        for (Articulo articulo : allArticulos) {
            
            //Verifico si no es el autor del articulo
            if(articulo.getAutorId().equals(perfilCentral.getUsuarioId())){
                autor = true;
            }
            
            
            //Si es el autor calculo la puntuacion del articulo
            if(!autor){
                
                //Verifico si contiene su genero preferido
                if(articulo.getGenerosAsociados()!= null && perfilCentral.getGeneroPreferido()!=null &&
                        articulo.getGenerosAsociados().length>0){
                    for (String genero : articulo.getGenerosAsociados()) {
                        if(perfilCentral.getGeneroPreferido().equals(genero)){
                            puntuacion = puntuacion + (pesoGenero * multiplicador);
                        }
                    }
                }                
            
                //Se agregan a la lista las puntuaciones y articulos
                listaPuntuaciones.add(puntuacion);
                recomendados.add(articulo.getArticuloId());
            }
            
            //Reinicio el contador de puntuaciones y el boolean para verificar si el articulo no es de el;
            //si es su propio articulo pasara hasta aqui
            autor = false;
            puntuacion=0;
        }
        
        //invocar knn con k articulos y traerse esa lista, en este caso es 5
        KNN knn = new KNN(5);
        
        List<String> articulosRecomendados  = knn.usuariosMasCercanos(listaPuntuaciones, recomendados);
        
        return articulosRecomendados;
    }
}
