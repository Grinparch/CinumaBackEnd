/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package tfg.Cinuma.Modelo;

import java.util.Date;
import org.bson.types.ObjectId;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

/**
 *
 * @author jsnie
 */
@Document(collection = "Articulo")
public class Articulo {
    @Id
    private String articuloId;
    private String titulo;
    private String contenido;
    private String tema;
    private String autor;
    private Date fechaCreacion;
    private String[] generosAsociados;
    private ObjectId[] titulosAsociados;

    public Articulo() {
    }

    public Articulo(String articuloId, String titulo, String contenido, String tema, 
            String autor, Date fechaCreacion, String[] generosAsociados, ObjectId[] titulosAsociados) {
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

    public ObjectId[] getTitulosAsociados() {
        return titulosAsociados;
    }

    public void setTitulosAsociados(ObjectId[] titulosAsociados) {
        this.titulosAsociados = titulosAsociados;
    }

    public String getArticuloId() {
        return articuloId;
    }

    public void setArticuloId(String articuloId) {
        this.articuloId = articuloId;
    }

    @Override
    public String toString() {
        return "Articulo{" + "titulo=" + titulo + ", contenido=" + contenido +
                ", tema=" + tema + ", autor=" + autor + ", fechaCreacion=" + fechaCreacion 
                + ", generosAsociados=" + generosAsociados + ", titulosAsociados=" + titulosAsociados + '}';
    }
    
    
}
