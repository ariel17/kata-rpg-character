package com.pedidosya.delivery;

public class ConsoleApp {
    public static void main(String[] args) {
        final RPGCommand command = identifyCommand(args);
        command.execute();
    }

    private static RPGCommand identifyCommand(String[] args) {
        throw new RuntimeException("Unknown Command");
    }
}
