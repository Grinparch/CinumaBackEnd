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
public class ComentarioDTO {
    private String comentarioId;
    private String articuloId;
    private String contenido;
    private String autorId;
    private String autor;
    private Date fechaCreacion;

    public ComentarioDTO(String comentarioId, String articuloId, String contenido, 
            String autorId, String autor, Date fechaCreacion) {
        this.comentarioId = comentarioId;
        this.articuloId = articuloId;
        this.contenido = contenido;
        this.autorId = autorId;
        this.autor = autor;
        this.fechaCreacion = fechaCreacion;
    }

    public ComentarioDTO() {
    }

    public String getComentarioId() {
        return comentarioId;
    }

    public void setComentarioId(String comentarioId) {
        this.comentarioId = comentarioId;
    }

    public String getArticuloId() {
        return articuloId;
    }

    public void setArticuloId(String articuloId) {
        this.articuloId = articuloId;
    }

    public String getContenido() {
        return contenido;
    }

    public void setContenido(String contenido) {
        this.contenido = contenido;
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
}
