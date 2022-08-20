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
public class PerfilDTO {
    private ObjectId perfilId;
    private ElementoDTO vistoUltimamente;
    private String generoPreferido;
    private Float puntuacionPromedio;
    private String[] actoresPreferidos;
    private String[] vinculosAsociados;
    private Boolean disponibleChat;
    private String avatar;
    private ListaPersonalDTO listaPersonal;
    private ListaDTO listasCreadas;

    public PerfilDTO(ObjectId perfilId, ElementoDTO vistoUltimamente, String generoPreferido, Float puntuacionPromedio, 
            String[] actoresPreferidos, String[] vinculosAsociados, Boolean disponibleChat, String avatar, 
            ListaPersonalDTO listaPersonal, ListaDTO listasCreadas) {
        this.perfilId = perfilId;
        this.vistoUltimamente = vistoUltimamente;
        this.generoPreferido = generoPreferido;
        this.puntuacionPromedio = puntuacionPromedio;
        this.actoresPreferidos = actoresPreferidos;
        this.vinculosAsociados = vinculosAsociados;
        this.disponibleChat = disponibleChat;
        this.avatar = avatar;
        this.listaPersonal = listaPersonal;
        this.listasCreadas = listasCreadas;
    }

    public PerfilDTO() {
    }

    public ObjectId getPerfilId() {
        return perfilId;
    }

    public void setPerfilId(ObjectId perfilId) {
        this.perfilId = perfilId;
    }

    public ElementoDTO getVistoUltimamente() {
        return vistoUltimamente;
    }

    public void setVistoUltimamente(ElementoDTO vistoUltimamente) {
        this.vistoUltimamente = vistoUltimamente;
    }

    public String getGeneroPreferido() {
        return generoPreferido;
    }

    public void setGeneroPreferido(String generoPreferido) {
        this.generoPreferido = generoPreferido;
    }

    public Float getPuntuacionPromedio() {
        return puntuacionPromedio;
    }

    public void setPuntuacionPromedio(Float puntuacionPromedio) {
        this.puntuacionPromedio = puntuacionPromedio;
    }

    public String[] getActoresPreferidos() {
        return actoresPreferidos;
    }

    public void setActoresPreferidos(String[] actoresPreferidos) {
        this.actoresPreferidos = actoresPreferidos;
    }

    public String[] getVinculosAsociados() {
        return vinculosAsociados;
    }

    public void setVinculosAsociados(String[] vinculosAsociados) {
        this.vinculosAsociados = vinculosAsociados;
    }

    public Boolean getDisponibleChat() {
        return disponibleChat;
    }

    public void setDisponibleChat(Boolean disponibleChat) {
        this.disponibleChat = disponibleChat;
    }

    public String getAvatar() {
        return avatar;
    }

    public void setAvatar(String avatar) {
        this.avatar = avatar;
    }

    public ListaPersonalDTO getListaPersonal() {
        return listaPersonal;
    }

    public void setListaPersonal(ListaPersonalDTO listaPersonal) {
        this.listaPersonal = listaPersonal;
    }

    public ListaDTO getListasCreadas() {
        return listasCreadas;
    }

    public void setListasCreadas(ListaDTO listasCreadas) {
        this.listasCreadas = listasCreadas;
    }
}
