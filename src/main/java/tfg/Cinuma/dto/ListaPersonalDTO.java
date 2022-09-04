/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package tfg.Cinuma.dto;


/**
 *
 * @author jsnie
 */
public class ListaPersonalDTO {
    private String listaPersonalId;
    ElementoEnlistadoDTO[] elementosVistos;

    public ListaPersonalDTO() {
    }

    public ListaPersonalDTO(String listaPersonalId, ElementoEnlistadoDTO[] elementosVistos) {
        this.listaPersonalId = listaPersonalId;
        this.elementosVistos = elementosVistos;
    }

    public String getListaPersonalId() {
        return listaPersonalId;
    }

    public void setListaPersonalId(String listaPersonalId) {
        this.listaPersonalId = listaPersonalId;
    }

    public ElementoEnlistadoDTO[] getElementosVistos() {
        return elementosVistos;
    }

    public void setElementosVistos(ElementoEnlistadoDTO[] elementosVistos) {
        this.elementosVistos = elementosVistos;
    }
}
