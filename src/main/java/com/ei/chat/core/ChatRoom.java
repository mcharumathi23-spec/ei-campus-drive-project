package com.ei.chat.core;

import com.ei.chat.patterns.Observer;
import com.ei.chat.patterns.Subject;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class ChatRoom implements Subject {
    private final String roomId;
    private final List<Observer> users;
    private final List<String> history;

    public ChatRoom(String roomId) {
        this.roomId = roomId;
        this.users = new ArrayList<>();
        this.history = new ArrayList<>();
    }

    @Override
    public synchronized void registerObserver(Observer o) {
        if (o == null) return;
        if (!users.contains(o)) {
            users.add(o);
            LoggerUtil.logInfo("User registered in room " + roomId);
        }
    }

    @Override
    public synchronized void removeObserver(Observer o) {
        if (o == null) return;
        users.remove(o);
        LoggerUtil.logInfo("User removed from room " + roomId);
    }

    @Override
    public synchronized void notifyObservers(String message) {
        // add to history as well
        history.add(message);
        // clone to avoid concurrent modification
        List<Observer> snapshot = new ArrayList<>(users);
        for (Observer user : snapshot) {
            try {
                user.update(message);
            } catch (Exception e) {
                LoggerUtil.logError("Failed notifying user: " + e.getMessage());
            }
        }
    }

    public synchronized void addMessage(Message m) {
        if (m == null) return;
        history.add(m.toString());
    }

    public synchronized List<String> getHistory() {
        return Collections.unmodifiableList(new ArrayList<>(history));
    }

    public synchronized String listUsers() {
        List<String> names = new ArrayList<>();
        for (Observer u : users) {
            if (u instanceof User) {
                names.add(((User) u).getUsername());
            } else {
                names.add(u.toString());
            }
        }
        return names.toString();
    }

    public String getRoomId() {
        return roomId;
}
}
