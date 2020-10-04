package com.example.springMyStore.Controlador;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.example.springMyStore.Modelo.Direccion;
import com.example.springMyStore.Repositorio.DireccionRepository;

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
public class DireccionController {
    
    @Autowired
    private DireccionRepository direccionRepository;

    @GetMapping("/Direccion")
    public List<Direccion> getAllDireccion(){
    return direccionRepository.findAll();
    }

    @GetMapping("/Direccion/{dir_id}")
    public ResponseEntity<Direccion> getDireccionById(@PathVariable(value = "dir_id")Long dir_id)throws ResourceNotFoundException{
      Direccion direccion=direccionRepository.findById(dir_id).orElseThrow(()->new ResourceNotFoundException("No se puede encontrar la direccion con el id: "+dir_id));  
      return ResponseEntity.ok().body(direccion);
    }

    @PostMapping("/Direccion")
    public Direccion creareDireccion(@Validated @RequestBody Direccion direccion){
        return direccionRepository.save(direccion);
    }

    @PutMapping("/Direccion/{dir_id}")
    public ResponseEntity<Direccion> updateDireccion(@PathVariable(value = "dir_id")Long dir_id, @Validated @RequestBody Direccion direccion)throws ResourceNotFoundException{
        Direccion direccion2=direccionRepository.findById(dir_id).orElseThrow(()->new ResourceNotFoundException("No se puede encontrar la direccion con el id: "+dir_id));  
        direccion2.setDir_calle1(direccion.getDir_calle1());
        direccion2.setDir_calle2(direccion.getDir_calle2());
        direccion2.setDir_cuidad(direccion.getDir_cuidad());
        direccion2.setDir_latitud(direccion.getDir_latitud());
        direccion2.setDir_postal(direccion.getDir_postal());
        direccion2.setDir_referencia(direccion.getDir_referencia());
        final Direccion updateDireccion= direccionRepository.save(direccion2);
        return ResponseEntity.ok(updateDireccion);
    }

    @DeleteMapping("/Direccion/{dir_id}")
    public Map<String, Boolean>deleteDireccion(@PathVariable(value = "dir_id")Long dir_id)throws ResourceNotFoundException{
        Direccion direccion2=direccionRepository.findById(dir_id).orElseThrow(()->new ResourceNotFoundException("No se puede encontrar la direccion con el id: "+dir_id));  
        direccionRepository.delete(direccion2);
        Map<String, Boolean>response=new HashMap<>();
        response.put("deleted", Boolean.TRUE);
        return response;  
    }
}
