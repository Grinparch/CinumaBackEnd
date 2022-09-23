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
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import tfg.Cinuma.Modelo.Autenticacion;
import tfg.Cinuma.Modelo.ElementoEnlistado;
import tfg.Cinuma.Modelo.Grupo;
import tfg.Cinuma.Modelo.ListaPersonal;
import tfg.Cinuma.Modelo.Perfil;
import tfg.Cinuma.Modelo.Usuario;
import tfg.Cinuma.dto.ListaIDUsuariosDTO;
import tfg.Cinuma.dto.ListaPerfilesRecomendadosDTO;
import tfg.Cinuma.dto.RespuestaOKDTO;
import tfg.Cinuma.dto.UsuarioDTO;
import tfg.Cinuma.service.AutenticacionServicio;
import tfg.Cinuma.service.ElementoEnlistadoServicio;
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
@RequestMapping("/usuarios")
public class UsuarioControlador {
    
    @Autowired
    private UsuarioServicio usuarioServicio;
    @Autowired
    private AutenticacionServicio autenticacionServicio;
    @Autowired
    private PerfilServicio perfilServicio;
    @Autowired
    private GrupoServicio grupoServicio;
    @Autowired
    private ListaPersonalServicio listaPersonalServicio;
    @Autowired
    private ElementoEnlistadoServicio elementoEnlistadoServicio;

    @GetMapping(value = "/")
    public List<UsuarioDTO> obtenerTodosLosUsuarios() {
        return ObjectMapperUtils.mapAll(usuarioServicio.findAll(), UsuarioDTO.class);
    }
    
    @GetMapping(value = "/byUsername/{username}")
    public UsuarioDTO obtenerUsuarioPorUsername(@PathVariable("username") String username) {
        return ObjectMapperUtils.map(usuarioServicio.findByUsername(username), UsuarioDTO.class);
    }
    
    @GetMapping(value = "/byID/{userId}")
    public UsuarioDTO obtenerUsuarioPorIdUsuario(@PathVariable("userId") String userId) {
        return ObjectMapperUtils.map(usuarioServicio.findByUserId(userId), UsuarioDTO.class);
    }
    
    @GetMapping(value = "/recomendados/{perfilId}")
    public List<String> obtenerUsuariosRecomendadosDeUsuario(@PathVariable("perfilId") String perfilId) {
        Perfil perfilCentral = this.perfilServicio.findByPerfilId(perfilId);
        ListaPerfilesRecomendadosDTO recomendados = new ListaPerfilesRecomendadosDTO();
        recomendados.setIdPerfiles(obtenerUsuariosCercanos(perfilCentral));
        List<String> usernamesRecomendados = new ArrayList<>();
        for (String idPerfil : recomendados.getIdPerfiles()) {
            usernamesRecomendados.add(usuarioServicio.findByPerfil(idPerfil).getUsername());
        }
        return usernamesRecomendados;
    }
    
    @PostMapping(value = "/listaUsuarios")
    public Usuario[] obtenerUsuariosDeGrupo(@RequestBody ListaIDUsuariosDTO idUsuariosDTO) {
        String[] listaIDUsuarios = idUsuariosDTO.getIdUsuarios();
        Usuario[] listaUsuarios = new Usuario[listaIDUsuarios.length];
        int i = 0;
        for (String idUsuario : listaIDUsuarios) {
            listaUsuarios[i] = usuarioServicio.findByUserId(idUsuario);
            i++;
        }
        return listaUsuarios;
    }

    @PostMapping(value = "/addUsuarioComun")
    public ResponseEntity<?> agregarUsuario(@RequestBody UsuarioDTO usuarioDTO) {
        Autenticacion authExistente = autenticacionServicio.findByUsuario(usuarioDTO.getUsername());
        if(authExistente == null){
            Autenticacion auth = new Autenticacion(null,usuarioDTO.getUsername(),usuarioDTO.getAutenticacion().getClave());
            Autenticacion newAuth = autenticacionServicio.saveOrUpdateAutenticacion(ObjectMapperUtils.map(auth, Autenticacion.class));
            ListaPersonal listaP = new ListaPersonal();
            ListaPersonal newListaP = listaPersonalServicio.saveOrUpdateListaPersonal(ObjectMapperUtils.map(listaP, ListaPersonal.class));
            Perfil perfil = new Perfil(null,newListaP.getListaPersonalId());
            Perfil newPerfil = perfilServicio.saveOrUpdatePerfil(ObjectMapperUtils.map(perfil, Perfil.class));            
            Usuario usuario = new Usuario(null,usuarioDTO.getUsername(),usuarioDTO.getEmail(),
                    usuarioDTO.getPhone(),2,newPerfil.getPerfilId(),newAuth);
            Usuario newUsuario = usuarioServicio.saveOrUpdateUsuario(ObjectMapperUtils.map(usuario, Usuario.class));
            perfil.setUsuarioId(newUsuario.getUserId());
            perfilServicio.saveOrUpdatePerfil(perfil);
            return new ResponseEntity(newUsuario, HttpStatus.OK);
        }
        return new ResponseEntity(new RespuestaOKDTO("Usuario no existente"), HttpStatus.BAD_REQUEST);
    }
    
