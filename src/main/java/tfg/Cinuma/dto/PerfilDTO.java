/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package tfg.Cinuma.dto;


/**
 *
 * @author jsnie
 */
public class PerfilDTO {
    private String perfilId;
    private String vistoUltimamente;
    private String generoPreferido;
    private Float puntuacionPromedio;
    private String[] actoresPreferidos;
    private String[] vinculosAsociados;
    private Boolean disponibleChat;
    private String avatar;
    private ListaPersonalDTO listaPersonal;
    private ListaDTO listasCreadas;

    public PerfilDTO(String perfilId, String vistoUltimamente, String generoPreferido, Float puntuacionPromedio, 
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

    public PerfilDTO(String perfilId, Boolean disponibleChat, ListaPersonalDTO listaPersonal) {
        String[] listaVacia = new String[0];
        this.perfilId = perfilId;
        this.actoresPreferidos = listaVacia;
        this.vinculosAsociados = listaVacia;
        this.disponibleChat = disponibleChat;
        this.listaPersonal = listaPersonal;
    }

    public PerfilDTO() {
    }

    public String getPerfilId() {
        return perfilId;
    }

    public void setPerfilId(String perfilId) {
        this.perfilId = perfilId;
    }

    public String getVistoUltimamente() {
        return vistoUltimamente;
    }

    public void setVistoUltimamente(String vistoUltimamente) {
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
