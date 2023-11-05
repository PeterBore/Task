package com.example.application.services;

import com.example.application.repositories.HistoryRegisterRepository;
import com.example.application.entities.HistoryRegister;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class HistoryRegisterServiceImpl implements HistoryRegisterService {

    @Autowired
    HistoryRegisterRepository historyRegisterRepository;

    public void incrementUsage(String login) {
        HistoryRegister historyRegister = historyRegisterRepository.findByLogin(login);
        if (historyRegister != null) {
            historyRegister.setRequestCount(historyRegister.getRequestCount() + 1);
            historyRegisterRepository.save(historyRegister);
        } else {
            historyRegisterRepository.save(new HistoryRegister(login, 1));
        }
    }
}
