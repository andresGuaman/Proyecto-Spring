package com.example.springMyStore.Controlador;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.example.springMyStore.Modelo.EncabezadoCarrito;
import com.example.springMyStore.Repositorio.EncabezadoCarritoRepository;

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
public class EncabezadoCarritoController {
    
    @Autowired
    private EncabezadoCarritoRepository encabezadoCarritoRepository;

    @GetMapping("/EncabezadoCarrito")
    public List<EncabezadoCarrito> getAllEncabezadoCarrito(){
        return encabezadoCarritoRepository.findAll();
    }

    @GetMapping("/EncabezadoCarrito/{encc_id}")
    public ResponseEntity<EncabezadoCarrito>getEncabezadoCarrByID(@PathVariable(value = "encc_id")Long encc_id) throws ResourceNotFoundException{
        EncabezadoCarrito encabezadoCarrito= encabezadoCarritoRepository.findById(encc_id).orElseThrow(()-> new ResourceNotFoundException("No se pudo encontrar el Encabezado del carrito con el id:"+encc_id));
        return ResponseEntity.ok().body(encabezadoCarrito);
    }

    @PostMapping("/EncabezadoCarrito")
    public EncabezadoCarrito createEncabezadoCarri(@Validated @RequestBody EncabezadoCarrito encabezadoCarrito){
        return encabezadoCarritoRepository.save(encabezadoCarrito);
    }

    @PutMapping("/EncabezadoCarrito/{encc_id}")
    public ResponseEntity<EncabezadoCarrito>updateEncabeCarri(@PathVariable(value = "encc_id")Long encc_id, @Validated @RequestBody EncabezadoCarrito encabezadoCarrito)throws ResourceNotFoundException{
        EncabezadoCarrito encabezadoCarrito2= encabezadoCarritoRepository.findById(encc_id).orElseThrow(()-> new ResourceNotFoundException("No se pudo encontrar el Encabezado del carrito con el id:"+encc_id));
       encabezadoCarrito2.setEncc_descuento(encabezadoCarrito.getEncc_descuento());
       encabezadoCarrito2.setEncc_fecha(encabezadoCarrito.getEncc_fecha());
       encabezadoCarrito2.setEncc_iva(encabezadoCarrito.getEncc_iva());
       encabezadoCarrito2.setEncc_subtotal(encabezadoCarrito.getEncc_subtotal());
       encabezadoCarrito2.setEncc_total(encabezadoCarrito.getEncc_total());
       final EncabezadoCarrito udateEncabezaCarri=encabezadoCarritoRepository.save(encabezadoCarrito2);
       return ResponseEntity.ok(udateEncabezaCarri);
      }

      @DeleteMapping("/EncabezadoCarrito/{encc_id}")
      public Map<String, Boolean>deleteEncabeCarri(@PathVariable(value = "encc_id")Long encc_id)throws ResourceNotFoundException{
        EncabezadoCarrito encabezadoCarrito2= encabezadoCarritoRepository.findById(encc_id).orElseThrow(()-> new ResourceNotFoundException("No se pudo encontrar el Encabezado del carrito con el id:"+encc_id));
       encabezadoCarritoRepository.delete(encabezadoCarrito2);
       Map<String, Boolean>responce=new HashMap<>();
       responce.put("deleted", Boolean.TRUE);
       return responce;  
      }



}
