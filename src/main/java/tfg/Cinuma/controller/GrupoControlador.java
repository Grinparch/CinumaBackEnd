/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package tfg.Cinuma.controller;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
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
import tfg.Cinuma.Modelo.Elemento;
import tfg.Cinuma.Modelo.ElementoEnlistado;
import tfg.Cinuma.Modelo.Grupo;
import tfg.Cinuma.Modelo.ListaPersonal;
import tfg.Cinuma.Modelo.Perfil;
import tfg.Cinuma.Modelo.Usuario;
import tfg.Cinuma.dto.GrupoDTO;
import tfg.Cinuma.dto.ListaIDUsuariosDTO;
import tfg.Cinuma.dto.RespuestaOKDTO;
import tfg.Cinuma.service.ElementoServicio;
import tfg.Cinuma.service.GrupoServicio;
import tfg.Cinuma.service.ListaPersonalServicio;
import tfg.Cinuma.service.PerfilServicio;
import tfg.Cinuma.service.UsuarioServicio;
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
    @Autowired
    private ListaPersonalServicio listaPersonalServicio;
    @Autowired
    private PerfilServicio perfilServicio;
    @Autowired
    private ElementoServicio elementoServicio;
    @Autowired
    private UsuarioServicio usuarioServicio;
    
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
        return new ResponseEntity(grupoServicio.saveOrUpdateGrupo(ObjectMapperUtils.map(grupoDTO, Grupo.class)), HttpStatus.OK);
    }
    
    @CrossOrigin(origins = "http://localhost:8100")
    @PostMapping(value = "/editarGrupo")
    public ResponseEntity<?> editarGrupo(@RequestBody GrupoDTO grupoDTO) {
        return new ResponseEntity(grupoServicio.saveOrUpdateGrupo(ObjectMapperUtils.map(grupoDTO, Grupo.class)), HttpStatus.OK);
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
        return new ResponseEntity(new RespuestaOKDTO("Unido a Grupo exitosamente"), HttpStatus.OK);
    }
    
    @CrossOrigin(origins = "http://localhost:8100")
    @DeleteMapping(value = "/delete/{grupoId}")
    public ResponseEntity<?> deleteElementoByElementoId(@PathVariable String grupoId) {
        grupoServicio.deleteGrupoByGrupoId(grupoId);
        return new ResponseEntity(new RespuestaOKDTO("Grupo borrado exitosamente"), HttpStatus.OK);
    }
    
    @GetMapping(value = "/recomendados/{perfilId}")
    public Grupo obtenerGruposRecomendadosParaUsuario(@PathVariable("perfilId") String perfilId) {
        Perfil perfilCentral = this.perfilServicio.findByPerfilId(perfilId);
        String recomendado = obtenerGruposCercanos(perfilCentral);
        return grupoServicio.findByGrupoId(recomendado);
    }
    
    
    //Obtengo un grupo en el que no se encuentre para recomendar al usuario
    private String obtenerGruposCercanos(Perfil perfilCentral){
        List<Float> listaPuntuaciones = new ArrayList<>();
        ListaPersonal listaPersonalCentral =this.listaPersonalServicio.findByListaPersonalId(perfilCentral.getListaPersonalId());
        List<Grupo> allGrupos = this.grupoServicio.findAll();
        List<String> recomendados = new ArrayList<>();
        Usuario usuarioCentral = usuarioServicio.findByPerfil(perfilCentral.getPerfilId());
        
        boolean isMiembro = false;
        float puntuacion = 0;
        
        Collections.shuffle(allGrupos);
        
        //Estas variables determinan el peso de las coincidencias y el multiplicador que las ajusta
        //para dispersar puntuaciones o mantenerlas cercanas
        float pesoElemento = 5;
        float multiplicador = 5;
        
        
        //Itero sobre todos los elementos
        if(allGrupos!=null && !allGrupos.isEmpty()){
            
            for (Grupo grupo : allGrupos) {
            
                //Verifico si no pertenece al grupo
                if(grupo.getMiembros()!= null && grupo.getMiembros().length>0){
                    for (String miembro : grupo.getMiembros()) {
                        if(usuarioCentral.getUserId().equals(miembro)){
                            isMiembro=true;
                        }
                    }
                }


                //Si no es miembro calculo las puntuaciones
                if(!isMiembro){

                    //Verifico  si comparten peliculas o series vistas
                    if(grupo.getElementosPreferidos()!= null && listaPersonalCentral.getElementosVistos() != null &&
                            grupo.getElementosPreferidos().length>0 && listaPersonalCentral.getElementosVistos().length>0){
                        
                        for (String elementoId : grupo.getElementosPreferidos()) {
                            Elemento elemento = this.elementoServicio.findByElementoId(elementoId);
                            for (ElementoEnlistado elementoVistoCentral : listaPersonalCentral.getElementosVistos()) {
                                if(elemento.getElementoId().equals(elementoVistoCentral.getElementoId())){
                                    puntuacion = puntuacion + (pesoElemento * multiplicador);
                                }
                            }
                        }

                    }


                    //Se agregan a la lista las puntuaciones y grupos
                    listaPuntuaciones.add(puntuacion);
                    recomendados.add(grupo.getGrupoId());
                }

                //Reinicio el contador de puntuaciones y el boolean para verificar si no pertenece al grupo;
                //un grupo al que ya se pertenece pasara directo hasta aqui
                isMiembro = false;
                puntuacion=0;
            }
        }
       
        
        //ordenar los grupos por puntuacion y traerse el mejor puntuado
        KNN knn = new KNN(1);
        
        List<String> elementosRecomendados  = knn.usuariosMasCercanos(listaPuntuaciones, recomendados);
        
        return elementosRecomendados.get(0);
    }
}
