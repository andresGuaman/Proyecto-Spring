package com.example.springMyStore.Controlador;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.example.springMyStore.Modelo.*;

import com.example.springMyStore.Repositorio.EncabezadoFacturaRepository;

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
public class EncabezadoFacturaController {
    
    @Autowired
    private EncabezadoFacturaRepository encabezadoFacturaRepository;

    @GetMapping("/EncabezadoFactura")
    public List<EncabezadoFactura> getAllEncabezado(){
        return encabezadoFacturaRepository.findAll();
    }

    @GetMapping("/EncabezadoFactura/{enc_id}")
    public ResponseEntity<EncabezadoFactura> getencabezadoFacById(@PathVariable(value = "enc_id")Long enc_id)throws ResourceNotFoundException{
        EncabezadoFactura encabezadoFactura=encabezadoFacturaRepository.findById(enc_id).orElseThrow(()-> new ResourceNotFoundException("No se pudo encontra el encabezado con el id:"+enc_id));
        return ResponseEntity.ok().body(encabezadoFactura);
    }

    @PostMapping("/EncabezadoFactura")
    public EncabezadoFactura createEncabezadoFactura(@Validated @RequestBody EncabezadoFactura encabezadoFactura){
       return encabezadoFacturaRepository.save(encabezadoFactura);
    }

    @PutMapping("/EncabezadoFactura/{enc_id}")
    public ResponseEntity<EncabezadoFactura>updateEncabezadoFac(@PathVariable(value = "enc_id")Long enc_id, @Validated @RequestBody EncabezadoFactura encabezadoFactura)throws ResourceNotFoundException{
        EncabezadoFactura encabezadoFactura2=encabezadoFacturaRepository.findById(enc_id).orElseThrow(()-> new ResourceNotFoundException("No se pudo encontra el encabezado con el id:"+enc_id));
      encabezadoFactura2.setEnc_descuento(encabezadoFactura.getEnc_descuento());
      encabezadoFactura2.setEnc_fecha(encabezadoFactura.getEnc_fecha());
      encabezadoFactura2.setEnc_iva(encabezadoFactura.getEnc_iva());
      encabezadoFactura2.setEnc_subtotal(encabezadoFactura.getEnc_subtotal());
      encabezadoFactura2.setEnc_total(encabezadoFactura.getEnc_total());
      final EncabezadoFactura updEncabezadoFactura=encabezadoFacturaRepository.save(encabezadoFactura2);
      return ResponseEntity.ok(updEncabezadoFactura);
    }
    
    @DeleteMapping("/EncabezadoFactura/{enc_id}")
    public Map<String, Boolean>deletedEncabezadoFactura(@PathVariable(value = "enc_id")Long enc_id)throws ResourceNotFoundException{
        EncabezadoFactura encabezadoFactura2=encabezadoFacturaRepository.findById(enc_id).orElseThrow(()-> new ResourceNotFoundException("No se pudo encontra el encabezado con el id:"+enc_id));
      encabezadoFacturaRepository.delete(encabezadoFactura2);
      Map<String, Boolean>response=new HashMap<>();
      response.put("deleted", Boolean.TRUE);
      return response;
    }
}
