/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.cefetmg.inf.proxy;

import br.cefetmg.inf.model.domain.Treino;
import br.cefetmg.inf.model.services.IManterTreino;
import br.cefetmg.inf.util.Pacote;
import br.cefetmg.inf.util.TipoOperacao;
import com.google.gson.Gson;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author felipe
 */
public class ManterTreinoProxy implements IManterTreino{

    @Override
    public Treino pesquisarTreino(String cpf, int nroFicha, int nroTreino) throws SQLException {
        Pacote pacoteEnviado;
        Pacote pacoteRecebido;
        
        Gson gson = new Gson();
        
        //MAIS DE UM PARAMETRO
        pacoteEnviado = new Pacote(TipoOperacao.PESQ_TREINO, gson.toJson(cpf));
        
        pacoteRecebido = cliente.request(pacoteEnviado);
        Treino treino = gson.fromJson(pacoteRecebido.getDados(), Treino.class);
        return treino;
    }

    @Override
    public List<Treino> pesquisarPorFicha(String cpf, int nroFicha) throws SQLException {
        Pacote pacoteEnviado;
        Pacote pacoteRecebido;
        
        Gson gson = new Gson();
        
        //MAIS DE UM PARAMETRO
        pacoteEnviado = new Pacote(TipoOperacao.LISTA_TREINO_FICHA, gson.toJson(cpf));
        
        pacoteRecebido = cliente.request(pacoteEnviado);
        ArrayList<Treino> listaTreinos = gson.fromJson(pacoteRecebido.getDados(), ArrayList.class);
        return listaTreinos;
    }

    @Override
    public void cadastrar(Treino treino) throws SQLException {
        Pacote pacoteEnviado;
        Pacote pacoteRecebido;
        
        Gson gson = new Gson();
        
        pacoteEnviado = new Pacote(TipoOperacao.CAD_TREINO, gson.toJson(treino));
        
        cliente.request(pacoteEnviado);
    }

    @Override
    public void alterar(Treino treino) throws SQLException {
        Pacote pacoteEnviado;
        Pacote pacoteRecebido;
        
        Gson gson = new Gson();
        
        pacoteEnviado = new Pacote(TipoOperacao.ALTERA_TREINO, gson.toJson(treino));
        
        cliente.request(pacoteEnviado);
    }

    @Override
    public void excluir(String cpf, int nroTreino, int nroFicha) throws SQLException {
        Pacote pacoteEnviado;
        Pacote pacoteRecebido;
        
        Gson gson = new Gson();
        
        //MAIS DE UM PARAMETRO
        pacoteEnviado = new Pacote(TipoOperacao.EXCLUI_TREINO, gson.toJson(cpf));
        
        cliente.request(pacoteEnviado);
    }
    
}
