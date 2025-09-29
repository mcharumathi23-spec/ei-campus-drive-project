package com.ei.chat.core;

import java.util.Collections;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;

public class ChatManager {
    private static ChatManager instance;
    private final Map<String, ChatRoom> rooms;

    private ChatManager() {
        this.rooms = new HashMap<>();
    }

    public static synchronized ChatManager getInstance() {
        if (instance == null) {
            instance = new ChatManager();
        }
        return instance;
    }

    public synchronized void createRoom(String roomId) {
        if (roomId == null || roomId.isBlank()) {
            LoggerUtil.logError("Cannot create room with empty id.");
            return;
        }
        if (rooms.containsKey(roomId)) {
            LoggerUtil.logError("Room " + roomId + " already exists.");
        } else {
            rooms.put(roomId, new ChatRoom(roomId));
            LoggerUtil.logInfo("Room " + roomId + " created successfully.");
        }
    }

    public synchronized ChatRoom getRoom(String roomId) {
        return rooms.get(roomId);
    }

    public synchronized Set<String> listRooms() {
        return Collections.unmodifiableSet(rooms.keySet());
}
}