    @PostMapping(value = "/addUsuarioAvanzado")
    public ResponseEntity<?> agregarUsuarioAvanzado(@RequestBody UsuarioDTO usuarioDTO) {
        Autenticacion authExistente = autenticacionServicio.findByUsuario(usuarioDTO.getUsername());
        if(authExistente == null){
            Autenticacion auth = new Autenticacion(null,usuarioDTO.getUsername(),usuarioDTO.getAutenticacion().getClave());
            Autenticacion newAuth = autenticacionServicio.saveOrUpdateAutenticacion(ObjectMapperUtils.map(auth, Autenticacion.class));
            ListaPersonal listaP = new ListaPersonal();
            ListaPersonal newListaP = listaPersonalServicio.saveOrUpdateListaPersonal(ObjectMapperUtils.map(listaP, ListaPersonal.class));
            Perfil perfil = new Perfil(null,newListaP.getListaPersonalId());
            Perfil newPerfil = perfilServicio.saveOrUpdatePerfil(ObjectMapperUtils.map(perfil, Perfil.class));            
            Usuario usuario = new Usuario(null,usuarioDTO.getUsername(),usuarioDTO.getEmail(),
                    usuarioDTO.getPhone(),usuarioDTO.getRol(),newPerfil.getPerfilId(),newAuth);
            Usuario newUsuario = usuarioServicio.saveOrUpdateUsuario(ObjectMapperUtils.map(usuario, Usuario.class));
            perfil.setUsuarioId(newUsuario.getUserId());
            perfilServicio.saveOrUpdatePerfil(perfil);
            return new ResponseEntity(newUsuario, HttpStatus.OK);
        }
        return new ResponseEntity(new RespuestaOKDTO("Usuario no existente"), HttpStatus.BAD_REQUEST);
    }

    @DeleteMapping(value = "/delete/{username}")
    public ResponseEntity<?> deleteUsuarioByUsername(@PathVariable String username) {
        Usuario usuario = usuarioServicio.findByUsername(username);
        Perfil perfil = perfilServicio.findByPerfilId(usuario.getPerfil());
        ListaPersonal listaPer = listaPersonalServicio.findByListaPersonalId(perfil.getListaPersonalId());
        
        if(listaPer.getElementosVistos()!=null && listaPer.getElementosVistos().length>0){
            for (ElementoEnlistado elementoVisto : listaPer.getElementosVistos()) {
                elementoEnlistadoServicio.deleteElementoEnlistadoByElementoEnlistadoId(elementoVisto.getElementoEnlistadoId());
            }
        }
        
        List<Grupo> grupos =grupoServicio.findAll();
        List<String> miembros;
        if(grupos!=null && !grupos.isEmpty()){
            for (Grupo grupo : grupos) {
                int i = 0;
                miembros = new LinkedList<>(Arrays.asList(grupo.getMiembros()));
                for (String miembro : miembros) {
                    if(miembro.equals(usuario.getUserId())){
                        if(grupo.getMiembros().length==1){
                            grupoServicio.deleteGrupoByGrupoId(grupo.getGrupoId());
                        }else{
                            miembros.remove(i);
                            String[] miembrosAAgregar= miembros.toArray(new String[miembros.size()]);
                            grupo.setMiembros(miembrosAAgregar);
                            grupoServicio.saveOrUpdateGrupo(grupo);
                        }
                    }
                    i++;
                }
            }
        }
        
        
        autenticacionServicio.deleteAutenticacionByAutenticacionId(usuario.getAutenticacion().getAutenticacionId());
        listaPersonalServicio.deleteListaPersonalByListaPersonalId(perfil.getListaPersonalId());
        perfilServicio.deletePerfilByPerfilId(usuario.getPerfil());
        usuarioServicio.deleteUsuarioByUsername(usuario.getUsername());
        return new ResponseEntity(new RespuestaOKDTO("Usuario Eliminado Correctamente"), HttpStatus.OK);
    }
    
