package com.ei.chat.core;

import com.ei.chat.patterns.Observer;

import java.util.Objects;

public class User implements Observer {
    private final String username;

    public User(String username) {
        this.username = username == null ? "" : username;
    }

    @Override
    public void update(String message) {
        // print message to console with tag
        System.out.println("[" + username + " received] " + message);
    }

    public String getUsername() {
        return username;
    }

    // important: equality based on username so removal by new User(name) works
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof User user)) return false;
        return Objects.equals(username, user.username);
    }

    @Override
    public int hashCode() {
        return Objects.hash(username);
    }

    @Override
    public String toString() {
        return username;
}
}

