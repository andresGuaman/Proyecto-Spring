package com.example.springMyStore.Repositorio;

import com.example.springMyStore.Modelo.Chat;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface ChatRepository extends JpaRepository<Chat, Long> {

    @Query(value = "SELECT * FROM Chat c WHERE c.cli_id = :cli_id AND c.emp_id = :emp_id ORDER BY c.cha_id DESC LIMIT 1", nativeQuery = true)
    Chat findChatByCliEmpIds(@Param(value = "cli_id") Long cli_id, @Param(value = "emp_id") Long emp_id);
}
