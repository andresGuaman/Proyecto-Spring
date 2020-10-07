package com.example.springMyStore.Repositorio;

import com.example.springMyStore.Modelo.Cliente;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface ClienteRepository extends JpaRepository<Cliente, Long>{
    
    @Query(value = "SELECT c FROM Cliente c WHERE c.cli_usuario = :cli_usuario AND c.cli_password = :cli_password")
    Cliente findByUserPass(@Param("cli_usuario") String cli_usuario, @Param("cli_password") String cli_password);
}
