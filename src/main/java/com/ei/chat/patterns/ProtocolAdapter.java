package com.ei.chat.patterns;

public interface ProtocolAdapter {
    void sendMessage(String message);
    String receiveMessage(); // optional; ConsoleAdapter will implement
}
