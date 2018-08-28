/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.cefetmg.inf.proxy;

import br.cefetmg.inf.model.domain.Avaliacao;
import br.cefetmg.inf.model.services.IManterAvaliacao;
import br.cefetmg.inf.util.Pacote;
import br.cefetmg.inf.util.TipoOperacao;
import com.google.gson.Gson;
import java.sql.SQLException;
import java.time.LocalDate;
import java.util.ArrayList;

/**
 *
 * @author felipe
 */
public class ManterAvaliacaoProxy implements IManterAvaliacao{

    @Override
    public ArrayList<Avaliacao> pesquisarPorAluno(String codCpf) throws SQLException {
        Pacote pacoteEnviado;
        Pacote pacoteRecebido;
        
        Gson gson = new Gson();
        
        pacoteEnviado = new Pacote(TipoOperacao.LISTA_AVALIACAO_ALUNO, gson.toJson(codCpf));
        
        pacoteRecebido = cliente.request(pacoteEnviado);
        ArrayList<Avaliacao> listaAvaliacoes = gson.fromJson(pacoteRecebido.getDados(), ArrayList.class);
        return listaAvaliacoes;
    }

    @Override
    public Avaliacao pesquisar(String codCpf, LocalDate data) throws SQLException {
        Pacote pacoteEnviado;
        Pacote pacoteRecebido;
        
        Gson gson = new Gson();
        
        //MAIS DE UM PARAMETRO
        pacoteEnviado = new Pacote(TipoOperacao.PESQ_AVALIACAO, gson.toJson(codCpf));
        
        pacoteRecebido = cliente.request(pacoteEnviado);
        Avaliacao avaliacao = gson.fromJson(pacoteRecebido.getDados(), Avaliacao.class);
        return avaliacao;
    }

    @Override
    public void cadastrar(Avaliacao avaliacao) throws SQLException {
        Pacote pacoteEnviado;
        Pacote pacoteRecebido;
        
        Gson gson = new Gson();
        
        pacoteEnviado = new Pacote(TipoOperacao.CAD_AVALIACAO, gson.toJson(avaliacao));
        
        cliente.request(pacoteEnviado);
    }

    @Override
    public void alterar(Avaliacao avaliacao) throws SQLException {
        Pacote pacoteEnviado;
        Pacote pacoteRecebido;
        
        Gson gson = new Gson();
        
        pacoteEnviado = new Pacote(TipoOperacao.ALTERA_AVALIACAO, gson.toJson(avaliacao));
        
        cliente.request(pacoteEnviado);
    }

    @Override
    public void excluir(String codCpf, LocalDate datAvaliacao) throws SQLException {
        Pacote pacoteEnviado;
        Pacote pacoteRecebido;
        
        Gson gson = new Gson();
        
        //MAIS DE UM PARAMETRO
        pacoteEnviado = new Pacote(TipoOperacao.EXCLUI_AVALIACAO, gson.toJson(codCpf));
        
        cliente.request(pacoteEnviado);
    }
    
}
