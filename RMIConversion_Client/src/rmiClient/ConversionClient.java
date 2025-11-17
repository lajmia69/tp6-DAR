package rmiClient;

import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import rmiService.IConversion; // Nécessite l'interface dans le JAR

public class ConversionClient {

    public static void main(String[] args) {
        try {
            double montantAEu = 500;
            
            // 1. Chercher le Registry RMI sur le port 1099
            Registry registry = LocateRegistry.getRegistry("localhost", 1099);

            // 2. Chercher la référence vers l'objet distant (le stub)
            IConversion stub = (IConversion) registry.lookup("SERVEUR_CONVERSION");

            // 3. Invoquer la méthode distante
            double res = stub.convertirMontant(montantAEu);

            System.out.println(montantAEu + " euros = " + res + " dinars");
            
        } catch (Exception e) {
            System.err.println("Erreur lors de l'exécution du Client RMI.");
            e.printStackTrace();
        }
    }
}