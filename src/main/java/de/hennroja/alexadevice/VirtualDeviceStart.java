package de.hennroja.alexadevice;

import de.hennroja.alexadevice.upnp.BelkinWeMoServer;

/**
 * Created by robinhenniges on 02.02.17.
 */
public class VirtualDeviceStart {

    public static void main(String[] args) throws Exception {
        Thread serverThread = new Thread(new BelkinWeMoServer());
        serverThread.setDaemon(false);
        serverThread.start();
    }

}
