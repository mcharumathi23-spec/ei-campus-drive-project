package com.ei.chat.core;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Objects;

public class Message {
    private final String sender;
    private final String content;
    private final String timestamp;

    private static final DateTimeFormatter fmt = DateTimeFormatter.ofPattern("HH:mm:ss");

    public Message(String sender, String content) {
        this.sender = Objects.requireNonNullElse(sender, "unknown");
        this.content = Objects.requireNonNullElse(content, "");
        this.timestamp = LocalDateTime.now().format(fmt);
    }

    @Override
    public String toString() {
        return "[" + timestamp + "] " + sender + ": " + content;
}
}
