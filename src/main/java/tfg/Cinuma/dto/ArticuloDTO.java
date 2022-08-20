/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package tfg.Cinuma.dto;

import java.util.Date;
import org.bson.types.ObjectId;
import tfg.Cinuma.Modelo.Elemento;

/**
 *
 * @author jsnie
 */
public class ArticuloDTO {
    private ObjectId articuloId;
    private String titulo;
    private String contenido;
    private String tema;
    private String autor;
    private Date fechaCreacion;
    private String[] generosAsociados;
    private ElementoDTO[] titulosAsociados;

    public ArticuloDTO() {
    }

    public ArticuloDTO(ObjectId articuloId, String titulo, String contenido, String tema, 
            String autor, Date fechaCreacion, String[] generosAsociados, ElementoDTO[] titulosAsociados) {
        this.articuloId = articuloId;
        this.titulo = titulo;
        this.contenido = contenido;
        this.tema = tema;
        this.autor = autor;
        this.fechaCreacion = fechaCreacion;
        this.generosAsociados = generosAsociados;
        this.titulosAsociados = titulosAsociados;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public String getContenido() {
        return contenido;
    }

    public void setContenido(String contenido) {
        this.contenido = contenido;
    }

    public String getTema() {
        return tema;
    }

    public void setTema(String tema) {
        this.tema = tema;
    }

    public String getAutor() {
        return autor;
    }

    public void setAutor(String autor) {
        this.autor = autor;
    }

    public Date getFechaCreacion() {
        return fechaCreacion;
    }

    public void setFechaCreacion(Date fechaCreacion) {
        this.fechaCreacion = fechaCreacion;
    }

    public String[] getGenerosAsociados() {
        return generosAsociados;
    }

    public void setGenerosAsociados(String[] generosAsociados) {
        this.generosAsociados = generosAsociados;
    }

    public ElementoDTO[] getTitulosAsociados() {
        return titulosAsociados;
    }

    public void setTitulosAsociados(ElementoDTO[] titulosAsociados) {
        this.titulosAsociados = titulosAsociados;
    }

    public ObjectId getArticuloId() {
        return articuloId;
    }

    public void setArticuloId(ObjectId articuloId) {
        this.articuloId = articuloId;
    }
}
