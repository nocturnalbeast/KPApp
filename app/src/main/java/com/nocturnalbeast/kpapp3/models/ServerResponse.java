package com.nocturnalbeast.kpapp3.models;


import com.nocturnalbeast.kpapp3.models.User;

public class ServerResponse {

    private String result;
    private String message;
    private User user;

    public String getResult() {
        return result;
    }

    public String getMessage() {
        return message;
    }

    public User getUser() {
        return user;
    }
}
