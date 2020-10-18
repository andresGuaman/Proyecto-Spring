package com.example.springMyStore.Repositorio;

import java.util.List;

import com.example.springMyStore.Modelo.Producto;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface ProductoRepository extends JpaRepository<Producto,Long> {
    
    @Query(value = "SELECT p FROM Producto p WHERE p.pro_descripcion LIKE %:pro_descripcion%")
    List<Producto> findByDetail(@Param(value = "pro_descripcion") String pro_descripcion);
}
