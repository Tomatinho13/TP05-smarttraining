/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.cefetmg.inf.proxy;

import br.cefetmg.inf.model.domain.Musculo;
import br.cefetmg.inf.model.services.IManterMusculo;
import br.cefetmg.inf.util.Pacote;
import br.cefetmg.inf.util.TipoOperacao;
import com.google.gson.Gson;
import java.sql.SQLException;
import java.util.ArrayList;

/**
 *
 * @author felipe
 */
public class ManterMusculoProxy implements IManterMusculo{
    
    @Override
    public Musculo pesquisarPorCodigo(int codMusculo) throws SQLException{
        Pacote pacoteEnviado;
        Pacote pacoteRecebido;
        
        Gson gson = new Gson();
        
        pacoteEnviado = new Pacote(TipoOperacao.PESQ_MUSCULO, gson.toJson(codMusculo));
        
        pacoteRecebido = cliente.request(pacoteEnviado);
        Musculo musculo = gson.fromJson(pacoteRecebido.getDados(), Musculo.class);
        return musculo;
    }
    
    @Override
    public ArrayList <Musculo> pesquisarTodos() throws SQLException{
        Pacote pacoteEnviado;
        Pacote pacoteRecebido;
        
        Gson gson = new Gson();
        
        pacoteEnviado = new Pacote(TipoOperacao.LISTA_MUSCULO, null);
        
        pacoteRecebido = cliente.request(pacoteEnviado);
        ArrayList<Musculo> listaMusculos = gson.fromJson(pacoteRecebido.getDados(), ArrayList.class);
        return listaMusculos;
    }
    
    @Override
    public void cadastrar(Musculo musculo) throws SQLException{
        Pacote pacoteEnviado;
        Pacote pacoteRecebido;
        
        Gson gson = new Gson();
        
        pacoteEnviado = new Pacote(TipoOperacao.CAD_MUSCULO, gson.toJson(musculo));
        
        cliente.request(pacoteEnviado);
    }

    @Override
    public void alterar(Musculo musculo) throws SQLException{
        Pacote pacoteEnviado;
        Pacote pacoteRecebido;
        
        Gson gson = new Gson();
        
        pacoteEnviado = new Pacote(TipoOperacao.ALTERA_MUSCULO, gson.toJson(musculo));
        
        cliente.request(pacoteEnviado);
    }

    @Override
    public void excluir(int codMusculo) throws SQLException{
        Pacote pacoteEnviado;
        Pacote pacoteRecebido;
        
        Gson gson = new Gson();
        
        pacoteEnviado = new Pacote(TipoOperacao.EXCLUI_MUSCULO, gson.toJson(codMusculo));
        
        cliente.request(pacoteEnviado);
    }
}
