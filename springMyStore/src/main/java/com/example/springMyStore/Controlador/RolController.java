package com.example.springMyStore.Controlador;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.example.springMyStore.Modelo.Rol;
import com.example.springMyStore.Repositorio.RolRepository;

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
public class RolController {
    
    @Autowired
    private RolRepository rolRepository;

    @GetMapping("/Rol")
    public List<Rol>getAllRol(){
        return rolRepository.findAll();
    }

    @GetMapping("/Rol/{rol_id}")
    public ResponseEntity<Rol> getRolById(@PathVariable(value = "rol_id")Long rol_id)throws ResourceNotFoundException{
        Rol rol=rolRepository.findById(rol_id).orElseThrow(()-> new ResourceNotFoundException("No se encontro el Rol con el id:"+rol_id));
        return ResponseEntity.ok().body(rol);
    }
    
    @PostMapping("/Rol")
    public Rol createRol(@Validated @RequestBody Rol rol){
        return rolRepository.save(rol);
    }

    @PutMapping("/Rol/{rol_id}")
    public ResponseEntity<Rol>updateRol(@PathVariable(value = "rol_id")Long rol_id, @Validated @RequestBody Rol rol)throws ResourceNotFoundException{
        Rol rol2=rolRepository.findById(rol_id).orElseThrow(()-> new ResourceNotFoundException("No se encontro el Rol con el id:"+rol_id));
         rol2.setRol_departamento(rol.getRol_departamento());
         rol2.setRol_estado(rol.getRol_estado());
         rol2.setRol_nombre(rol.getRol_nombre());
         final Rol updateRol=rolRepository.save(rol2);
         return ResponseEntity.ok(updateRol);
    }

    @DeleteMapping("/Rol/{rol_id}")
    public Map<String, Boolean>deleteRol(@PathVariable(value = "rol_id")Long rol_id)throws ResourceNotFoundException{
        Rol rol2=rolRepository.findById(rol_id).orElseThrow(()-> new ResourceNotFoundException("No se encontro el Rol con el id:"+rol_id));
       rolRepository.delete(rol2);  
       Map<String, Boolean>response=new HashMap<>();
       response.put("deleted", Boolean.TRUE);
       return response;
    }

}
