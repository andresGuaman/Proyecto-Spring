package com.example.springMyStore.Repositorio;

import com.example.springMyStore.Modelo.Empleado;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface EmpleadoRepository extends JpaRepository<Empleado,Long>{

    @Query(value = "SELECT * FROM Empleado e WHERE e.per_id = :per_id", nativeQuery = true)
    Empleado findEmployeeByPerId(@Param(value = "per_id") Long per_id);

    @Query(value = "SELECT e FROM Empleado e WHERE e.emp_usuario = :emp_usuario AND e.emp_password = :emp_password")
    Empleado findByUserPass(@Param("emp_usuario") String emp_usuario, @Param("emp_password") String emp_password);
}
