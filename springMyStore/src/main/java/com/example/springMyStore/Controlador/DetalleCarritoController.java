package com.example.springMyStore.Controlador;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.example.springMyStore.Modelo.DetalleCarrito;
import com.example.springMyStore.Repositorio.DetalleCarritoRepository;

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
public class DetalleCarritoController {
    @Autowired
    private DetalleCarritoRepository detalleCarritoRepository;

    @GetMapping("/DetalleCarrito")
    public List<DetalleCarrito>getAllDetalleCarrito(){
        return detalleCarritoRepository.findAll();
    }

    @GetMapping("/DetalleCarrito/{detc_id}")
    public ResponseEntity<DetalleCarrito> getDetalleCarritoByID(@PathVariable(value = "detc_id")Long detc_id)throws ResourceNotFoundException{
        DetalleCarrito detalleCarrito= detalleCarritoRepository.findById(detc_id).orElseThrow(()-> new ResourceNotFoundException("No se puede encontrar el detalle carrito por el id:"+detc_id));
        return ResponseEntity.ok().body(detalleCarrito);
    }

    @PostMapping("/DetalleCarrito")
    public DetalleCarrito crearDetalleCarrito(@Validated @RequestBody DetalleCarrito detalleCarrito){
        return detalleCarritoRepository.save(detalleCarrito);
    }
     
    @PutMapping("DetalleCarrito/{detc_id}")
    public ResponseEntity<DetalleCarrito>updateDetalleCarrito(@PathVariable(value = "detc_id")Long detc_id, @Validated @RequestBody DetalleCarrito detalleCarrito)throws ResourceNotFoundException{
        DetalleCarrito detalleCarrito2= detalleCarritoRepository.findById(detc_id).orElseThrow(()-> new ResourceNotFoundException("No se puede encontrar el detalle carrito por el id:"+detc_id));
        detalleCarrito2.setDetc_cantidad(detalleCarrito.getDetc_cantidad());
        detalleCarrito2.setDetc_descuento(detalleCarrito.getDetc_descuento());
        detalleCarrito2.setDetc_iva(detalleCarrito.getDetc_iva());
        detalleCarrito2.setDetc_subtotal(detalleCarrito.getDetc_subtotal());
        detalleCarrito2.setDetc_valor_total(detalleCarrito.getDetc_valor_total());
        detalleCarrito2.setDetc_valor_unitario(detalleCarrito.getDetc_valor_unitario());
        final DetalleCarrito updateDetalleCarrito= detalleCarritoRepository.save(detalleCarrito2);
        return ResponseEntity.ok(updateDetalleCarrito);
    }

    @DeleteMapping("/DetalleCarrito/{detc_id}")
    public Map<String, Boolean> deletedDetalleCategoria(@PathVariable(value ="detc_id")Long detc_id)throws ResourceNotFoundException{
        DetalleCarrito detalleCarrito2= detalleCarritoRepository.findById(detc_id).orElseThrow(()-> new ResourceNotFoundException("No se puede encontrar el detalle carrito por el id:"+detc_id));
       detalleCarritoRepository.delete(detalleCarrito2);
       Map<String, Boolean>response = new HashMap<>();
       response.put("deleted", Boolean.TRUE);
       return response;
    }
}
