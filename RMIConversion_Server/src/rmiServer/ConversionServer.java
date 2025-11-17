package rmiServer;

import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;

import rmiService.ConversionImpl;
import rmiService.IConversion;

public class ConversionServer {
    public static void main(String[] args) {
        try {

            LocateRegistry.createRegistry(1099);

            IConversion conversion = new ConversionImpl();

            Registry registry = LocateRegistry.getRegistry();
            registry.rebind("ConversionService", conversion);
            System.out.println("Service Conversion lancé !");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
