package com.example.springMyStore.Repositorio;

import java.util.List;

import com.example.springMyStore.Modelo.Chat;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface ChatRepository extends JpaRepository<Chat, Long> {

    @Query(value = "SELECT * FROM Chat c WHERE c.cli_id = :cli_id AND c.emp_id = :emp_id ORDER BY c.cha_id DESC LIMIT 1", nativeQuery = true)
    Chat findChatByCliEmpIds(@Param(value = "cli_id") Long cli_id, @Param(value = "emp_id") Long emp_id);

    @Query(value = "SELECT * FROM Chat c WHERE c.cli_id = :cli_id AND c.emp_id = :emp_id ORDER BY c.cha_id DESC", nativeQuery = true)
    List<Chat> findAllChatsByCliEmpIds(@Param(value = "cli_id") Long cli_id, @Param(value = "emp_id") Long emp_id);

    @Query(value = "SELECT MAX(c.cha_id) FROM Chat c", nativeQuery = true)
    Integer maxId();

    @Modifying
    @Query(value = "INSERT INTO chat(`cha_id`, `cha_imagenes`, `cha_mensajes`, `cha_rol_emisor`, `cli_id`, `emp_id`) VALUES (:cha_id,:cha_imagenes,:cha_mensajes,:cha_rol_emisor,:cli_id,:emp_id)", nativeQuery = true)
    void insertChat(@Param(value = "cha_id") long cha_id, @Param(value = "cha_imagenes") String cha_imagenes, @Param(value = "cha_mensajes") String cha_mensajes, @Param(value = "cha_rol_emisor") String cha_rol_emisor, @Param(value = "cli_id") Long cli_id, @Param(value = "emp_id") Long emp_id);
}
