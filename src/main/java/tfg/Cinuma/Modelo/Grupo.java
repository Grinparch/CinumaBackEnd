/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package tfg.Cinuma.Modelo;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

/**
 *
 * @author jsnie
 */
@Document(collection = "Grupo")
public class Grupo {
    @Id
    private String grupoId;
    private String nombre;
    private String[] elementosPreferidos;
    private String[] miembros;
    private String descripcion;
    private String lider;

    public Grupo() {
    }

    public Grupo(String grupoId, String nombre, String[] elementosPreferidos, String[] miembros, String descripcion, String lider) {
        this.grupoId = grupoId;
        this.nombre = nombre;
        this.elementosPreferidos = elementosPreferidos;
        this.miembros = miembros;
        this.descripcion = descripcion;
        this.lider = lider;
    }

    public String getGrupoId() {
        return grupoId;
    }

    public void setGrupoId(String grupoId) {
        this.grupoId = grupoId;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String[] getElementosPreferidos() {
        return elementosPreferidos;
    }

    public void setElementosPreferidos(String[] elementosPreferidos) {
        this.elementosPreferidos = elementosPreferidos;
    }

    public String[] getMiembros() {
        return miembros;
    }

    public void setMiembros(String[] miembros) {
        this.miembros = miembros;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public String getLider() {
        return lider;
    }

    public void setLider(String lider) {
        this.lider = lider;
    }

    @Override
    public String toString() {
        return "Grupo{" + "nombre=" + nombre + ", elementosPreferidos=" + elementosPreferidos 
                + ", miembros=" + miembros + ", descripcion=" + descripcion + '}';
    }
    
    
}
