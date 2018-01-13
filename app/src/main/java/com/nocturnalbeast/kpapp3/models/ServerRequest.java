package com.nocturnalbeast.kpapp3.models;


import com.nocturnalbeast.kpapp3.models.User;

public class ServerRequest {

    private String operation;
    private User user;

    public void setOperation(String operation) {
        this.operation = operation;
    }

    public void setUser(User user) {
        this.user = user;
    }
}
