/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.cefetmg.inf.proxy;

import br.cefetmg.inf.model.domain.Ficha;
import br.cefetmg.inf.model.services.IManterFicha;
import br.cefetmg.inf.util.Pacote;
import br.cefetmg.inf.util.TipoOperacao;
import com.google.gson.Gson;
import java.sql.SQLException;
import java.util.ArrayList;

/**
 *
 * @author felipe
 */
public class ManterFichaProxy implements IManterFicha{

    @Override
    public Ficha pesquisarPorCodigo(String codCpf, int nroFicha) throws SQLException {
        Pacote pacoteEnviado;
        Pacote pacoteRecebido;
        
        Gson gson = new Gson();
        
        //MAIS DE UM PARAMETRO
        pacoteEnviado = new Pacote(TipoOperacao.PESQ_FICHA, gson.toJson(codCpf));
        
        pacoteRecebido = cliente.request(pacoteEnviado);
        Ficha ficha = gson.fromJson(pacoteRecebido.getDados(), Ficha.class);
        return ficha;
    }

    @Override
    public ArrayList<Ficha> pesquisarPorAluno(String codCpf) throws SQLException {
        Pacote pacoteEnviado;
        Pacote pacoteRecebido;
        
        Gson gson = new Gson();
        
        //MAIS DE UM PARAMETRO
        pacoteEnviado = new Pacote(TipoOperacao.LISTA_FICHA_ALUNO, gson.toJson(codCpf));
        
        pacoteRecebido = cliente.request(pacoteEnviado);
        ArrayList<Ficha> listaFichas = gson.fromJson(pacoteRecebido.getDados(), ArrayList.class);
        return listaFichas;
    }

    @Override
    public void cadastrar(Ficha ficha) throws SQLException {
        Pacote pacoteEnviado;
        Pacote pacoteRecebido;
        
        Gson gson = new Gson();
        
        pacoteEnviado = new Pacote(TipoOperacao.CAD_FICHA, gson.toJson(ficha));
        
        cliente.request(pacoteEnviado);
    }

    @Override
    public void alterar(Ficha ficha) throws SQLException {
        Pacote pacoteEnviado;
        Pacote pacoteRecebido;
        
        Gson gson = new Gson();
        
        pacoteEnviado = new Pacote(TipoOperacao.ALTERA_FICHA, gson.toJson(ficha));
        
        cliente.request(pacoteEnviado);
    }

    @Override
    public void excluir(String codCpf, int nroFicha) throws SQLException {
        Pacote pacoteEnviado;
        Pacote pacoteRecebido;
        
        Gson gson = new Gson();
        
        //MAIS DE UM PARAMETRO
        pacoteEnviado = new Pacote(TipoOperacao.EXCLUI_FICHA, gson.toJson(nroFicha));
        
        cliente.request(pacoteEnviado);
    }
    
}
