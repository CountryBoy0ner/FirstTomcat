package com.example.firsttomcat.command;

import com.example.firsttomcat.command.impl.AddUserCommand;
import com.example.firsttomcat.command.impl.DefaultCommand;
import com.example.firsttomcat.command.impl.LoginCommand;
import com.example.firsttomcat.command.impl.LogoutCommand;

public enum CommandType {
     ADD_USER(new AddUserCommand()),
     LOGIN (new LoginCommand()),
    LOGOUT(new LogoutCommand()),
     DEFAULT(new DefaultCommand());
     Command command;

    CommandType(Command command) {
        this.command = command;
    }
    public Command getCommand() {
        return command;
    }
    public static Command defineCommand(String commandStr) {
        CommandType current = CommandType.valueOf(commandStr.toUpperCase());
        return current.command;
    }
}