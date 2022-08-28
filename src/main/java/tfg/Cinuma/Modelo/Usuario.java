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
@Document(collection = "Usuario")
public class Usuario {
    @Id
    private String userId;
    private String username;
    private String email;
    private String phone;
    private Integer rol;
    private String perfil;
    private Autenticacion autenticacion;

    
    public Usuario() {
    }

    public Usuario(String userId, String username, String email, String phone) {
        this.userId = userId;
        this.username = username;
        this.email = email;
        this.phone = phone;
    }

    public Usuario(String userId, String username, String email) {
        this.userId = userId;
        this.username = username;
        this.email = email;
    }

    public Usuario(String userId, String username, String email, String phone, String perfil, Autenticacion autenticacion) {
        this.userId = userId;
        this.username = username;
        this.email = email;
        this.phone = phone;
        this.perfil = perfil;
        this.autenticacion = autenticacion;
    }

    public Usuario(String userId, String username, String email, String phone, Integer rol, String perfil, Autenticacion autenticacion) {
        this.userId = userId;
        this.username = username;
        this.email = email;
        this.phone = phone;
        this.rol = rol;
        this.perfil = perfil;
        this.autenticacion = autenticacion;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
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
    
    public String getPerfil() {
        return perfil;
    }

    public void setPerfil(String perfil) {
        this.perfil = perfil;
    }

    public Autenticacion getAutenticacion() {
        return autenticacion;
    }

    public void setAutenticacion(Autenticacion autenticacion) {
        this.autenticacion = autenticacion;
    }

    public Integer getRol() {
        return rol;
    }

    public void setRol(Integer rol) {
        this.rol = rol;
    }


    @Override
    public String toString() {
        return "Usuario{" + "userId=" + userId + ", username=" + username + ", email=" + email + ", phone=" + phone + '}';
    }
    
}
