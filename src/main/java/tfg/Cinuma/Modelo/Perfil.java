/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package tfg.Cinuma.Modelo;

import java.util.Arrays;
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
    private String perfilId;
    private String usuarioId;
    private String vistoUltimamente;
    private String generoPreferido;
    private Float puntuacionPromedio;
    private String[] actoresPreferidos;
    private String[] vinculosAsociados;
    private String listaPersonalId;
    private String[] listasCreadas;

    public Perfil(String perfilId, String usuarioId, String vistoUltimamente, 
            String generoPreferido, Float puntuacionPromedio, String[] actoresPreferidos, 
            String[] vinculosAsociados, String listaPersonalId, String[] listasCreadas) {
        this.perfilId = perfilId;
        this.usuarioId = usuarioId;
        this.vistoUltimamente = vistoUltimamente;
        this.generoPreferido = generoPreferido;
        this.puntuacionPromedio = puntuacionPromedio;
        this.actoresPreferidos = actoresPreferidos;
        this.vinculosAsociados = vinculosAsociados;
        this.listaPersonalId = listaPersonalId;
        this.listasCreadas = listasCreadas;
    }

    public Perfil(String perfilId, String listaPersonalId) {
        String[] listaVacia = new String[0];
        this.perfilId = perfilId;
        this.actoresPreferidos = listaVacia;
        this.vinculosAsociados = listaVacia;
        this.listaPersonalId = listaPersonalId;
    }
    

    public Perfil(String perfilId, String listaPersonalId, String usuarioId) {
        String[] listaVacia = new String[0];
        this.perfilId = perfilId;
        this.actoresPreferidos = listaVacia;
        this.vinculosAsociados = listaVacia;
        this.listaPersonalId = listaPersonalId;
        this.usuarioId = usuarioId;
    }

    public Perfil() {
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

    public String getListaPersonalId() {
        return listaPersonalId;
    }

    public void setListaPersonalId(String listaPersonalId) {
        this.listaPersonalId = listaPersonalId;
    }

    public String[] getListasCreadas() {
        return listasCreadas;
    }

    public void setListasCreadas(String[] listasCreadas) {
        this.listasCreadas = listasCreadas;
    }

    public String getUsuarioId() {
        return usuarioId;
    }

    public void setUsuarioId(String usuarioId) {
        this.usuarioId = usuarioId;
    }
    

    @Override
    public String toString() {
        return "Perfil{" + "perfilId=" + perfilId + ", vistoUltimamente=" + vistoUltimamente + 
                ", generoPreferido=" + generoPreferido + ", puntuacionPromedio=" + puntuacionPromedio 
                + ", actoresPreferidos=" + Arrays.toString(actoresPreferidos) + ", vinculosAsociados=" 
                + Arrays.toString(vinculosAsociados) + ", listaPersonal=" +
                listaPersonalId + ", listasCreadas=" + Arrays.toString(listasCreadas) + '}';
    }

    
    
}
