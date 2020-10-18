package com.example.springMyStore.Controlador;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import com.example.springMyStore.Modelo.Cliente;
import com.example.springMyStore.Repositorio.ClienteRepository;
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
public class ClienteController {
    
    @Autowired
    private ClienteRepository clienteRepository;

    @GetMapping("Cliente")
    public List<Cliente> getAllCliete(){

        return clienteRepository.findAll();
    }

    @GetMapping("Cliente/{cli_id}")
    public ResponseEntity<Cliente> getClieteById(@PathVariable(value = "cli_id")Long cli_id)throws ResourceNotFoundException{

        Cliente cliente=clienteRepository.findById(cli_id).orElseThrow(()-> new ResourceNotFoundException("No se pudo encontrar al Cliente con el id:"+cli_id));
        return ResponseEntity.ok().body(cliente);
    }

    //Find by per_id
    @GetMapping("Cliente/per_id/{per_id}")
    public ResponseEntity<Cliente> getClieteByPerId(@PathVariable(value = "per_id")Long per_id) {

        Cliente cliente = clienteRepository.findByPerId(per_id);
        return ResponseEntity.ok().body(cliente);
    }

    //Find by Username and password
    @GetMapping("Cliente/{cli_usuario}/{cli_password}")
    public ResponseEntity<Cliente> getClienteByUserPass(@PathVariable(value = "cli_usuario") String cli_usuario, @PathVariable(value = "cli_password") String cli_password) {

        Cliente cliente = clienteRepository.findByUserPass(cli_usuario, cli_password);
        return ResponseEntity.ok().body(cliente);
    }


    @PostMapping("Cliente")

    public Cliente crearCliente(@Validated @RequestBody Cliente cliente){
        return clienteRepository.save(cliente);
    }

    @PutMapping("Cliente/{cli_id}")
    public ResponseEntity<Cliente> updateClienteById(@PathVariable(value = "cli_id")Long cli_id, @Validated @RequestBody Cliente cliente)throws ResourceNotFoundException{

        Cliente cliente2=clienteRepository.findById(cli_id).orElseThrow(()-> new ResourceNotFoundException("No se pudo encontrar al Cliente con el id:"+cli_id));
        cliente2.setCli_usuario(cliente.getCli_usuario());
        cliente2.setCli_password(cliente.getCli_password());
        cliente2.setCli_descuento(cliente.getCli_descuento());    
        final Cliente updateCliente=clienteRepository.save(cliente2);
        return ResponseEntity.ok(updateCliente);
    }

    @DeleteMapping("Cliente/{cli_id}")
    public Map<String, Boolean>deleteCliente(@PathVariable(value = "cli_id")Long cli_id)throws ResourceNotFoundException{

        Cliente cliente2=clienteRepository.findById(cli_id).orElseThrow(()-> new ResourceNotFoundException("No se pudo encontrar al Cliente con el id:"+cli_id));
       clienteRepository.delete(cliente2);
       Map<String, Boolean>response=new HashMap<>();
       return response; 
    }


}
