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
    private ObjectId chatId;
    private String mensaje;
    private Usuario[] miembros;
    private String[] generos;
    private String[] tags;

    public Chat() {
    }

    public Chat(ObjectId chatId, String mensaje, Usuario[] miembros, String[] generos, String[] tags) {
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

    public Usuario[] getMiembros() {
        return miembros;
    }

    public void setMiembros(Usuario[] miembros) {
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
