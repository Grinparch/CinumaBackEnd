/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package tfg.Cinuma.Modelo;

import java.util.Date;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import tfg.Cinuma.dto.ElementoEnlistadoDTO;

/**
 *
 * @author jsnie
 */
@Document(collection = "ElementoEnlistado")
public class ElementoEnlistado {
    @Id
    private String elementoEnlistadoId;
    private String elementoId;
    private String listaPersonalId;
    private String perfilId;
    private Float  puntuacionPersonal;
    private String opinion;
    private String titulo;
    private Float calificacionPromedio;
    private Float duracion;
    private String[] genero;
    private String idioma;
    private String director;
    private String[] actores;
    private Integer tipo; //0 es serie, 1 es pelicula
    private Integer capitulos;
    private Date estreno;
    private Date estrenoTaquilla;
    

    public ElementoEnlistado() {
    }
    
    private ElementoEnlistado(String elementoEnlistadoId,String listaPersonalId, String perfilId,
            String elementoId, String titulo, Float calificacionPromedio, 
            Float duracion, String[] genero, String idioma, 
            String director, String[] actores, Integer tipo,
            Integer capitulos, Date estreno) {
        this.elementoEnlistadoId = elementoEnlistadoId;
        this.listaPersonalId = listaPersonalId;
        this.perfilId = perfilId;
        this.elementoId = elementoId;
        this.titulo = titulo;
        this.calificacionPromedio = calificacionPromedio;
        this.duracion = duracion;
        this.genero = genero;
        this.idioma = idioma;
        this.director = director;
        this.actores = actores;
        this.tipo = tipo;
        this.capitulos = capitulos;
        this.estreno = estreno;
    }

    private ElementoEnlistado(String elementoEnlistadoId,String listaPersonalId, String perfilId,
            String elementoId, String titulo, Float calificacionPromedio, 
            Float duracion, String[] genero, String idioma, 
            String director, String[] actores, Integer tipo, Date estrenoTaquilla) {
        this.elementoEnlistadoId = elementoEnlistadoId;
        this.listaPersonalId = listaPersonalId;
        this.perfilId = perfilId;
        this.elementoId = elementoId;
        this.titulo = titulo;
        this.calificacionPromedio = calificacionPromedio;
        this.duracion = duracion;
        this.genero = genero;
        this.idioma = idioma;
        this.director = director;
        this.actores = actores;
        this.tipo = tipo;
        this.estrenoTaquilla = estrenoTaquilla;
    }
    
    private ElementoEnlistado(String elementoEnlistadoId,String listaPersonalId, String perfilId,
            String elementoId, String titulo, Float calificacionPromedio, 
            Float duracion, String[] genero, String idioma, 
            String director, String[] actores, Integer tipo,
            Integer capitulos, Date estreno, String opinion) {
        this.elementoEnlistadoId = elementoEnlistadoId;
        this.listaPersonalId = listaPersonalId;
        this.perfilId = perfilId;
        this.elementoId = elementoId;
        this.titulo = titulo;
        this.calificacionPromedio = calificacionPromedio;
        this.duracion = duracion;
        this.genero = genero;
        this.idioma = idioma;
        this.director = director;
        this.actores = actores;
        this.tipo = tipo;
        this.capitulos = capitulos;
        this.estreno = estreno;
        this.opinion = opinion;
    }

    private ElementoEnlistado(String elementoEnlistadoId,String listaPersonalId, String perfilId,
            String elementoId, String titulo, Float calificacionPromedio, 
            Float duracion, String[] genero, String idioma, String opinion,
            String director, String[] actores, Integer tipo, Date estrenoTaquilla) {
        this.elementoEnlistadoId = elementoEnlistadoId;
        this.listaPersonalId = listaPersonalId;
        this.perfilId = perfilId;
        this.elementoId = elementoId;
        this.titulo = titulo;
        this.calificacionPromedio = calificacionPromedio;
        this.duracion = duracion;
        this.genero = genero;
        this.idioma = idioma;
        this.director = director;
        this.actores = actores;
        this.tipo = tipo;
        this.estrenoTaquilla = estrenoTaquilla;
        this.opinion = opinion;
    }
    
