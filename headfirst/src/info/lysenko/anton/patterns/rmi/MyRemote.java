package info.lysenko.anton.patterns.rmi;


import java.rmi.Remote;

public interface MyRemote extends Remote {

    String sayHello() throws java.rmi.RemoteException;
}
