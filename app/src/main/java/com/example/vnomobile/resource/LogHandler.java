package com.example.vnomobile.resource;

import com.example.vnolib.client.Client;
import com.example.vnolib.client.OnCommand;
import com.example.vnolib.client.model.BoxName;
import com.example.vnolib.command.servercommands.CTCommand;
import com.example.vnolib.command.servercommands.MCCommand;
import com.example.vnolib.command.servercommands.MSCommand;
import com.example.vnomobile.ClientHandler;

import java.util.ArrayList;
import java.util.List;

import lombok.Getter;
import lombok.extern.slf4j.Slf4j;

@Slf4j
public class LogHandler {

    private static LogHandler instance;

    @Getter
    private List<String> oocLog = new ArrayList<>();
    @Getter
    private List<String> icLog = new ArrayList<>();

    private Client client;
    private DataDirectory dataDirectory;

    @OnCommand(CTCommand.class)
    private void onOOCMessage(CTCommand command) {
        log.info("Added to OOC log");
        oocLog.add(String.format("%s: %s", command.getUsername(), command.getMessage()));
    }

    @OnCommand(MSCommand.class)
    private void onICMessage(MSCommand command) {
        BoxName boxName = BoxName.fromString(command.getBoxName());
        String nameToShow = "???";
        try {
            CharacterData characterData =
                    dataDirectory.getCharacterData(command.getCharacterName());
            switch (boxName) {

                case CHARACTER_NAME:
                    nameToShow = characterData.getShowName();
                    break;
                case MYSTERYNAME:
                    nameToShow = characterData.getMysteryName();
                    break;
                case USERNAME:
                    nameToShow = command.getBoxName();
                    break;
            }
        } catch (Exception ex) {
            log.error("Error when writing to log: ", ex);
        }
        String logEntry = String.format("%s: %s", nameToShow, command.getMessage());
        icLog.add(logEntry);
    }

    @OnCommand(MCCommand.class)
    private void onMusicCued(MCCommand command) {
        icLog.add(String.format("%s cue'd a music:%n%s", command.getCharacterName(), command.getTrackName()) +
                (command.getLoopingStatus().isLooping() ? "(looping)" : ""));
    }

    private LogHandler() {
        client = ClientHandler.getClient();
        dataDirectory = ResourceHandler.getInstance().getDirectory();
        client.subscribeToCommand(CTCommand.class, this);
        client.subscribeToCommand(MSCommand.class, this);
    }

    public static void create() {
        if(instance == null) {
            instance = new LogHandler();
        }
    }

    public static LogHandler getInstance() {
        if(instance == null) {
            instance = new LogHandler();
        }
        return instance;
    }
}
