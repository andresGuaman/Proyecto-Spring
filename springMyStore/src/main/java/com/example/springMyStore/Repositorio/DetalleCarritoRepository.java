package com.example.springMyStore.Repositorio;

import com.example.springMyStore.Modelo.DetalleCarrito;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DetalleCarritoRepository extends JpaRepository<DetalleCarrito, Long>{
    
}
