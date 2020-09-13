package com.example.springMyStore.Controlador;

import java.lang.module.ResolutionException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.example.springMyStore.Modelo.Empleado;
import com.example.springMyStore.Repositorio.EmpleadoRepository;

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
public class EmpleadoController {
    
    @Autowired
    private EmpleadoRepository empleadoRepository;

    @GetMapping("/Empleado")
    public List<Empleado>getAllEmpleado(){
        return empleadoRepository.findAll();
    }

    @GetMapping("/Empleado/{emp_id}")
    public ResponseEntity<Empleado>getEmpleadoByID(@PathVariable(value = "emp_id")Long emp_id)throws ResolutionException{
        Empleado empleado = empleadoRepository.findById(emp_id).orElseThrow(()-> new ResourceNotFoundException("No se pudo encontrar al empleado con el id:"+emp_id));
        return ResponseEntity.ok().body(empleado);
    }

    @PostMapping("/Empleado")
    public Empleado createEmpleado(@Validated @RequestBody Empleado empleado){
        return empleadoRepository.save(empleado);
    }

    @PutMapping("/Empleado/{emp_id}")
    public ResponseEntity<Empleado>updateEmpleado(@PathVariable(value = "emp_id")Long emp_id, @Validated @RequestBody Empleado empleado)throws ResourceNotFoundException{
        Empleado empleado2 = empleadoRepository.findById(emp_id).orElseThrow(()-> new ResourceNotFoundException("No se pudo encontrar al empleado con el id:"+emp_id));
        empleado2.setEmp_password(empleado.getEmp_password());
        empleado2.setEmp_salario(empleado.getEmp_salario());
        empleado2.setEmp_usuario(empleado.getEmp_usuario());
        final Empleado updateEmleado= empleadoRepository.save(empleado2);
        return ResponseEntity.ok(updateEmleado);
    }

    @DeleteMapping("/Empleado/{emp_id}")
    public Map<String, Boolean>deleteEmpleado(@PathVariable(value = "emp_id")Long emp_id)throws ResourceNotFoundException{
        Empleado empleado2 = empleadoRepository.findById(emp_id).orElseThrow(()-> new ResourceNotFoundException("No se pudo encontrar al empleado con el id:"+emp_id));
       empleadoRepository.delete(empleado2);
       Map<String, Boolean>responce=new HashMap<>();
       responce.put("deleted", Boolean.TRUE);
       return responce;
    }

}
