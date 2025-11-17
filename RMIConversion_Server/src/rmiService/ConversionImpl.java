package rmiService;

import java.rmi.server.UnicastRemoteObject;
import java.rmi.RemoteException;

public class ConversionImpl extends UnicastRemoteObject implements IConversion {
    public ConversionImpl() throws RemoteException {}
    public double convertirMontant(double mt) throws RemoteException {
        // Exemple: taux conversion euro -> dinar = 3.3
        return mt * 3.3;
    }
}
