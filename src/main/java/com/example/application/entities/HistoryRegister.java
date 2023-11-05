package com.example.application.entities;

import javax.persistence.*;

@Entity
public class HistoryRegister {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;

    @Column(name = "LOGIN", nullable = false, unique = true)
    private String login;

    @Column(name = "REQUEST_COUNT")
    private int requestCount;

    public HistoryRegister(String login, int requestCount) {
        this.login = login;
        this.requestCount = requestCount;
    }

    public HistoryRegister() {
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public int getRequestCount() {
        return requestCount;
    }

    public void setRequestCount(int requestCount) {
        this.requestCount = requestCount;
    }
}