    //Asigno puntuaciones en base a las coincidencias de cada usuario con otro sobre el que buscare,
    //denominado usuario central
    private List<String> obtenerUsuariosCercanos(Perfil perfilCentral){
        List<Perfil> listaPerfiles = this.perfilServicio.findAll();
        List<String> listaPerfilesId= new ArrayList<>();
        List<Float> listaPuntuaciones = new ArrayList<>();
        
        
        Collections.shuffle(listaPerfiles);
        float puntuacion = 0;
        
        //Estas variables determinan el peso de las coincidencias y el multiplicador que las ajusta
        //para dispersar puntuaciones o mantenerlas cercanas
        float pesoActor = 5;
        float pesoGenero = 10;
        float pesoElemento = 1;
        float multiplicador = 5;
        
        //Itero sobre todos los usuarios de la base de datos y busco coincidencias de gustos, en base a ello
        //asigno una puntuacion y obtengo una lista de puntuaciones con la cual puedo determinar los usuarios
        //mas cercanos al usuario central
        for(int i=0; i < listaPerfiles.size(); i++){
            
            //Verifico si no es el mismo usuario
            if(!perfilCentral.getPerfilId().equals(listaPerfiles.get(i).getPerfilId())){
                //Verifico  si tienen el mismo genero preferido
                if(listaPerfiles.get(i).getGeneroPreferido() != null && perfilCentral.getGeneroPreferido() != null){
                    if(listaPerfiles.get(i).getGeneroPreferido().equals(perfilCentral.getGeneroPreferido())){
                        puntuacion = puntuacion + (pesoGenero * multiplicador);
                    }
                }

                //Verifico  si comparten actores preferidos
                if(listaPerfiles.get(i).getActoresPreferidos() != null && perfilCentral.getActoresPreferidos() != null){
                        for (String actor : listaPerfiles.get(i).getActoresPreferidos()) {
                            for (String actorDeUsuarioCentral : perfilCentral.getActoresPreferidos()) {
                                if(actor.toUpperCase().equals(actorDeUsuarioCentral.toUpperCase())){
                                    puntuacion = puntuacion + (pesoActor * multiplicador);
                                }
                            }
                     }
                }

                //Verifico  si comparten peliculas o series vistas
                if(listaPerfiles.get(i).getListaPersonalId()!= null && perfilCentral.getListaPersonalId() != null){
                    ListaPersonal listaPersonal =this.listaPersonalServicio.
                            findByListaPersonalId(listaPerfiles.get(i).getListaPersonalId());
                    ListaPersonal listaPersonalCentral =this.listaPersonalServicio.
                            findByListaPersonalId(perfilCentral.getListaPersonalId());
                    
                    if(listaPersonal.getElementosVistos()!= null && listaPersonalCentral.getElementosVistos() != null &&
                            listaPersonal.getElementosVistos().length>0 && listaPersonalCentral.getElementosVistos().length>0){
                        for (ElementoEnlistado elementoVisto : listaPersonal.getElementosVistos()) {
                            for (ElementoEnlistado elementoVistoCentral : listaPersonalCentral.getElementosVistos()) {
                                if(elementoVisto.getElementoId().equals(elementoVistoCentral.getElementoId())){
                                    puntuacion = puntuacion + (pesoElemento * multiplicador);
                                }
                            }
                        }
                    }
                    
                }
                
                //Agrego a la lista de puntuaciones la nueva puntuacion y a la de perfiles el id del perfil en cuestion
                listaPuntuaciones.add(puntuacion);
                listaPerfilesId.add(listaPerfiles.get(i).getPerfilId());
            }
            
            
            puntuacion=0;
            
        }
        
        //invocar knn con k usuarios y traerse esa lista, en este caso es 3
        KNN knn = new KNN(3);
        
        List<String> usuariosRecomendados  = knn.usuariosMasCercanos(listaPuntuaciones, listaPerfilesId);
        
        return usuariosRecomendados;
    }
}
