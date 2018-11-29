package br.cefetmg.inf.client;

import java.rmi.NotBoundException;
import java.rmi.registry.LocateRegistry;
import java.rmi.RemoteException;
import java.rmi.registry.Registry;
import java.util.logging.Level;
import java.util.logging.Logger;

public class ClientRMI {

    private static ClientRMI cliente;
    private Registry registro;
    
    private ClientRMI() {
        try {
            registro = LocateRegistry.getRegistry("Localhost", 2345);
        } catch (RemoteException e) {
            Logger.getLogger(ClientRMI.class.getName()).log(Level.SEVERE, null, e);
        }
    }
    
    public static ClientRMI getInstancia() {
        if (cliente == null) {
            cliente = new ClientRMI();
        }
        return cliente;
    }

    public Object recebeObjeto(String tipoObjeto) {
        try {
            return registro.lookup(tipoObjeto);
        } catch (RemoteException | NotBoundException e) {
            Logger.getLogger(ClientRMI.class.getName()).log(Level.SEVERE, null, e);
        }
        return null;
    }
}
