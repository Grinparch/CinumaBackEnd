/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package tfg.Cinuma.Modelo;

import org.bson.types.ObjectId;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

/**
 *
 * @author jsnie
 */
@Document(collection = "Grupo")
public class Grupo {
    @Id
    private ObjectId grupoId;
    private String nombre;
    private Elemento[] elementosPreferidos;
    private String[][] elementosSinAprobar;
    private String miembros;
    private String descripcion;

    public Grupo() {
    }

    public Grupo(ObjectId grupoId, String nombre, Elemento[] elementosPreferidos, String[][] elementosSinAprobar, String miembros, String descripcion) {
        this.grupoId = grupoId;
        this.nombre = nombre;
        this.elementosPreferidos = elementosPreferidos;
        this.elementosSinAprobar = elementosSinAprobar;
        this.miembros = miembros;
        this.descripcion = descripcion;
    }

    public Grupo(ObjectId grupoId, String nombre, Elemento[] elementosPreferidos, String miembros, String descripcion) {
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

    public Elemento[] getElementosPreferidos() {
        return elementosPreferidos;
    }

    public void setElementosPreferidos(Elemento[] elementosPreferidos) {
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

    @Override
    public String toString() {
        return "Grupo{" + "nombre=" + nombre + ", elementosPreferidos=" + elementosPreferidos 
                + ", elementosSinAprobar=" + elementosSinAprobar + ", miembros=" + miembros 
                + ", descripcion=" + descripcion + '}';
    }
    
    
}
