/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package tfg.Cinuma.Modelo;

import java.util.Date;
import org.springframework.data.annotation.Id;

/**
 *
 * @author jsnie
 */
public class Mensaje {
    @Id
    private String mensajeId;
    private String autorId;
    private String autor;
    private String receptorId;
    private String receptor;
    private String contenido;
    private Date fechaDeCreacion;

    public Mensaje() {
    }

    public Mensaje(String mensajeId, String autorId, String autor, String receptorId, String receptor, String contenido, Date fechaDeCreacion) {
        this.mensajeId = mensajeId;
        this.autorId = autorId;
        this.autor = autor;
        this.receptorId = receptorId;
        this.receptor = receptor;
        this.contenido = contenido;
        this.fechaDeCreacion = fechaDeCreacion;
    }

    public String getMensajeId() {
        return mensajeId;
    }

    public void setMensajeId(String mensajeId) {
        this.mensajeId = mensajeId;
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

    public String getReceptorId() {
        return receptorId;
    }

    public void setReceptorId(String receptorId) {
        this.receptorId = receptorId;
    }

    public String getReceptor() {
        return receptor;
    }

    public void setReceptor(String receptor) {
        this.receptor = receptor;
    }

    public String getContenido() {
        return contenido;
    }

    public void setContenido(String contenido) {
        this.contenido = contenido;
    }

    public Date getFechaDeCreacion() {
        return fechaDeCreacion;
    }

    public void setFechaDeCreacion(Date fechaDeCreacion) {
        this.fechaDeCreacion = fechaDeCreacion;
    }

    @Override
    public String toString() {
        return "Mensaje{" + "mensajeId=" + mensajeId + ", autorId=" + autorId + 
                ", autor=" + autor + ", receptorId=" + receptorId + ", receptor=" 
                + receptor + ", contenido=" + contenido + ", fechaDeCreacion=" 
                + fechaDeCreacion + '}';
    }
    
    
}
