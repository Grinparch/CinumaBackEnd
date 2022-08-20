/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package tfg.Cinuma.controller;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import tfg.Cinuma.Modelo.Chat;
import tfg.Cinuma.Modelo.Elemento;
import tfg.Cinuma.dto.ChatDTO;
import tfg.Cinuma.dto.ElementoDTO;
import tfg.Cinuma.service.ChatServicio;
import tfg.Cinuma.service.ElementoServicio;
import tfg.Cinuma.util.ObjectMapperUtils;

/**
 *
 * @author jsnie
 */
@RestController
@RequestMapping("/chat")
public class ChatControlador {
    
    @Autowired
    private ChatServicio chatServicio;
    
    @CrossOrigin(origins = "http://localhost:8100")
    @GetMapping(value = "/")
    public List<ChatDTO> obtenerTodosLosChats() {
        return ObjectMapperUtils.mapAll(chatServicio.findAll(), ChatDTO.class);
    }
    
    @CrossOrigin(origins = "http://localhost:8100")
    @PostMapping(value = "/add")
    public ResponseEntity<?> agregarElemento(@RequestBody ChatDTO chatDTO) {
        chatServicio.saveOrUpdateChat(ObjectMapperUtils.map(chatDTO, Chat.class));
        return new ResponseEntity("Chat agregado exitosamente", HttpStatus.OK);
    }
}
