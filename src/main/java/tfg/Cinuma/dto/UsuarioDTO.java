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
public class UsuarioDTO {
    private ObjectId userId;
    private String username;
    private String email;
    private String phone;
    // Poner perfil

    public UsuarioDTO() {
    }
    
    public UsuarioDTO(ObjectId userId, String username, String email, String phone) {
        this.userId = userId;
        this.username = username;
        this.email = email;
        this.phone = phone;
    }

    public UsuarioDTO(ObjectId userId, String username, String email) {
        this.userId = userId;
        this.username = username;
        this.email = email;
    }

    public ObjectId getUserId() {
        return userId;
    }

    public void setUserId(ObjectId userId) {
        this.userId = userId;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

}
