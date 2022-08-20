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
public class AutenticacionDTO {
    private ObjectId autenticacionId;
    private String usuario;
    private String clave;

    public AutenticacionDTO() {
    }

    public AutenticacionDTO(ObjectId autenticacionId, String usuario, String clave) {
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
}
