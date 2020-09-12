package com.example.springMyStore.Repositorio;

import com.example.springMyStore.Modelo.EncabezadoFactura;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EncabezadoFacturaRepository extends JpaRepository<EncabezadoFactura,Long> {
    
}
