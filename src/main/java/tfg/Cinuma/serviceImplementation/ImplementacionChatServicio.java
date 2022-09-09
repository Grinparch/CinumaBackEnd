/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package tfg.Cinuma.serviceImplementation;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import tfg.Cinuma.Modelo.Chat;
import tfg.Cinuma.repository.ChatRepository;
import tfg.Cinuma.repository.ElementoRepository;
import tfg.Cinuma.service.ChatServicio;

/**
 *
 * @author jsnie
 */
@Service
public class ImplementacionChatServicio implements ChatServicio{
    
    @Autowired
    private ChatRepository chatRepository;

    @Override
    public List<Chat> findAll() {
        return chatRepository.findAll();
    }

    @Override
    public Chat saveOrUpdateChat(Chat chat) {
        return chatRepository.save(chat);
    }
    
}
