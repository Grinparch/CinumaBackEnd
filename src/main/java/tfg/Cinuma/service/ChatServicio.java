/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package tfg.Cinuma.service;

import java.util.List;
import tfg.Cinuma.Modelo.Chat;
import tfg.Cinuma.Modelo.Elemento;

/**
 *
 * @author jsnie
 */
public interface ChatServicio {
    List<Chat> findAll();
    
    Chat saveOrUpdateChat(Chat chat);
}
