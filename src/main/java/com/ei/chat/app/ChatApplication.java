package com.ei.chat.app;

import com.ei.chat.core.*;
import com.ei.chat.patterns.ConsoleAdapter;
import com.ei.chat.patterns.ProtocolAdapter;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class ChatApplication {
    // local tracking: username -> roomId (for this console session)
    private static final Map<String, String> sessionUsers = new HashMap<>();

    public static void main(String[] args) {
        ProtocolAdapter adapter = new ConsoleAdapter();
        ChatManager manager = ChatManager.getInstance();
        Scanner scanner = new Scanner(System.in);

        adapter.sendMessage("Welcome to EI Chat App!");
        boolean running = true;

        while (running) {
            adapter.sendMessage("\n=== MENU ===");
            adapter.sendMessage("1. Create Room");
            adapter.sendMessage("2. Join Room");
            adapter.sendMessage("3. Send Message");
            adapter.sendMessage("4. View Active Users in Room");
            adapter.sendMessage("5. View Message History");
            adapter.sendMessage("6. Leave Room");
            adapter.sendMessage("7. List Rooms");
            adapter.sendMessage("8. Exit");
            adapter.sendMessage("Choose option: ");

            String choice = scanner.nextLine().trim();
            try {
                switch (choice) {
                    case "1":
                        adapter.sendMessage("Enter Room ID: ");
                        String roomId = scanner.nextLine().trim();
                        manager.createRoom(roomId);
                        break;
                    case "2":
                        adapter.sendMessage("Enter Room ID to join: ");
                        String joinRoomId = scanner.nextLine().trim();
                        ChatRoom room = manager.getRoom(joinRoomId);
                        if (room != null) {
                            adapter.sendMessage("Enter Username: ");
                            String username = scanner.nextLine().trim();
                            if (username.isEmpty()) {
                                adapter.sendMessage("Username cannot be empty.");
                                break;
                            }
                            synchronized (sessionUsers) {
                                if (sessionUsers.containsKey(username)) {
                                    adapter.sendMessage("That username is already used in this session. Choose another.");
                                    break;
                                }
                                User user = new User(username);
                                room.registerObserver(user);
                                sessionUsers.put(username, joinRoomId);
                            }
                            adapter.sendMessage(username + " joined " + joinRoomId);
                        } else {
                            adapter.sendMessage("Room not found.");
                        }
                        break;
                    case "3":
                        adapter.sendMessage("Enter your Username: ");
                        String sender = scanner.nextLine().trim();
                        if (!sessionUsers.containsKey(sender)) {
                            adapter.sendMessage("You must join a room first with that username.");
                            break;
                        }
                        String msgRoomId = sessionUsers.get(sender);
                        ChatRoom msgRoom = manager.getRoom(msgRoomId);
                        if (msgRoom == null) {
                            adapter.sendMessage("Room no longer exists.");
                            break;
                        }
                        adapter.sendMessage("Enter Message: ");
                        String content = scanner.nextLine();
                        Message message = new Message(sender, content);
                        msgRoom.addMessage(message); // stores history
                        msgRoom.notifyObservers(message.toString());
                        break;
                    case "4":
                        adapter.sendMessage("Enter Room ID: ");
                        String activeRoomId = scanner.nextLine().trim();
                        ChatRoom activeRoom = manager.getRoom(activeRoomId);
                        if (activeRoom != null) {
                            adapter.sendMessage("Active Users: " + activeRoom.listUsers());
                        } else {
                            adapter.sendMessage("Room not found.");
                        }
                        break;
                    case "5":
                        adapter.sendMessage("Enter Room ID for history: ");
                        String histRoomId = scanner.nextLine().trim();
                        ChatRoom histRoom = manager.getRoom(histRoomId);
                        if (histRoom != null) {
                            adapter.sendMessage("Message History:");
                            for (String m : histRoom.getHistory()) {
                                adapter.sendMessage(m);
                            }
                        } else {
                            adapter.sendMessage("Room not found.");
                        }
                        break;
                    case "6":
                        adapter.sendMessage("Enter Username to leave: ");
                        String leaveUser = scanner.nextLine().trim();
                        if (!sessionUsers.containsKey(leaveUser)) {
                            adapter.sendMessage("That username is not active in this session.");
                            break;
                        }
                        String leaveRoomId = sessionUsers.remove(leaveUser);
                        ChatRoom leaveRoom = manager.getRoom(leaveRoomId);
                        if (leaveRoom != null) {
                            // create temporary User object with same name to remove
                            leaveRoom.removeObserver(new User(leaveUser));
                            adapter.sendMessage(leaveUser + " left " + leaveRoomId);
                        } else {
                            adapter.sendMessage("Room not found.");
                        }
                        break;
                    case "7":
                        adapter.sendMessage("Rooms: " + manager.listRooms());
                        break;
                    case "8":
                        adapter.sendMessage("Exiting chat app...");
                        running = false;
                        break;
                    default:
                        adapter.sendMessage("Invalid choice.");
                }
            } catch (Exception e) {
                LoggerUtil.logError("Unhandled error in main loop: " + e.getMessage());
                adapter.sendMessage("An error occurred: " + e.getMessage());
            }
        }

        // clean up: unregister session users from rooms
        for (Map.Entry<String, String> entry : sessionUsers.entrySet()) {
            ChatRoom r = manager.getRoom(entry.getValue());
            if (r != null) {
                r.removeObserver(new User(entry.getKey()));
            }
        }
        scanner.close();
}
}
