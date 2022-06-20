package com.example.vnolib;

import com.example.vnolib.client.Client;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class MyClass {

    public static void main(String[] args) {
        try {
            Client client = new Client();
            client.startCommandHandler();
            client.connectToMaster();
            Thread.sleep(1000);
            client.disconnectFromMaster();
            client.stopCommandHandler();
            log.info("hype");
//            client.authenticate("Udalny", "***REMOVED***");
//            client.requestServers();
//            Thread.sleep(10000);
//            log.debug("Servers: {}", client.getServers());
//            client.connectToServer(client.getServers().get(1));
//            Thread.sleep(4000);
//            client.requestCharacters();
//            client.requestTracks();
//            client.requestAreas();
//            Thread.sleep(400000);
        } catch (Exception ex) {
            log.error("main: ", ex);
        }
        log.info("exiting main");
    }
}