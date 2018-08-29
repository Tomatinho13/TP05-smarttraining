/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.cefetmg.inf;

import br.cefetmg.inf.adapter.AdapterService;
import br.cefetmg.inf.util.Pacote;
import com.google.gson.Gson;
import com.google.gson.stream.JsonReader;
import java.io.IOException;
import java.io.StringReader;
import java.io.UnsupportedEncodingException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.net.SocketException;
import java.util.Arrays;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author gabriel
 */
public class Servidor {

    private static DatagramSocket socketServidor;
    private static InetAddress enderecoIP;
    private static int porta;

    public static void main(String[] args) throws SocketException {
        porta = 6969;
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
            enderecoIP = pacoteRecebido.getAddress();
            porta = pacoteRecebido.getPort();
        } catch (IOException ex) {
            Logger.getLogger(Servidor.class.getName()).log(Level.SEVERE, null, ex);
        }

        dadosRecebidos = pacoteRecebido.getData();

        JsonReader leitor = new JsonReader(new StringReader(new String(dadosRecebidos)));
        leitor.setLenient(true);
        
        Pacote pacote = gson.fromJson(leitor, Pacote.class);
        
        AdapterService adapter = new AdapterService(enderecoIP, porta, pacote);
        Thread threadAdapter = new Thread(adapter);
        threadAdapter.start();
    }

    public static void enviaDados(InetAddress enderecoIP, int portaCliente, Pacote pacoteTemporario) {
        byte[] dadosEnviados;
        Gson gson = new Gson();
        
        dadosEnviados = gson.toJson(pacoteTemporario).getBytes();
        
        DatagramPacket pacoteResposta = new DatagramPacket(dadosEnviados, dadosEnviados.length, enderecoIP, porta);
        try {
            socketServidor.send(pacoteResposta);
        } catch (IOException ex) {
            Logger.getLogger(Servidor.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
