/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package tfg.Cinuma.dto;

import org.bson.types.ObjectId;
import tfg.Cinuma.Modelo.Usuario;

/**
 *
 * @author jsnie
 */
public class ChatDTO {
    private ObjectId chatId;
    private String mensaje;
    private UsuarioDTO[] miembros;
    private String[] generos;
    private String[] tags;

    public ChatDTO() {
    }

    public ChatDTO(ObjectId chatId, String mensaje, UsuarioDTO[] miembros, String[] generos, String[] tags) {
        this.chatId = chatId;
        this.mensaje = mensaje;
        this.miembros = miembros;
        this.generos = generos;
        this.tags = tags;
    }

    public ObjectId getChatId() {
        return chatId;
    }

    public void setChatId(ObjectId chatId) {
        this.chatId = chatId;
    }

    public String getMensaje() {
        return mensaje;
    }

    public void setMensaje(String mensaje) {
        this.mensaje = mensaje;
    }

    public UsuarioDTO[] getMiembros() {
        return miembros;
    }

    public void setMiembros(UsuarioDTO[] miembros) {
        this.miembros = miembros;
    }

    public String[] getGeneros() {
        return generos;
    }

    public void setGeneros(String[] generos) {
        this.generos = generos;
    }

    public String[] getTags() {
        return tags;
    }

    public void setTags(String[] tags) {
        this.tags = tags;
    }
}
