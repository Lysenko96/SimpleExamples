package info.lysenko.anton.patterns.rmi;

import java.rmi.Naming;
import java.rmi.server.UnicastRemoteObject;

public class MyRemoteImpl extends UnicastRemoteObject implements MyRemote {

    private static final long serialVersionUID = 1L;

    protected MyRemoteImpl() throws java.rmi.RemoteException {
    }

    @Override
    public String sayHello() {
        return "Hello World!";
    }

    public static void main(String[] args) {
        try {
            MyRemoteImpl service = new MyRemoteImpl();
            Naming.rebind("RemoteHello", service);
        } catch (Exception e){
            e.printStackTrace();
        }
    }
}
