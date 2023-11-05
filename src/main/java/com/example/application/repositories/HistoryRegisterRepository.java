package com.example.application.repositories;

import com.example.application.entities.HistoryRegister;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface HistoryRegisterRepository extends JpaRepository<HistoryRegister, Long> {

    HistoryRegister findByLogin(String login);

}
