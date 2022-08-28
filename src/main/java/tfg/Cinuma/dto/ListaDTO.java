/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package tfg.Cinuma.dto;


/**
 *
 * @author jsnie
 */
public class ListaDTO {
    private String listaId;
    private ElementoDTO[] elementos;
    private String creador;
    private Integer votos;

    public ListaDTO() {
    }

    public ListaDTO(String listaId, ElementoDTO[] elementos, String creador) {
        this.listaId = listaId;
        this.elementos = elementos;
        this.creador = creador;
    }

    public ListaDTO(String listaId, ElementoDTO[] elementos, String creador, Integer votos) {
        this.listaId = listaId;
        this.elementos = elementos;
        this.creador = creador;
        this.votos = votos;
    }

    public String getListaId() {
        return listaId;
    }

    public void setListaId(String listaId) {
        this.listaId = listaId;
    }

    public ElementoDTO[] getElementos() {
        return elementos;
    }

    public void setElementos(ElementoDTO[] elementos) {
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
}
