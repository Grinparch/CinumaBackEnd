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
@Document(collection = "ListaPersonal")
public class ListaPersonal {
    @Id
    private String listaPersonalId;
    Elemento[] elementosVistos;

    public ListaPersonal() {
    }

    public ListaPersonal(String listaPersonalId, Elemento[] elementosVistos) {
        this.listaPersonalId = listaPersonalId;
        this.elementosVistos = elementosVistos;
    }

    public String getListaPersonalId() {
        return listaPersonalId;
    }

    public void setListaPersonalId(String listaPersonalId) {
        this.listaPersonalId = listaPersonalId;
    }

    public Elemento[] getElementosVistos() {
        return elementosVistos;
    }

    public void setElementosVistos(Elemento[] elementosVistos) {
        this.elementosVistos = elementosVistos;
    }

    @Override
    public String toString() {
        return "ListaPersonal{" + "elementosVistos=" + elementosVistos + '}';
    }
}
