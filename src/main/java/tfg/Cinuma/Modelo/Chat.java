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
@Document(collection = "Chat")
public class Chat {
    @Id
    private String chatId;
    private String mensaje;
    private String[] miembros;
    private String[] generos;
    private String[] tags;

    public Chat() {
    }

    public Chat(String chatId, String mensaje, String[] miembros, String[] generos, String[] tags) {
        this.chatId = chatId;
        this.mensaje = mensaje;
        this.miembros = miembros;
        this.generos = generos;
        this.tags = tags;
    }

    public String getChatId() {
        return chatId;
    }

    public void setChatId(String chatId) {
        this.chatId = chatId;
    }

    public String getMensaje() {
        return mensaje;
    }

    public void setMensaje(String mensaje) {
        this.mensaje = mensaje;
    }

    public String[] getMiembros() {
        return miembros;
    }

    public void setMiembros(String[] miembros) {
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

    @Override
    public String toString() {
        return "Chat{" + "mensaje=" + mensaje + ", miembros=" + miembros + 
                ", generos=" + generos + ", tags=" + tags + '}';
    }
    
    
}
