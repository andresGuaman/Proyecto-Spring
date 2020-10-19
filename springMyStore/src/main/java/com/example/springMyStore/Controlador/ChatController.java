package com.example.springMyStore.Controlador;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.transaction.Transactional;

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


    @GetMapping("Chat/all/{cli_id}/{emp_id}")
    public List<Chat> getAllChatsByCliEmpIds(@PathVariable(value = "cli_id") Long cli_id, @PathVariable(value = "emp_id") Long emp_id){
        return chatRepository.findAllChatsByCliEmpIds(cli_id, emp_id);
    }

    //GET BY CLI_ID AND EMP_ID
    @GetMapping("Chat/{cli_id}/{emp_id}")
    public ResponseEntity<Chat> getChatByCliEmpIds(@PathVariable(value = "cli_id") Long cli_id, @PathVariable(value = "emp_id") Long emp_id) {

        Chat chat = chatRepository.findChatByCliEmpIds(cli_id, emp_id);
        return ResponseEntity.ok().body(chat);
    }

    @PostMapping("Chat")
    public Chat createChat (@Validated @RequestBody Chat chat){

        return chatRepository.save(chat);
    }

    //New method post
    @Transactional
    @PostMapping("Chat/{cli_id}/{emp_id}")
    public Chat insertChat(@RequestBody Chat chat, @PathVariable(value = "cli_id") Long cli_id, @PathVariable(value = "emp_id") Long emp_id){

        long id;

        try {
            id = chatRepository.maxId();
        } catch (Exception e) {
            id = 0;
        }

        chatRepository.insertChat(id + 1, chat.getCha_imagenes(), chat.getCha_mensajes(), chat.getCha_rol_emisor(), cli_id, emp_id);

        return new Chat(1,"NA","NA","NA");
    }

    @PutMapping("Chat/{cha_id}")
    public ResponseEntity<Chat> updateChat(@PathVariable(value = "cha_id")Long cha_id, @Validated @RequestBody Chat chat) throws ResourceNotFoundException{
        
        Chat chat2= chatRepository.findById(cha_id).orElseThrow(()-> new ResourceNotFoundException("No se puede encontrar el chat con el id: "+cha_id));
        chat2.setCha_imagenes(chat.getCha_imagenes());
        chat2.setCha_mensajes(chat.getCha_mensajes());
        chat2.setCha_rol_emisor(chat.getCha_rol_emisor());
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
