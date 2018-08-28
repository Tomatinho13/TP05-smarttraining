/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.cefetmg.inf.proxy;

import br.cefetmg.inf.model.domain.Instrutor;
import br.cefetmg.inf.model.domain.Usuario;
import br.cefetmg.inf.model.services.IManterUsuario;
import br.cefetmg.inf.util.Pacote;
import br.cefetmg.inf.util.TipoOperacao;
import com.google.gson.Gson;
import java.sql.SQLException;
import java.util.ArrayList;

/**
 *
 * @author felipe
 */
public class ManterInstrutorProxy implements IManterUsuario{

    @Override
    public Usuario pesquisarPorCpf(String codCpf) throws SQLException {
        Pacote pacoteEnviado;
        Pacote pacoteRecebido;
        
        Gson gson = new Gson();
        
        pacoteEnviado = new Pacote(TipoOperacao.PESQ_INSTRUTOR_CPF, gson.toJson(codCpf));
        
        pacoteRecebido = cliente.request(pacoteEnviado);
        Instrutor instrutor = gson.fromJson(pacoteRecebido.getDados(), Instrutor.class);
        return instrutor;
    }

    @Override
    public Usuario pesquisarPorNome(String nome) throws SQLException {
        Pacote pacoteEnviado;
        Pacote pacoteRecebido;
        
        Gson gson = new Gson();
        
        pacoteEnviado = new Pacote(TipoOperacao.PESQ_INSTRUTOR_NOME, gson.toJson(nome));
        
        pacoteRecebido = cliente.request(pacoteEnviado);
        Instrutor instrutor = gson.fromJson(pacoteRecebido.getDados(), Instrutor.class);
        return instrutor;
    }

    @Override
    public ArrayList<Usuario> pesquisarTodos() throws SQLException {
        Pacote pacoteEnviado;
        Pacote pacoteRecebido;
        
        Gson gson = new Gson();
        
        pacoteEnviado = new Pacote(TipoOperacao.LISTA_INSTRUTOR, null);
        
        pacoteRecebido = cliente.request(pacoteEnviado);
        ArrayList<Usuario> listaInstrutores = gson.fromJson(pacoteRecebido.getDados(), ArrayList.class);
        return listaInstrutores;
    }

    @Override
    public void cadastrar(Usuario instrutor) throws SQLException {
        Pacote pacoteEnviado;
        Pacote pacoteRecebido;
        
        Gson gson = new Gson();
        
        pacoteEnviado = new Pacote(TipoOperacao.CAD_INSTRUTOR, gson.toJson(instrutor));
        
        cliente.request(pacoteEnviado);
    }

    @Override
    public void alterar(Usuario instrutor) throws SQLException {
        Pacote pacoteEnviado;
        Pacote pacoteRecebido;
        
        Gson gson = new Gson();
        
        pacoteEnviado = new Pacote(TipoOperacao.ALTERA_INSTRUTOR, gson.toJson(instrutor));
        
        cliente.request(pacoteEnviado);
    }

    @Override
    public void excluir(String codCpf) throws SQLException {
        Pacote pacoteEnviado;
        Pacote pacoteRecebido;
        
        Gson gson = new Gson();
        
        pacoteEnviado = new Pacote(TipoOperacao.EXCLUI_INSTRUTOR, gson.toJson(codCpf));
        
        cliente.request(pacoteEnviado);
    }
}