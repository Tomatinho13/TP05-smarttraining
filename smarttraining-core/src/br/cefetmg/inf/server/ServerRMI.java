package br.cefetmg.inf.server;

import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import br.cefetmg.inf.model.services.*;
import br.cefetmg.inf.model.adapter.*;
import java.rmi.NoSuchObjectException;
import java.rmi.server.UnicastRemoteObject;
import java.util.logging.Level;
import java.util.logging.Logger;

public class ServerRMI {

    private static Registry registro;

    private static IManterUsuario manterAlunoStub;
    private static IManterUsuario manterInstrutorStub;
    private static IManterUsuario manterUsuarioStub;
    private static IManterAparelho manterAparelhoStub;
    private static IManterAtividade manterAtividadeStub;
    private static IManterAvaliacao manterAvaliacaoStub;
    private static IManterDiaTreino manterDiaTreinoStub;
    private static IManterExercicio manterExercicioStub;
    private static IManterFicha manterFichaStub;
    private static IManterMusculo manterMusculoStub;
    private static IManterObjetivo manterObjetivoStub;
    private static IManterRegiaoCorporal manterRegiaoCorporalStub;
    private static IManterTreino manterTreinoStub;

    public static void main(String[] args) {
        if (System.getSecurityManager() == null) {
            System.setSecurityManager(new SecurityManager());
        }

        try {
            registro = iniciaRegistro();
            cadastraStubs();
        } catch (InterruptedException | RemoteException e) {
            Logger.getLogger(ServerRMI.class.getName()).log(Level.SEVERE, null, e);
        }
    }

    private static Registry iniciaRegistro() throws InterruptedException, RemoteException {
        if (LocateRegistry.getRegistry(4000) != null) {
            return LocateRegistry.createRegistry(4000);
        } else {
            return LocateRegistry.getRegistry(4000);
        }
    }

    private static void cadastraStubs() throws RemoteException {

        manterAlunoStub = (IManterUsuario) UnicastRemoteObject.exportObject(new ManterAlunoAdapter(), 0);
        registro.rebind("ManterAluno", manterAlunoStub);

        manterInstrutorStub = (IManterUsuario) UnicastRemoteObject.exportObject(new ManterInstrutorAdapter(), 0);
        registro.rebind("ManterInstrutor", manterInstrutorStub);

        manterUsuarioStub = (IManterUsuario) UnicastRemoteObject.exportObject(new ManterUsuarioAdapter(), 0);
        registro.rebind("ManterUsuario", manterUsuarioStub);

        manterAparelhoStub = (IManterAparelho) UnicastRemoteObject.exportObject(new ManterAparelhoAdapter(), 0);
        registro.rebind("ManterAparelho", manterAparelhoStub);

        manterAtividadeStub = (IManterAtividade) UnicastRemoteObject.exportObject(new ManterAtividadeAdapter(), 0);
        registro.rebind("ManterAtividade", manterAtividadeStub);

        manterAvaliacaoStub = (IManterAvaliacao) UnicastRemoteObject.exportObject(new ManterAvaliacaoAdapter(), 0);
        registro.rebind("ManterAvaliacao", manterAvaliacaoStub);

        manterDiaTreinoStub = (IManterDiaTreino) UnicastRemoteObject.exportObject(new ManterDiaTreinoAdapter(), 0);
        registro.rebind("ManterDiaTreino", manterDiaTreinoStub);

        manterExercicioStub = (IManterExercicio) UnicastRemoteObject.exportObject(new ManterExercicioAdapter(), 0);
        registro.rebind("ManterExercicio", manterExercicioStub);

        manterFichaStub = (IManterFicha) UnicastRemoteObject.exportObject(new ManterFichaAdapter(), 0);
        registro.rebind("ManterFicha", manterFichaStub);

        manterMusculoStub = (IManterMusculo) UnicastRemoteObject.exportObject(new ManterMusculoAdapter(), 0);
        registro.rebind("ManterMusculo", manterMusculoStub);

        manterObjetivoStub = (IManterObjetivo) UnicastRemoteObject.exportObject(new ManterObjetivoAdapter(), 0);
        registro.rebind("ManterObjetivo", manterObjetivoStub);

        manterRegiaoCorporalStub = (IManterRegiaoCorporal) UnicastRemoteObject.exportObject(new ManterRegiaoCorporalAdapter(), 0);
        registro.rebind("ManterRegiaoCorporal", manterRegiaoCorporalStub);

        manterTreinoStub = (IManterTreino) UnicastRemoteObject.exportObject(new ManterTreinoAdapter(), 0);
        registro.rebind("ManterTreino", manterTreinoStub);

    }

    private static void removeStubs() throws NoSuchObjectException {
        UnicastRemoteObject.unexportObject(registro, true);
    }
}
