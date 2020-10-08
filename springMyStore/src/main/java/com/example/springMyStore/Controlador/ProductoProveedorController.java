package com.example.springMyStore.Controlador;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.example.springMyStore.Modelo.ProductoProveedor;
import com.example.springMyStore.Repositorio.ProductoProveedorRepository;

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
@RequestMapping("/")
@CrossOrigin(origins = "http://localhost:4200")
public class ProductoProveedorController {
    
    @Autowired
    private ProductoProveedorRepository productoProveedorRepository;

    @GetMapping("/ProductoProovedor")
    public List<ProductoProveedor> getAllProducProve(){
      return productoProveedorRepository.findAll();
    }

    @GetMapping("/ProductoProovedor/{pp_id}")
    public ResponseEntity<ProductoProveedor> getProduPROById(@PathVariable(value = "pp_id")Long pp_id)throws ResourceNotFoundException{
        ProductoProveedor productoProveedor=productoProveedorRepository.findById(pp_id).orElseThrow(()->new ResourceNotFoundException("No se encontro el producto proveedor con el id:"+pp_id));
        return ResponseEntity.ok().body(productoProveedor);
    }

    @PostMapping("/ProductoProovedor")
    public ProductoProveedor createProductoPro(@Validated @RequestBody ProductoProveedor productoProveedor){
        return productoProveedorRepository.save(productoProveedor);
    }

    @PutMapping("/ProductoProovedor/{pp_id}")
    public ResponseEntity<ProductoProveedor>updateProducPro(@PathVariable(value = "pp_id")Long pp_id, @Validated @RequestBody ProductoProveedor productoProveedor)throws ResourceNotFoundException{
        ProductoProveedor productoProveedor2=productoProveedorRepository.findById(pp_id).orElseThrow(()->new ResourceNotFoundException("No se encontro el producto proveedor con el id:"+pp_id));
        productoProveedor2.setPp_estado(productoProveedor.getPp_estado());
        final ProductoProveedor UpdateproductoProveedor=productoProveedorRepository.save(productoProveedor2);
        return ResponseEntity.ok(UpdateproductoProveedor);
    }

    @DeleteMapping("/ProductoProovedor/{pp_id}")
    public Map<String, Boolean>deleteProducPRO(@PathVariable(value = "pp_id")Long pp_id)throws ResourceNotFoundException{
        ProductoProveedor productoProveedor2=productoProveedorRepository.findById(pp_id).orElseThrow(()->new ResourceNotFoundException("No se encontro el producto proveedor con el id:"+pp_id));
      productoProveedorRepository.delete(productoProveedor2);
      Map<String, Boolean> response=new HashMap<>();
      response.put("deleted", Boolean.TRUE);
      return response;
    }
}