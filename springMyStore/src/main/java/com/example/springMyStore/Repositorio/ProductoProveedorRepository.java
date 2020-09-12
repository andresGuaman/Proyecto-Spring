package com.example.springMyStore.Repositorio;

import com.example.springMyStore.Modelo.ProductoProveedor;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProductoProveedorRepository extends JpaRepository<ProductoProveedor,Long> {
    
}
