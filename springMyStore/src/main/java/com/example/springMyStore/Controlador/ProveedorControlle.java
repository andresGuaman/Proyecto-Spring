package com.example.springMyStore.Controlador;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.example.springMyStore.Modelo.Proveedor;
import com.example.springMyStore.Repositorio.ProveedorRepository;

import org.apache.velocity.exception.ResourceNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.validation.annotation.Validated;
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
public class ProveedorControlle {

    @Autowired
    private ProveedorRepository proveedorRepository;

    @GetMapping("/Proveedor")
    public List<Proveedor> getAllProveedor(){
        return proveedorRepository.findAll();
    }

    @GetMapping("/Proveedor/{prov_id}")
    public ResponseEntity<Proveedor>getProveedorById(@PathVariable(value = "prov_id")Long prov_id)throws ResourceNotFoundException{
        Proveedor proveedor=proveedorRepository.findById(prov_id).orElseThrow(()-> new ResourceNotFoundException("No se encontro el proveedor con el id:"+prov_id));
        return ResponseEntity.ok().body(proveedor);
    }

    @PostMapping("/Proveedor")
    public Proveedor createProveedor(@Validated @RequestBody Proveedor proveedor){
        return proveedorRepository.save(proveedor);
    }

    @PutMapping("/Proveedor/{prov_id}")
    public ResponseEntity<Proveedor>updateProveedor(@PathVariable(value = "prov_id")Long prov_id, @Validated @RequestBody Proveedor proveedor)throws ResourceNotFoundException{
        Proveedor proveedor2=proveedorRepository.findById(prov_id).orElseThrow(()-> new ResourceNotFoundException("No se encontro el proveedor con el id:"+prov_id));
         proveedor2.setProv_empresa(proveedor.getProv_empresa());
         proveedor2.setProv_ruc(proveedor.getProv_ruc());
         final Proveedor updatProveedor=proveedorRepository.save(proveedor2);
         return ResponseEntity.ok(updatProveedor);
    }

    @DeleteMapping("/Proveedor/{prov_id}")
    public Map<String, Boolean> deleteProveedor(@PathVariable(value = "prov_id")Long prov_id)throws ResourceNotFoundException{
        Proveedor proveedor2=proveedorRepository.findById(prov_id).orElseThrow(()-> new ResourceNotFoundException("No se encontro el proveedor con el id:"+prov_id));
       proveedorRepository.delete(proveedor2);
       Map<String, Boolean>response=new HashMap<>();
       response.put("deleted", Boolean.TRUE);
       return response;
    }
}
