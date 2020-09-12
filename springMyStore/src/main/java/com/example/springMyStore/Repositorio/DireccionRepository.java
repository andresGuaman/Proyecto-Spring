package com.example.springMyStore.Repositorio;

import com.example.springMyStore.Modelo.Direccion;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DireccionRepository extends JpaRepository<Direccion,Long>{
    
}
