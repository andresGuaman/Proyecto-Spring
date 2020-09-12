package com.example.springMyStore.Repositorio;

import com.example.springMyStore.Modelo.Chat;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ChatRepository extends JpaRepository<Chat, Long>{
    
}
