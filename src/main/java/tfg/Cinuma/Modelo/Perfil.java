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
@Document(collection = "Perfil")
public class Perfil {
    @Id
    private ObjectId perfilId;
    private Elemento vistoUltimamente;
    private String generoPreferido;
    private Float puntuacionPromedio;
    private String[] actoresPreferidos;
    private String[] vinculosAsociados;
    private Boolean disponibleChat;
    private String avatar;
    private ListaPersonal listaPersonal;
    private Lista listasCreadas;

    public Perfil(ObjectId perfilId, Elemento vistoUltimamente, String generoPreferido, Float puntuacionPromedio, 
            String[] actoresPreferidos, String[] vinculosAsociados, Boolean disponibleChat, String avatar, 
            ListaPersonal listaPersonal, Lista listasCreadas) {
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

    public Perfil() {
    }

    public ObjectId getPerfilId() {
        return perfilId;
    }

    public void setPerfilId(ObjectId perfilId) {
        this.perfilId = perfilId;
    }

    public Elemento getVistoUltimamente() {
        return vistoUltimamente;
    }

    public void setVistoUltimamente(Elemento vistoUltimamente) {
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

    public ListaPersonal getListaPersonal() {
        return listaPersonal;
    }

    public void setListaPersonal(ListaPersonal listaPersonal) {
        this.listaPersonal = listaPersonal;
    }

    public Lista getListasCreadas() {
        return listasCreadas;
    }

    public void setListasCreadas(Lista listasCreadas) {
        this.listasCreadas = listasCreadas;
    }

    @Override
    public String toString() {
        return "Perfil{" + "perfilId=" + perfilId + ", vistoUltimamente=" + vistoUltimamente + 
                ", generoPreferido=" + generoPreferido + ", puntuacionPromedio=" + puntuacionPromedio 
                + ", actoresPreferidos=" + actoresPreferidos + ", vinculosAsociados=" 
                + vinculosAsociados + ", disponibleChat=" + disponibleChat + ", avatar=" 
                + avatar + ", listaPersonal=" + listaPersonal + ", listasCreadas=" + listasCreadas + '}';
    }

    
    
}
