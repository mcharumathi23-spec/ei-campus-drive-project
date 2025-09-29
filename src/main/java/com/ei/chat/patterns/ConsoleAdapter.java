package com.ei.chat.patterns;

import java.util.Scanner;

public class ConsoleAdapter implements ProtocolAdapter {
    private final Scanner scanner = new Scanner(System.in);

    @Override
    public void sendMessage(String message) {
        System.out.println(message);
    }

    @Override
    public String receiveMessage() {
        return scanner.nextLine();
}
}
