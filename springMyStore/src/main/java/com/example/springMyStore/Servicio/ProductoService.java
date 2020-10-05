package com.example.springMyStore.Servicio;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.example.springMyStore.Modelo.Producto;
import com.example.springMyStore.Repositorio.ProductoRepository;

@Service
@Transactional
public class ProductoService {
	@Autowired
	ProductoRepository productoRepository;
	
	public List<Producto> list(){
		return productoRepository.findAll();
	}
	
	public Optional<Producto> getId(Long id){
		return productoRepository.findById(id);
	}
	
	public void save(Producto producto) {
		productoRepository.save(producto);
	}
	
	public void delete(Long id) {
		productoRepository.deleteById(id);
	}
	
	public boolean existeById(Long id) {
		return productoRepository.existsById(id);
	}
}