    private ElementoEnlistado(String elementoEnlistadoId,String listaPersonalId, String perfilId,
            String elementoId, String titulo, Float calificacionPromedio, 
            Float duracion, String[] genero, String idioma, 
            String director, String[] actores, Integer tipo,
            Integer capitulos, Date estreno, Float calificacion) {
        this.elementoEnlistadoId = elementoEnlistadoId;
        this.listaPersonalId = listaPersonalId;
        this.perfilId = perfilId;
        this.elementoId = elementoId;
        this.titulo = titulo;
        this.calificacionPromedio = calificacionPromedio;
        this.duracion = duracion;
        this.genero = genero;
        this.idioma = idioma;
        this.director = director;
        this.actores = actores;
        this.tipo = tipo;
        this.capitulos = capitulos;
        this.estreno = estreno;
        this.puntuacionPersonal = calificacion;
    }

    private ElementoEnlistado(String elementoEnlistadoId,String listaPersonalId, String perfilId,
            String elementoId, String titulo, Float calificacionPromedio, 
            Float duracion, String[] genero, String idioma, Float calificacion,
            String director, String[] actores, Integer tipo, Date estrenoTaquilla) {
        this.elementoEnlistadoId = elementoEnlistadoId;
        this.listaPersonalId = listaPersonalId;
        this.perfilId = perfilId;
        this.elementoId = elementoId;
        this.titulo = titulo;
        this.calificacionPromedio = calificacionPromedio;
        this.duracion = duracion;
        this.genero = genero;
        this.idioma = idioma;
        this.director = director;
        this.actores = actores;
        this.tipo = tipo;
        this.estrenoTaquilla = estrenoTaquilla;
        this.puntuacionPersonal = calificacion;
    }
    
    private ElementoEnlistado(String elementoEnlistadoId,String listaPersonalId, String perfilId,
            String elementoId, String titulo, Float calificacionPromedio, 
            Float duracion, String[] genero, String idioma, Float calificacion, String opinion,
            String director, String[] actores, Integer tipo,
            Integer capitulos, Date estreno) {
        this.elementoEnlistadoId = elementoEnlistadoId;
        this.listaPersonalId = listaPersonalId;
        this.perfilId = perfilId;
        this.elementoId = elementoId;
        this.titulo = titulo;
        this.calificacionPromedio = calificacionPromedio;
        this.duracion = duracion;
        this.genero = genero;
        this.idioma = idioma;
        this.director = director;
        this.actores = actores;
        this.tipo = tipo;
        this.capitulos = capitulos;
        this.estreno = estreno;
        this.puntuacionPersonal = calificacion;
        this.opinion = opinion;
    }

    private ElementoEnlistado(String elementoEnlistadoId,String listaPersonalId, String perfilId,
            String elementoId, String titulo, Float calificacionPromedio, 
            Float duracion, String[] genero, String idioma,  Float calificacion, String opinion,
            String director, String[] actores, Integer tipo, Date estrenoTaquilla) {
        this.elementoEnlistadoId = elementoEnlistadoId;
        this.listaPersonalId = listaPersonalId;
        this.perfilId = perfilId;
        this.elementoId = elementoId;
        this.titulo = titulo;
        this.calificacionPromedio = calificacionPromedio;
        this.duracion = duracion;
        this.genero = genero;
        this.idioma = idioma;
        this.director = director;
        this.actores = actores;
        this.tipo = tipo;
        this.estrenoTaquilla = estrenoTaquilla;
        this.puntuacionPersonal = calificacion;
        this.opinion = opinion;
    }

    public String getElementoEnlistadoId() {
        return elementoEnlistadoId;
    }

    public void setElementoEnlistadoId(String elementoEnlistadoId) {
        this.elementoEnlistadoId = elementoEnlistadoId;
    }

    public String getElementoId() {
        return elementoId;
    }

    public void setElementoId(String elementoId) {
        this.elementoId = elementoId;
    }

    public String getListaPersonalId() {
        return listaPersonalId;
    }

    public void setListaPersonalId(String listaPersonalId) {
        this.listaPersonalId = listaPersonalId;
    }

    public Float getPuntuacionPersonal() {
        return puntuacionPersonal;
    }

    public void setPuntuacionPersonal(Float puntuacionPersonal) {
        this.puntuacionPersonal = puntuacionPersonal;
    }

    public String getOpinion() {
        return opinion;
    }

