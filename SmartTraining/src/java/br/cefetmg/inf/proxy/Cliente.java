/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.cefetmg.inf.proxy;

import br.cefetmg.inf.util.Pacote;
import com.google.gson.Gson;
import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.net.SocketException;
import java.net.UnknownHostException;
import java.nio.charset.Charset;
import java.util.Arrays;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author gabriel
 */
public class Cliente {

    private static Cliente instanciaUnica;

    private final DatagramSocket socketCliente;
    private final String servidor;
    private final int porta;
    private final InetAddress IPAddress;

    private Cliente() throws SocketException, UnknownHostException {
        socketCliente = new DatagramSocket();
        servidor = "localhost";
        porta = 8080;
        IPAddress = InetAddress.getByName(servidor);
    }

    public static Cliente getInstancia() throws SocketException, UnknownHostException {
        if (instanciaUnica == null) {
            instanciaUnica = new Cliente();
        }

        return instanciaUnica;
    }

    public Pacote requisicao(Pacote pacoteTemporario) {

        Gson gson = new Gson();

        String json = gson.toJson(pacoteTemporario);
        byte[] bufferEnviado = json.getBytes(Charset.forName("UTF-8"));
        byte[] bufferRecebido = new byte[1024];
        Pacote pacoteRetorno = new Pacote(null, null);
        
        try {
            DatagramPacket pacoteEnviado = new DatagramPacket(bufferEnviado, json.length());
            socketCliente.send(pacoteEnviado);
            DatagramPacket pacoteRecebido = new DatagramPacket(bufferRecebido, 1024);
            socketCliente.receive(pacoteRecebido);
            
            bufferRecebido = pacoteRecebido.getData();
            
            pacoteRetorno = gson.fromJson(Arrays.toString(bufferRecebido), Pacote.class);

        } catch (IOException ex) {
            Logger.getLogger(Cliente.class.getName()).log(Level.SEVERE, null, ex);
        }
        return pacoteRetorno;
    }
}
