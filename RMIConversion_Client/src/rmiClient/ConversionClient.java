package rmiClient;

import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import rmiService.IConversion;

public class ConversionClient {

    public static void main(String[] args) {
        try {
            Registry registry = LocateRegistry.getRegistry("localhost", 1099);

            IConversion stub = (IConversion) registry.lookup("SERVEUR_CONVERSION");

            double res = stub.convertirMontant(500);

            System.out.println("500 euros = " + res + " dinars");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
