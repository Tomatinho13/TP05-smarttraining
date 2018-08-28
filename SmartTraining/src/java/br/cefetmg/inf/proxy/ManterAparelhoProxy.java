/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.cefetmg.inf.proxy;

import br.cefetmg.inf.model.domain.Aparelho;
import br.cefetmg.inf.model.services.IManterAparelho;
import br.cefetmg.inf.util.Pacote;
import br.cefetmg.inf.util.TipoOperacao;
import com.google.gson.Gson;
import java.sql.SQLException;
import java.util.ArrayList;

/**
 *
 * @author gabriel
 */
public class ManterAparelhoProxy implements IManterAparelho{

    @Override
    public Aparelho pesquisar(int nroAparelho) throws SQLException {
        Pacote pacoteEnviado;
        Pacote pacoteRecebido;
        
        Gson gson = new Gson();
        
        pacoteEnviado = new Pacote(TipoOperacao.PESQ_APARELHO_NUM, gson.toJson(nroAparelho));
        
        pacoteRecebido = cliente.request(pacoteEnviado);
        Aparelho aparelho = gson.fromJson(pacoteRecebido.getDados(), Aparelho.class);
        return aparelho;
    }

    @Override
    public Aparelho pesquisar(String nomAparelho) throws SQLException {
        Pacote pacoteEnviado;
        Pacote pacoteRecebido;
        
        Gson gson = new Gson();
        
        pacoteEnviado = new Pacote(TipoOperacao.PESQ_APARELHO_NOME, gson.toJson(nomAparelho));
        
        pacoteRecebido = cliente.request(pacoteEnviado);
        Aparelho aparelho = gson.fromJson(pacoteRecebido.getDados(), Aparelho.class);
        return aparelho;
    }

    @Override
    public ArrayList<Aparelho> pesquisarTodos() throws SQLException {
        Pacote pacoteEnviado;
        Pacote pacoteRecebido;
        
        Gson gson = new Gson();
        
        pacoteEnviado = new Pacote(TipoOperacao.LISTA_APARELHO, null);
        
        pacoteRecebido = cliente.request(pacoteEnviado);
        ArrayList<Aparelho> listaAparelhos = gson.fromJson(pacoteRecebido.getDados(), ArrayList.class);
        return listaAparelhos;
    }

    @Override
    public void cadastrar(Aparelho aparelho) throws SQLException {
        Pacote pacoteEnviado;
        Pacote pacoteRecebido;
        
        Gson gson = new Gson();
        
        pacoteEnviado = new Pacote(TipoOperacao.CAD_APARELHO, gson.toJson(aparelho));
        
        cliente.request(pacoteEnviado);
    }

    @Override
    public void alterar(Aparelho aparelho) throws SQLException {
        Pacote pacoteEnviado;
        Pacote pacoteRecebido;
        
        Gson gson = new Gson();
        
        pacoteEnviado = new Pacote(TipoOperacao.ALTERA_APARELHO, gson.toJson(aparelho));
        
        cliente.request(pacoteEnviado);
    }

    @Override
    public void excluir(int nroAparelho) throws SQLException {
        Pacote pacoteEnviado;
        Pacote pacoteRecebido;
        
        Gson gson = new Gson();
        
        pacoteEnviado = new Pacote(TipoOperacao.EXCLUI_APARELHO, gson.toJson(nroAparelho));
        
        cliente.request(pacoteEnviado);
    }
    
}
