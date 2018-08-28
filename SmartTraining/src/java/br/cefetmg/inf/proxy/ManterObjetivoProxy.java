/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.cefetmg.inf.proxy;

import br.cefetmg.inf.model.domain.Objetivo;
import br.cefetmg.inf.model.services.IManterObjetivo;
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
public class ManterObjetivoProxy implements IManterObjetivo {

    @Override
    public Objetivo pesquisarPorCodigo(int codObjetivo) throws SQLException {
        Pacote pacoteEnviado;
        Pacote pacoteRecebido;
        
        Gson gson = new Gson();
        
        pacoteEnviado = new Pacote(TipoOperacao.PESQ_OBJETIVO_COD, gson.toJson(codObjetivo));
        
        pacoteRecebido = cliente.request(pacoteEnviado);
        Objetivo objetivo = gson.fromJson(pacoteRecebido.getDados(), Objetivo.class);
        return objetivo;
    }

    @Override
    public Objetivo pesquisarPorNome(String nome) throws SQLException {
        Pacote pacoteEnviado;
        Pacote pacoteRecebido;
        
        Gson gson = new Gson();
        
        pacoteEnviado = new Pacote(TipoOperacao.PESQ_OBJETIVO_NOME, gson.toJson(nome));
        
        pacoteRecebido = cliente.request(pacoteEnviado);
        Objetivo objetivo = gson.fromJson(pacoteRecebido.getDados(), Objetivo.class);
        return objetivo;
    }

    @Override
    public ArrayList<Objetivo> pesquisarPorAvaliacao(String codCpf, LocalDate dataAvaliacao) throws SQLException {
        Pacote pacoteEnviado;
        Pacote pacoteRecebido;
        
        Gson gson = new Gson();
        
        //MAIS DE UM PARAMETRO
        pacoteEnviado = new Pacote(TipoOperacao.LISTA_OBJETIVO_AVALIACAO, gson.toJson(codCpf));
        
        pacoteRecebido = cliente.request(pacoteEnviado);
        ArrayList<Objetivo> listaObjetivos = gson.fromJson(pacoteRecebido.getDados(), ArrayList.class);
        return listaObjetivos;
    }

    @Override
    public ArrayList<Objetivo> pesquisarTodos() throws SQLException {
        Pacote pacoteEnviado;
        Pacote pacoteRecebido;
        
        Gson gson = new Gson();
        
        pacoteEnviado = new Pacote(TipoOperacao.LISTA_OBJETIVO, null);
        
        pacoteRecebido = cliente.request(pacoteEnviado);
        ArrayList<Objetivo> listaObjetivos = gson.fromJson(pacoteRecebido.getDados(), ArrayList.class);
        return listaObjetivos;
    }

    @Override
    public void cadastrar(Objetivo objetivo) throws SQLException {
        Pacote pacoteEnviado;
        Pacote pacoteRecebido;
        
        Gson gson = new Gson();
        
        pacoteEnviado = new Pacote(TipoOperacao.CAD_OBJETIVO, gson.toJson(objetivo));
        
        cliente.request(pacoteEnviado);
    }

    @Override
    public void alterar(Objetivo objetivo) throws SQLException {
        Pacote pacoteEnviado;
        Pacote pacoteRecebido;
        
        Gson gson = new Gson();
        
        pacoteEnviado = new Pacote(TipoOperacao.ALTERA_OBJETIVO, gson.toJson(objetivo));
        
        cliente.request(pacoteEnviado);
    }

    @Override
    public void excluir(int codObjetivo) throws SQLException {
        Pacote pacoteEnviado;
        Pacote pacoteRecebido;
        
        Gson gson = new Gson();
        
        pacoteEnviado = new Pacote(TipoOperacao.EXCLUI_MUSCULO, gson.toJson(codObjetivo));
        
        cliente.request(pacoteEnviado);
    }
    
}
