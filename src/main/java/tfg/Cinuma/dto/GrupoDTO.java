/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package tfg.Cinuma.dto;

import org.bson.types.ObjectId;

/**
 *
 * @author jsnie
 */
public class GrupoDTO {
    private ObjectId grupoId;
    private String nombre;
    private ElementoDTO[] elementosPreferidos;
    private String[][] elementosSinAprobar;
    private String miembros;
    private String descripcion;

    public GrupoDTO() {
    }

    public GrupoDTO(ObjectId grupoId, String nombre, ElementoDTO[] elementosPreferidos, String[][] elementosSinAprobar, String miembros, String descripcion) {
        this.grupoId = grupoId;
        this.nombre = nombre;
        this.elementosPreferidos = elementosPreferidos;
        this.elementosSinAprobar = elementosSinAprobar;
        this.miembros = miembros;
        this.descripcion = descripcion;
    }

    public GrupoDTO(ObjectId grupoId, String nombre, ElementoDTO[] elementosPreferidos, String miembros, String descripcion) {
        this.grupoId = grupoId;
        this.nombre = nombre;
        this.elementosPreferidos = elementosPreferidos;
        this.miembros = miembros;
        this.descripcion = descripcion;
    }

    public ObjectId getGrupoId() {
        return grupoId;
    }

    public void setGrupoId(ObjectId grupoId) {
        this.grupoId = grupoId;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public ElementoDTO[] getElementosPreferidos() {
        return elementosPreferidos;
    }

    public void setElementosPreferidos(ElementoDTO[] elementosPreferidos) {
        this.elementosPreferidos = elementosPreferidos;
    }

    public String[][] getElementosSinAprobar() {
        return elementosSinAprobar;
    }

    public void setElementosSinAprobar(String[][] elementosSinAprobar) {
        this.elementosSinAprobar = elementosSinAprobar;
    }

    public String getMiembros() {
        return miembros;
    }

    public void setMiembros(String miembros) {
        this.miembros = miembros;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }
}
