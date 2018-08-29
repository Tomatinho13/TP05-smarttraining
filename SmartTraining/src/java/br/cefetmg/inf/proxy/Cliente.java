/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.cefetmg.inf.proxy;

import br.cefetmg.inf.util.Pacote;
import com.google.gson.Gson;
import com.google.gson.stream.JsonReader;
import java.io.IOException;
import java.io.StringReader;
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
    private final InetAddress enderecoIP;

    private Cliente() throws SocketException, UnknownHostException {
        socketCliente = new DatagramSocket();
        servidor = "localhost";
        porta = 6969;
        enderecoIP = InetAddress.getByName(servidor);
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
        Pacote pacote = new Pacote(null, null);

        try {
            DatagramPacket pacoteEnviado = new DatagramPacket(bufferEnviado, json.length(), enderecoIP, porta);
            socketCliente.send(pacoteEnviado);
            
            DatagramPacket pacoteRecebido = new DatagramPacket(bufferRecebido, 1024);
            socketCliente.receive(pacoteRecebido);

            bufferRecebido = pacoteRecebido.getData();

            JsonReader leitor = new JsonReader(new StringReader(new String(bufferRecebido)));
            leitor.setLenient(true);
            pacote = gson.fromJson(leitor, Pacote.class);
            
        } catch (IOException ex) {
            Logger.getLogger(Cliente.class.getName()).log(Level.SEVERE, null, ex);
        }
        return pacote;
    }
}
