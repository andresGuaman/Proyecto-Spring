package com.example.springMyStore.Repositorio;

import java.util.List;

import com.example.springMyStore.Modelo.Persona;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface PersonaRepository extends JpaRepository<Persona,Long> {
    
    @Query(value = "SELECT * FROM Persona p WHERE p.per_id IN(SELECT e.per_id FROM Empleado e WHERE e.emp_id IN(SELECT DISTINCT c.emp_id FROM Chat c WHERE c.cli_id = :cli_id))", nativeQuery = true)
    List<Persona> findContactsByClientId(@Param("cli_id") Long cli_id);

    @Query(value = "SELECT * FROM Persona p WHERE p.per_id IN(SELECT c.per_id FROM Cliente c WHERE c.cli_id IN(SELECT DISTINCT c.cli_id FROM Chat c WHERE c.emp_id = :emp_id))", nativeQuery = true)
    List<Persona> findContactsByEmployeeId(@Param("emp_id") Long emp_id);

}
