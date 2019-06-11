package client;

import server.RemoteServer;

import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.util.Scanner;

public class Client {
    private String name;

    private Client(String name){
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public static void main(String... args) throws Exception {
        Registry registry = LocateRegistry.getRegistry("localhost", 8800);
        RemoteServer service = (RemoteServer) registry.lookup("pp_task/VFS");
        Scanner scanner = new Scanner(System.in);
        RemoteClient client = new RemoteClientImpl(scanner.nextLine());
        service.registerClient(client);
        String command;
        while(true){
            command = scanner.nextLine();
            if(command.equals("quit")){
                System.out.println("Close by" + client.getName());
                System.exit(0);
                break;
            }
            service.commandProcessing(command, client.getName());
        }
    }
}