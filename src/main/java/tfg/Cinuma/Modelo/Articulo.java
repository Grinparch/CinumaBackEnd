/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package tfg.Cinuma.Modelo;

import java.util.Date;
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
    private String autorId;
    private String autor;
    private Date fechaCreacion;
    private String[] generosAsociados;
    private String tituloAsociado;

    public Articulo() {
    }

    public Articulo(String articuloId, String titulo, String contenido, String tema, 
            String autorId, String autor, Date fechaCreacion, String[] generosAsociados, 
            String tituloAsociado) {
        this.articuloId = articuloId;
        this.titulo = titulo;
        this.contenido = contenido;
        this.tema = tema;
        this.autorId = autorId;
        this.autor = autor;
        this.fechaCreacion = fechaCreacion;
        this.generosAsociados = generosAsociados;
        this.tituloAsociado = tituloAsociado;
    }

    public String getArticuloId() {
        return articuloId;
    }

    public void setArticuloId(String articuloId) {
        this.articuloId = articuloId;
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

    public String getAutorId() {
        return autorId;
    }

    public void setAutorId(String autorId) {
        this.autorId = autorId;
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

    public String getTituloAsociado() {
        return tituloAsociado;
    }

    public void setTituloAsociado(String tituloAsociado) {
        this.tituloAsociado = tituloAsociado;
    }

    @Override
    public String toString() {
        return "Articulo{" + "articuloId=" + articuloId + ", titulo=" + titulo +
                ", contenido=" + contenido + ", tema=" + tema + ", autorId=" +
                autorId + ", autor=" + autor + ", fechaCreacion=" + fechaCreacion 
                + ", generosAsociados=" + generosAsociados + ", tituloAsociado=" 
                + tituloAsociado + '}';
    }
    
    
}
