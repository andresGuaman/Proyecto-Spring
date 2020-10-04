package com.example.springMyStore.Controlador;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.example.springMyStore.Modelo.Persona;
import com.example.springMyStore.Repositorio.PersonaRepository;

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
@RequestMapping("/api/v1")
@CrossOrigin(origins = "http://localhost:4200")
public class PersonaController {
    
    @Autowired
    private PersonaRepository personaRepository;

    @GetMapping("/Persona")
public List<Persona>getAllPersona(){
    return personaRepository.findAll();
}

@GetMapping("/Persona/{per_id}")
public ResponseEntity<Persona>getPersonaByID(@PathVariable(value = "per_id")Long per_id)throws ResourceNotFoundException{
    Persona persona=personaRepository.findById(per_id).orElseThrow(()->new ResourceNotFoundException("No se encontro a la persona con el id:"+per_id));
    return ResponseEntity.ok().body(persona);
}

@PostMapping("/Persona")
public Persona createPersona(@Validated @RequestBody Persona persona){
    return personaRepository.save(persona);
}

@PutMapping("/Persona/{per_id}")
public ResponseEntity<Persona>updatePersona(@PathVariable(value = "per_id")Long per_id, @Validated @RequestBody Persona persona)throws ResourceNotFoundException{
    Persona persona2=personaRepository.findById(per_id).orElseThrow(()->new ResourceNotFoundException("No se encontro a la persona con el id:"+per_id));
    persona2.setPer_apellido(persona.getPer_apellido());
    persona2.setPer_cedula(persona.getPer_cedula());
    persona2.setPer_correo(persona.getPer_correo());
    persona2.setPer_estado(persona.getPer_estado());
    persona2.setPer_fecha_creacion(persona.getPer_fecha_creacion());
    persona2.setPer_foto(persona.getPer_foto());
    persona2.setPer_nombre(persona.getPer_nombre());
    persona2.setPer_telefono(persona.getPer_telefono());
    final Persona updatePersona=personaRepository.save(persona2);
    return ResponseEntity.ok(updatePersona);
}

@DeleteMapping("/Persona/{per_id}")
public Map<String, Boolean>deletePersona(@PathVariable(value = "per_id")Long per_id)throws ResourceNotFoundException{
    Persona persona2=personaRepository.findById(per_id).orElseThrow(()->new ResourceNotFoundException("No se encontro a la persona con el id:"+per_id));
    personaRepository.delete(persona2);
    Map<String, Boolean>response=new HashMap<>();
    response.put("deleted", Boolean.TRUE);
    return response;
 }

}
