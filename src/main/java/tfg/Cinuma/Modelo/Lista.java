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
@Document(collection = "Lista")
public class Lista {
    @Id
    private String listaId;
    private String perfilId;
    private Elemento[] elementos;
    private String creador;

    public Lista() {
    }

    public Lista(String listaId, String perfilId, Elemento[] elementos, String creador) {
        this.listaId = listaId;
        this.perfilId = perfilId;
        this.elementos = elementos;
        this.creador = creador;
    }

    public String getListaId() {
        return listaId;
    }

    public void setListaId(String listaId) {
        this.listaId = listaId;
    }

    public Elemento[] getElementos() {
        return elementos;
    }

    public void setElementos(Elemento[] elementos) {
        this.elementos = elementos;
    }

    public String getCreador() {
        return creador;
    }

    public void setCreador(String creador) {
        this.creador = creador;
    }

    public String getPerfilId() {
        return perfilId;
    }

    public void setPerfilId(String perfilId) {
        this.perfilId = perfilId;
    }

    @Override
    public String toString() {
        return "Lista{" + "elementos=" + elementos + ", creador=" + creador +'}';
    }
    
    
}
