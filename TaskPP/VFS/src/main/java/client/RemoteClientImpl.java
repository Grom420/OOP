package client;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;

public class RemoteClientImpl implements RemoteClient {
    private String name;

    public RemoteClientImpl(String name) throws RemoteException {
        this.name = name;
        UnicastRemoteObject.exportObject(this, 0);
    }

    @Override
    public Object message(String message) {
        System.out.println(message);
        return message;
    }

    @Override
    public String getName() {
        return name;
    }
}
