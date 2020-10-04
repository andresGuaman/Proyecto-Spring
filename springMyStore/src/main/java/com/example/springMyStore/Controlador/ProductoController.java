package com.example.springMyStore.Controlador;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.example.springMyStore.Modelo.Producto;
import com.example.springMyStore.Repositorio.ProductoRepository;

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
public class ProductoController {
    
    @Autowired
    private ProductoRepository productoRepository;
     
    @GetMapping("/Producto")
    public List<Producto> getAllProducto(){
        return productoRepository.findAll();
    }

    @GetMapping("/Producto/{pro_id}")
     public ResponseEntity<Producto>getProductoById(@PathVariable(value = "pro_id")Long pro_id)throws ResourceNotFoundException{
         Producto producto=productoRepository.findById(pro_id).orElseThrow(()-> new ResourceNotFoundException("No se puede encontrar el producto con el id:"+pro_id));
         return ResponseEntity.ok().body(producto);
     }
     
     @PostMapping("/Producto")
     public Producto createProducto(@Validated @RequestBody Producto producto){
         return productoRepository.save(producto);
     }

     @PutMapping("/Producto/{pro_id}")
     public ResponseEntity<Producto> updatePersona(@PathVariable(value = "pro_id") Long pro_id,
             @Validated @RequestBody Producto producto) throws ResourceNotFoundException {
        Producto producto2=productoRepository.findById(pro_id).orElseThrow(()-> new ResourceNotFoundException("No se puede encontrar el producto con el id:"+pro_id));
       producto2.setPro_codigo_barra(producto.getPro_codigo_barra());
       producto2.setPro_costo(producto.getPro_costo());
       producto2.setPro_descripcion(producto.getPro_descripcion());
       producto2.setPro_foto(producto.getPro_foto());
       producto2.setPro_marca(producto.getPro_foto());
       producto2.setPro_modelo(producto.getPro_modelo());
       producto2.setPro_precio(producto.getPro_precio());
       producto2.setPro_stock(producto.getPro_stock());
       final Producto updateProducto=productoRepository.save(producto2);
       return ResponseEntity.ok(updateProducto);
     }

     @DeleteMapping("/Producto/{pro_id}")
     public Map<String, Boolean> deleteProducto(@PathVariable(value = "pro_id")Long pro_id)throws ResourceNotFoundException{
        Producto producto2=productoRepository.findById(pro_id).orElseThrow(()-> new ResourceNotFoundException("No se puede encontrar el producto con el id:"+pro_id));
       productoRepository.delete(producto2);
       Map<String, Boolean>response = new HashMap<>();
       response.put("deleted", Boolean.TRUE);
       return response; 
     }
     




}