    public void setOpinion(String opinion) {
        this.opinion = opinion;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public Float getCalificacionPromedio() {
        return calificacionPromedio;
    }

    public void setCalificacionPromedio(Float calificacionPromedio) {
        this.calificacionPromedio = calificacionPromedio;
    }

    public Float getDuracion() {
        return duracion;
    }

    public void setDuracion(Float duracion) {
        this.duracion = duracion;
    }

    public String[] getGenero() {
        return genero;
    }

    public void setGenero(String[] genero) {
        this.genero = genero;
    }

    public String getIdioma() {
        return idioma;
    }

    public void setIdioma(String idioma) {
        this.idioma = idioma;
    }

    public String getDirector() {
        return director;
    }

    public void setDirector(String director) {
        this.director = director;
    }

    public String[] getActores() {
        return actores;
    }

    public void setActores(String[] actores) {
        this.actores = actores;
    }

    public Integer getTipo() {
        return tipo;
    }

    public void setTipo(Integer tipo) {
        this.tipo = tipo;
    }

    public Integer getCapitulos() {
        return capitulos;
    }

    public void setCapitulos(Integer capitulos) {
        this.capitulos = capitulos;
    }

    public Date getEstreno() {
        return estreno;
    }

    public void setEstreno(Date estreno) {
        this.estreno = estreno;
    }

    public Date getEstrenoTaquilla() {
        return estrenoTaquilla;
    }

    public void setEstrenoTaquilla(Date estrenoTaquilla) {
        this.estrenoTaquilla = estrenoTaquilla;
    }

    public String getPerfilId() {
        return perfilId;
    }

    public void setPerfilId(String perfilId) {
        this.perfilId = perfilId;
    }
    
    public ElementoEnlistado transformadorDTO(ElementoEnlistadoDTO elementoEnlistadoDTO){
        ElementoEnlistado elementoEnlistado = new ElementoEnlistado();
        
        elementoEnlistado.setElementoEnlistadoId(elementoEnlistadoDTO.getElementoEnlistadoId());
        elementoEnlistado.setElementoId(elementoEnlistadoDTO.getElementoId());
        elementoEnlistado.setListaPersonalId(elementoEnlistadoDTO.getListaPersonalId());
        elementoEnlistado.setPuntuacionPersonal(elementoEnlistadoDTO.getPuntuacionPersonal());
        elementoEnlistado.setOpinion(elementoEnlistadoDTO.getOpinion());
        elementoEnlistado.setTitulo(elementoEnlistadoDTO.getTitulo());
        elementoEnlistado.setCalificacionPromedio(elementoEnlistadoDTO.getCalificacionPromedio());
        elementoEnlistado.setDuracion(elementoEnlistadoDTO.getDuracion());
        elementoEnlistado.setGenero(elementoEnlistadoDTO.getGenero());
        elementoEnlistado.setIdioma(elementoEnlistadoDTO.getIdioma());
        elementoEnlistado.setDirector(elementoEnlistadoDTO.getDirector());
        elementoEnlistado.setActores(elementoEnlistadoDTO.getActores());
        elementoEnlistado.setTipo(elementoEnlistadoDTO.getTipo());
        elementoEnlistado.setCapitulos(elementoEnlistadoDTO.getCapitulos());
        elementoEnlistado.setEstreno(elementoEnlistadoDTO.getEstreno());
        elementoEnlistado.setEstrenoTaquilla(elementoEnlistadoDTO.getEstrenoTaquilla());
        
        return elementoEnlistado;
    }

    @Override
    public String toString() {
        return "ElementoEnlistado{" + "elementoEnlistadoId=" + elementoEnlistadoId + 
                ", elementoId=" + elementoId + ", listaPersonalId=" + listaPersonalId + 
                ", puntuacionPersonal=" + puntuacionPersonal + ", opinion=" + opinion + 
                ", titulo=" + titulo + ", calificacionPromedio=" + calificacionPromedio 
                + ", duracion=" + duracion + ", genero=" + genero + ", idioma=" 
                + idioma + ", director=" + director + ", actores=" + actores + 
                ", tipo=" + tipo + ", capitulos=" + capitulos + ", estreno=" + estreno 
                + ", estrenoTaquilla=" + estrenoTaquilla + '}';
    }


    
    
}
