package server;

import client.RemoteClient;

import java.rmi.RemoteException;

public interface RemoteServer {
    Object commandProcessing(String command, String name);
    void registerClient(RemoteClient client) throws RemoteException;
}

