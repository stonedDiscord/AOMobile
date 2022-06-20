package com.example.vnolib.connection;

import com.example.vnolib.command.BaseCommand;
import com.example.vnolib.command.ascommands.COCommand;
import com.example.vnolib.command.ascommands.RPSCommand;

import java.security.NoSuchAlgorithmException;
import java.util.concurrent.LinkedBlockingQueue;

public class ASConnection extends ServerConnection {

    public ASConnection(String host, Integer port, CommandHandler handler) {
        super(host, port, handler);
    }

    public ASConnection(String host, Integer port, LinkedBlockingQueue<BaseCommand> commandsToReadReference, CommandHandler handler) {
        super(host, port, commandsToReadReference, handler);
    }

    public void sendLoginRequest(String login, String password) throws NoSuchAlgorithmException {
        sendCommand(new COCommand(login, password));
    }

    public void sendServerRequest(int index) {
        sendCommand(new RPSCommand(index));
    }
}
