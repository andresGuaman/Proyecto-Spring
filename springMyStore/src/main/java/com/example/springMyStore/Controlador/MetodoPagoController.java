package com.example.springMyStore.Controlador;

import java.util.HashMap;
import java.util.List;
import java.util.Map;


import com.example.springMyStore.Modelo.MetodoPago;
import com.example.springMyStore.Repositorio.MetodoPagoRepository;

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
@RequestMapping("api/v1")
public class MetodoPagoController {
    
    @Autowired
    private MetodoPagoRepository metodoPagoRepository;

    @GetMapping("/MetodoPago")
    public List<MetodoPago>getAllmetodopago(){
        return metodoPagoRepository.findAll();
    }

    @GetMapping("/MetodoPago/{met_id}")
    public ResponseEntity<MetodoPago>getMetodoPagByID(@PathVariable(value = "met_id")Long met_id)throws ResourceNotFoundException{
    MetodoPago metodoPago=metodoPagoRepository.findById(met_id).orElseThrow(()->new ResourceNotFoundException("No se pudo encontrar el metodo de pago con el id:"+met_id));
    return ResponseEntity.ok().body(metodoPago);
    }

    @PostMapping("/MetodoPago")
    public MetodoPago crearMetodoPago(@Validated @RequestBody MetodoPago metodoPago){
        return metodoPagoRepository.save(metodoPago);
    }

    @PutMapping("/MetodoPago/{met_id}")
    public ResponseEntity<MetodoPago>updateMetodoPago(@PathVariable(value = "met_id")Long met_id, @Validated @RequestBody MetodoPago metodoPago)throws ResourceNotFoundException{
        MetodoPago metodoPago2=metodoPagoRepository.findById(met_id).orElseThrow(()->new ResourceNotFoundException("No se pudo encontrar el metodo de pago con el id:"+met_id));
    metodoPago2.setMet_metodo(metodoPago.getMet_metodo());
    metodoPago2.setMet_nro_tarjeta(metodoPago.getMet_nro_tarjeta());
    metodoPago2.setMet_tipo(metodoPago.getMet_tipo());
    final MetodoPago updatemMetodoPago=metodoPagoRepository.save(metodoPago2);
    return ResponseEntity.ok(updatemMetodoPago);
    }

    @DeleteMapping("/MetodoPago/{met_id}")
    public Map<String, Boolean>deletemetodoPago(@PathVariable(value = "met_id")Long met_id)throws ResourceNotFoundException{
        MetodoPago metodoPago2=metodoPagoRepository.findById(met_id).orElseThrow(()->new ResourceNotFoundException("No se pudo encontrar el metodo de pago con el id:"+met_id));
      metodoPagoRepository.delete(metodoPago2);
      Map<String, Boolean>response=new HashMap<>();
      response.put("deleted", Boolean.TRUE);
      return response;
    }
}
