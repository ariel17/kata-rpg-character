package com.pedidosya.delivery;

public abstract class RPGCommand {
    protected String[] arguments;

    public RPGCommand(String[] arguments) {
        this.arguments = arguments;
    }

    public abstract void execute();

    public String getCommandName() {
        return arguments[0];
    }
}
