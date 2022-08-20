/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package tfg.Cinuma.dto;

import org.bson.types.ObjectId;
import tfg.Cinuma.Modelo.Elemento;

/**
 *
 * @author jsnie
 */
public class ListaPersonalDTO {
    private ObjectId listaPersonalId;
    ElementoDTO[] elementosVistos;

    public ListaPersonalDTO() {
    }

    public ListaPersonalDTO(ObjectId listaPersonalId, ElementoDTO[] elementosVistos) {
        this.listaPersonalId = listaPersonalId;
        this.elementosVistos = elementosVistos;
    }

    public ObjectId getListaPersonalId() {
        return listaPersonalId;
    }

    public void setListaPersonalId(ObjectId listaPersonalId) {
        this.listaPersonalId = listaPersonalId;
    }

    public ElementoDTO[] getElementosVistos() {
        return elementosVistos;
    }

    public void setElementosVistos(ElementoDTO[] elementosVistos) {
        this.elementosVistos = elementosVistos;
    }
}
