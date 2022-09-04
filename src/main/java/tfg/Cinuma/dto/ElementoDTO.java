/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package tfg.Cinuma.dto;

import java.util.Date;

/**
 *
 * @author jsnie
 */
public class ElementoDTO {
    private String elementoId;
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

    public ElementoDTO(String elementoId, String titulo, Float calificacionPromedio,
            Float duracion, String[] genero, String idioma, String director, String[] actores, Integer tipo) {
        this.elementoId = elementoId;
        this.titulo = titulo;
        this.calificacionPromedio = calificacionPromedio;
        this.duracion = duracion;
        this.genero = genero;
        this.idioma = idioma;
        this.director = director;
        this.actores = actores;
        this.tipo = tipo;
    }

    private ElementoDTO(String elementoId, String titulo, Float calificacionPromedio, 
            Float duracion, String[] genero, String idioma, 
            String director, String[] actores,  Integer tipo,
            Integer capitulos, Date estreno) {
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

    private ElementoDTO(String elementoId, String titulo, Float calificacionPromedio, 
            Float duracion, String[] genero, String idioma, 
            String director, String[] actores, Integer tipo, Date estrenoTaquilla) {
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
    
    public ElementoDTO createPelicula(String elementoId, String titulo, Float calificacionPromedio, 
            Float duracion, String[] genero, String idioma, 
            String director, String[] actores, Integer tipo, Date estrenoTaquilla){
        
        return new ElementoDTO(elementoId, titulo, calificacionPromedio, duracion, 
                genero, idioma, director, actores, tipo, estrenoTaquilla);
    }
    
    public ElementoDTO createSerie(String elementoId, String titulo, Float calificacionPromedio, 
            Float duracion, String[] genero, String idioma, 
            String director, String[] actores, Integer tipo, Integer capitulos, Date estreno){
        
        return new ElementoDTO(elementoId, titulo, calificacionPromedio, duracion, 
                genero, idioma, director, actores, tipo, capitulos, estreno);
    }

    public ElementoDTO() {
    }

    public String getElementoId() {
        return elementoId;
    }

    public void setElementoId(String elementoId) {
        this.elementoId = elementoId;
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
}
