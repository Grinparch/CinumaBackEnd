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
@Document(collection = "Lista")
public class Lista {
    @Id
    private ObjectId listaId;
    private Elemento[] elementos;
    private String creador;
    private Integer votos;

    public Lista() {
    }

    public Lista(ObjectId listaId, Elemento[] elementos, String creador) {
        this.listaId = listaId;
        this.elementos = elementos;
        this.creador = creador;
    }

    public Lista(ObjectId listaId, Elemento[] elementos, String creador, Integer votos) {
        this.listaId = listaId;
        this.elementos = elementos;
        this.creador = creador;
        this.votos = votos;
    }

    public ObjectId getListaId() {
        return listaId;
    }

    public void setListaId(ObjectId listaId) {
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

    public Integer getVotos() {
        return votos;
    }

    public void setVotos(Integer votos) {
        this.votos = votos;
    }

    @Override
    public String toString() {
        return "Lista{" + "elementos=" + elementos + ", creador=" + creador + 
                ", votos=" + votos + '}';
    }
    
    
}
