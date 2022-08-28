/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package tfg.Cinuma.dto;


/**
 *
 * @author jsnie
 */
public class AutenticacionDTO {
    private String autenticacionId;
    private String usuario;
    private String clave;

    public AutenticacionDTO() {
    }

    public AutenticacionDTO(String autenticacionId, String usuario, String clave) {
        this.autenticacionId = autenticacionId;
        this.usuario = usuario;
        this.clave = clave;
    }

    public String getAutenticacionId() {
        return autenticacionId;
    }

    public void setAutenticacionId(String autenticacionId) {
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
