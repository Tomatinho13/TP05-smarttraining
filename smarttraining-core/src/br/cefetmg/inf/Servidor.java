/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.cefetmg.inf;

import br.cefetmg.inf.util.Pacote;
import com.google.gson.Gson;
import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.net.SocketException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author gabriel
 */
public class Servidor {

    private static DatagramSocket socketServidor;
    private static int porta;

    public static void main(String[] args) throws SocketException {
        porta = 8080;
        socketServidor = new DatagramSocket(porta);
        while (true) {
            recebeDados();
        }
    }

    private static synchronized void recebeDados() {
        byte[] dadosRecebidos = new byte[1024];
        Gson gson = new Gson();

        DatagramPacket pacoteRecebido = new DatagramPacket(dadosRecebidos, 1024);

        try {
            socketServidor.receive(pacoteRecebido);
        } catch (IOException ex) {
            Logger.getLogger(Servidor.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public static void enviaDados(InetAddress enderecoIP, int portaCliente, Pacote pacoteResposta) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
}
