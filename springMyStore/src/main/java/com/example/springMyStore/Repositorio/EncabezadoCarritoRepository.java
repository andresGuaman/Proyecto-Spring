package com.example.springMyStore.Repositorio;

import com.example.springMyStore.Modelo.EncabezadoCarrito;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EncabezadoCarritoRepository extends JpaRepository<EncabezadoCarrito,Long> {
    
}
