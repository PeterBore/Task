package com.example.application.services;

import com.example.application.entities.HistoryRegister;
import com.example.application.repositories.HistoryRegisterRepository;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.junit.jupiter.api.Assertions.*;

@ExtendWith(MockitoExtension.class)
class HistoryRegisterServiceImplTest {
    @Mock
    HistoryRegisterRepository historyRegisterRepository;

    @InjectMocks
    HistoryRegisterServiceImpl historyRegisterService;

    @Test
    public void incrementUsageExistingUser() {
        HistoryRegister historyRegister = new HistoryRegister("login", 1);
        Mockito.when(historyRegisterRepository.findByLogin("login")).thenReturn(historyRegister);
        Mockito.when(historyRegisterRepository.save(historyRegister)).thenReturn(historyRegister);

        historyRegisterService.incrementUsage("login");

        assertEquals(2, historyRegister.getRequestCount());
    }
}