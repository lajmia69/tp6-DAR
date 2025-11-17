package rmiServer;

import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import rmiService.ConversionImpl;

public class ConversionServer {

    public static void main(String[] args) {
        try {
            // 1. Instancier l'objet distant (l'implémentation du service)
            ConversionImpl conv = new ConversionImpl();

            // 2. Récupérer la référence du Registry RMI existant sur le port 1099
            // NOTE: Le Registry doit être lancé manuellement (rmiregistry 1099) avant le serveur.
            Registry registry = LocateRegistry.getRegistry("localhost", 1099);

            // 3. Publier la référence de cet objet dans l'annuaire (RMIRegistry)
            registry.rebind("SERVEUR_CONVERSION", conv);

            System.out.println("Serveur RMI lancé et objet 'SERVEUR_CONVERSION' publié !");

        } catch (Exception e) {
            System.err.println("Erreur de lancement du Serveur RMI: " + e.getMessage());
            e.printStackTrace();
        }
    }
}