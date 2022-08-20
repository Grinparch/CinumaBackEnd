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
@Document(collection = "Autenticacion")
public class Autenticacion {
    @Id
    private ObjectId autenticacionId;
    private String usuario;
    private String clave;

    public Autenticacion() {
    }

    public Autenticacion(ObjectId autenticacionId, String usuario, String clave) {
        this.autenticacionId = autenticacionId;
        this.usuario = usuario;
        this.clave = clave;
    }

    public ObjectId getAutenticacionId() {
        return autenticacionId;
    }

    public void setAutenticacionId(ObjectId autenticacionId) {
        this.autenticacionId = autenticacionId;
    }

    public String getUsuario() {
        return usuario;
    }

    public void setUsuario(String usuario) {
        this.usuario = usuario;
    }

    public String getClave() {
        return clave;
    }

    public void setClave(String clave) {
        this.clave = clave;
    }

    @Override
    public String toString() {
        return "Autenticacion{" + "autenticacionId=" + autenticacionId + 
                ", usuario=" + usuario + ", clave=" + clave + '}';
    }
    
    
}
