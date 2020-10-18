package com.example.springMyStore.Controlador;

import java.util.List;
import com.example.springMyStore.Modelo.Mensajes;
import com.example.springMyStore.Modelo.Producto;
import com.example.springMyStore.Servicio.ProductoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
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
public class ProductoController {

	@Autowired
	ProductoService productoService;

	@GetMapping("/Producto")
	public ResponseEntity<List<Producto>> list() {
		List<Producto> list = productoService.list();
		return new ResponseEntity(list, HttpStatus.OK);
	}

	@GetMapping("/detail/{id}")
	public ResponseEntity<Producto> getById(@PathVariable("id") Long id) {
		if (!productoService.existeById(id))
			return new ResponseEntity(new Mensajes("El producto no existe"), HttpStatus.NOT_FOUND);
		Producto producto = productoService.getId(id).get();
		return new ResponseEntity(producto, HttpStatus.OK);
	}

	// GET BY DESCRIPTION
	@GetMapping("/description/{pro_descripcion}")
	public List<Producto> getByDescripcion(@PathVariable(value = "pro_descripcion") String pro_descripcion) {
		return productoService.getProductsByDescription(pro_descripcion);
	}

	@PostMapping("/create")
	public ResponseEntity<?> create(@RequestBody Producto producto) {
		productoService.save(producto);
		return new ResponseEntity(new Mensajes("Producto Agregado"), HttpStatus.OK);
	}

	@PutMapping("update/{id}")
	public ResponseEntity<?> update(@PathVariable("id") Long id, @RequestBody Producto producto) {
		if (!productoService.existeById(id))
			return new ResponseEntity(new Mensajes("Producto no existente"), HttpStatus.NOT_FOUND);
		Producto productos = productoService.getId(id).get();
		productos.setPro_foto(productos.getPro_foto());
		productos.setPro_descripcion(producto.getPro_descripcion());
		productos.setPro_costo(producto.getPro_costo());
		productos.setPro_precio(producto.getPro_precio());
		productos.setPro_stock(producto.getPro_stock());
		productos.setPro_codigo_barra(producto.getPro_codigo_barra());
		productos.setPro_marca(producto.getPro_marca());
		productos.setPro_modelo(producto.getPro_modelo());
		productoService.save(productos);
		return new ResponseEntity(new Mensajes("Producto Actualizado"), HttpStatus.OK);
	}

	@DeleteMapping("/delete/{id}")
	public ResponseEntity<?> delete(@PathVariable("id") Long id) {
		if (!productoService.existeById(id))
			return new ResponseEntity(new Mensajes("El producto no existe"), HttpStatus.NOT_FOUND);
		productoService.delete(id);
		return new ResponseEntity(new Mensajes("Producto Eliminado"), HttpStatus.OK);

	}
}
