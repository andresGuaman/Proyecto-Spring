package com.example.springMyStore.Controlador;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.example.springMyStore.Modelo.Chat;
import com.example.springMyStore.Repositorio.ChatRepository;

import org.apache.velocity.exception.ResourceNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@Controller
@RestController
@RequestMapping("/")
@CrossOrigin(origins = "http://localhost:4200")
public class ChatController {
    
    @Autowired
    private ChatRepository chatRepository;

    @GetMapping("Chat")
    public List<Chat> getAllChat(){
        return chatRepository.findAll();
    }

    @GetMapping("Chat/{cha_id}")
    public ResponseEntity<Chat> getChatById(@PathVariable(value = "cha_id")Long cha_id)throws ResourceNotFoundException {
      Chat chat=chatRepository.findById(cha_id).orElseThrow(()-> new ResourceNotFoundException("No se a podido encontrara el chat por el id:"+cha_id));
        return ResponseEntity.ok().body(chat);
    }

    @PostMapping("Chat")
    public Chat createChat (@Validated @RequestBody Chat chat){
        return chatRepository.save(chat);
    }

    @PutMapping("Chat/{cha_id}")
    public ResponseEntity<Chat> updateChat(@PathVariable(value = "cha_id")Long cha_id, @Validated @RequestBody Chat chat) throws ResourceNotFoundException{
        Chat chat2= chatRepository.findById(cha_id).orElseThrow(()-> new ResourceNotFoundException("No se puede encontrar el chat con el id: "+cha_id));
        chat2.setCha_imagenes(chat.getCha_imagenes());
        chat2.setCha_mensajes(chat.getCha_mensajes());
        final Chat updateChat = chatRepository.save(chat2);
        return ResponseEntity.ok(updateChat);
    }

    @DeleteMapping("Chat/{cha_id}")
    public Map<String, Boolean> deleteChat(@PathVariable(value = "cha_id")Long cha_id)throws ResourceNotFoundException{
      Chat chat2=chatRepository.findById(cha_id).orElseThrow(()-> new ResourceNotFoundException("No se puede encontrar el chat con el id: "+cha_id));
      chatRepository.delete(chat2);
      Map<String, Boolean>response= new HashMap<>();
      response.put("deleted", Boolean.TRUE);
      return response;
    }
    
}
