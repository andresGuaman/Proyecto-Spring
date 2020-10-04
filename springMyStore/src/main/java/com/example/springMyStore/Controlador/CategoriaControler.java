package com.example.springMyStore.Controlador;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.example.springMyStore.Modelo.Categoria;
import com.example.springMyStore.Repositorio.CategoriaRepository;

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
public class CategoriaControler {
    @Autowired
    private CategoriaRepository categoriaRepository;

    //Mostrar todo
    @GetMapping("/Categoria")
    public List<Categoria> getAllCategoria(){
        return categoriaRepository.findAll();
    }
    
    //Buscar por
    @GetMapping("/Categoria/{cat_id}")
    public ResponseEntity<Categoria> getCategoriaById(@PathVariable(value = "cat_id")Long cat_id) throws ResourceNotFoundException{
        Categoria categoria=categoriaRepository.findById(cat_id).orElseThrow(()-> new ResourceNotFoundException("No se pudo encontrar la categoria con el id: "+cat_id));
        return ResponseEntity.ok().body(categoria);
    }


    //Guardar
    @PostMapping("/Categoria")
    public Categoria creatCategoria(@Validated @RequestBody Categoria categoria){
        return categoriaRepository.save(categoria);
    }
    
    //Actualizar
    @PutMapping("Categoria/{cat_id}")
    public ResponseEntity<Categoria>updateCategoria(@PathVariable(value = "cat_id")Long cat_id, @Validated @RequestBody Categoria categoria)throws ResourceNotFoundException{
        Categoria categoria2=categoriaRepository.findById(cat_id).orElseThrow(()-> new ResourceNotFoundException("No se pudo encontrar la categoria con el id: "+cat_id));
        categoria2.setCat_categoria(categoria.getCat_categoria());
        categoria2.setCat_color(categoria.getCat_color());
        categoria2.setCat_edad(categoria.getCat_edad());
        categoria2.setCat_genero(categoria.getCat_genero());
        categoria2.setCat_marca(categoria.getCat_marca()); 
        final Categoria updateCategoria = categoriaRepository.save(categoria2);
         return ResponseEntity.ok(updateCategoria);
    }

    //Eliminar
    @DeleteMapping("/Categoria/{cat_id}")
    public Map<String, Boolean> deleteCategoria (@PathVariable(value = "cat_id")Long cat_id)throws ResourceNotFoundException{
        Categoria categoria2=categoriaRepository.findById(cat_id).orElseThrow(()-> new ResourceNotFoundException("No se pudo encontrar la categoria con el id: "+cat_id));
        categoriaRepository.delete(categoria2);
        Map<String, Boolean> response =new HashMap<>();
        response.put("deleted",Boolean.TRUE);
        return response;
    } 
}