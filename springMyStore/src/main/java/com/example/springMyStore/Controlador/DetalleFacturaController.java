package com.example.springMyStore.Controlador;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.example.springMyStore.Modelo.DetalleFactura;
import com.example.springMyStore.Repositorio.DetalleFacturaRepository;

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
public class DetalleFacturaController {
    
    @Autowired
    private DetalleFacturaRepository detalleFacturaRepository;

    @GetMapping("/DetalleFactura")
    public List<DetalleFactura>getAllDetalleFactura(){
        return detalleFacturaRepository.findAll();
    }

    @GetMapping("/DetalleFactura/{det_id}")
    public ResponseEntity<DetalleFactura>getDetalleFacById(@PathVariable(value = "det_id")Long det_id)throws ResourceNotFoundException{
        DetalleFactura detalleFactura=detalleFacturaRepository.findById(det_id).orElseThrow(()->new ResourceNotFoundException("No se puede encontrar el detalle de la factura con el id:"+det_id));
        return ResponseEntity.ok().body(detalleFactura);
    }

    @PostMapping("/DetalleFactura")
    public DetalleFactura crearDetalleFactura(@Validated @RequestBody DetalleFactura detalleFactura){
        return detalleFacturaRepository.save(detalleFactura);
    }

    @PutMapping("DetalleFactura/{det_id}")
    public ResponseEntity<DetalleFactura>updateDetalleFactura(@PathVariable(value = "det_id")Long det_id, @Validated @RequestBody DetalleFactura detalleFactura)throws ResourceNotFoundException{
        DetalleFactura detalleFactura2=detalleFacturaRepository.findById(det_id).orElseThrow(()->new ResourceNotFoundException("No se puede encontrar el detalle de la factura con el id:"+det_id));
          detalleFactura2.setDet_cantidad(detalleFactura.getDet_cantidad());
          detalleFactura2.setDet_descuento(detalleFactura.getDet_descuento());
          detalleFactura2.setDet_iva(detalleFactura.getDet_iva());
          detalleFactura2.setDet_subtotal(detalleFactura.getDet_subtotal());
          detalleFactura2.setDet_total(detalleFactura.getDet_total());
          detalleFactura2.setDet_valor_total(detalleFactura.getDet_valor_total());
          detalleFactura2.setDet_valor_unitario(detalleFactura.getDet_valor_unitario());
          final DetalleFactura updDetalleFactura= detalleFacturaRepository.save(detalleFactura2);
          return ResponseEntity.ok(updDetalleFactura);
   }

   @DeleteMapping("DetalleFactura/{det_id}")
   public Map<String, Boolean> deleteDetalleFactura(@PathVariable(value = "det_id")Long det_id)throws ResourceNotFoundException{
    DetalleFactura detalleFactura2=detalleFacturaRepository.findById(det_id).orElseThrow(()->new ResourceNotFoundException("No se puede encontrar el detalle de la factura con el id:"+det_id));
       detalleFacturaRepository.delete(detalleFactura2);
       Map<String, Boolean>response=new HashMap<>();
       response.put("deleted", Boolean.TRUE);
       return response;
   }


}
