package server;

import client.RemoteClient;

import java.rmi.Remote;
import java.rmi.RemoteException;
import java.rmi.server.ServerNotActiveException;
import java.rmi.server.UnicastRemoteObject;
import java.util.List;

public class Processing implements RemoteServer {
    private volatile List<RemoteClient> clients;
    private volatile RemoteClient client;

    public Processing() throws RemoteException {
        UnicastRemoteObject.exportObject((Remote) this, 0);
    }

    @Override
    public Object commandProcessing(String command, String name) {
        return null;
    }

    @Override
    public void registerClient(RemoteClient client) throws RemoteException {
        clients.add(client);
        System.out.println("added: " + client.getName());
        UnicastRemoteObject.exportObject((Remote) this, 0);
    }
}
