/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.cefetmg.inf.proxy;

import br.cefetmg.inf.model.domain.RegiaoCorporal;
import br.cefetmg.inf.model.services.IManterRegiaoCorporal;
import br.cefetmg.inf.util.Pacote;
import br.cefetmg.inf.util.TipoOperacao;
import com.google.gson.Gson;
import java.sql.SQLException;

/**
 *
 * @author felipe
 */
public class ManterRegiaoCorporalProxy implements IManterRegiaoCorporal{

    @Override
    public RegiaoCorporal pesquisarRegiaoCorporal(int codRegiao) throws SQLException {
        Pacote pacoteEnviado;
        Pacote pacoteRecebido;
        
        Gson gson = new Gson();
        
        pacoteEnviado = new Pacote(TipoOperacao.PESQ_REGCORP, gson.toJson(codRegiao));
        
        pacoteRecebido = cliente.request(pacoteEnviado);
        RegiaoCorporal regCorp = gson.fromJson(pacoteRecebido.getDados(), RegiaoCorporal.class);
        return regCorp;
    }

    @Override
    public void cadastrar(RegiaoCorporal regiaoCorporal, int codMusculo) throws SQLException {
        Pacote pacoteEnviado;
        Pacote pacoteRecebido;
        
        Gson gson = new Gson();
        
        //MAIS DE UM PARAMETRO
        pacoteEnviado = new Pacote(TipoOperacao.CAD_REGCORP, gson.toJson(regiaoCorporal));
        
        cliente.request(pacoteEnviado);
    }

    @Override
    public void alterar(RegiaoCorporal regiaoCorporal) throws SQLException {
        Pacote pacoteEnviado;
        Pacote pacoteRecebido;
        
        Gson gson = new Gson();
        
        pacoteEnviado = new Pacote(TipoOperacao.ALTERA_REGCORP, gson.toJson(regiaoCorporal));
        
        cliente.request(pacoteEnviado);
    }

    @Override
    public void excluir(int codRegiao) throws SQLException {
        Pacote pacoteEnviado;
        Pacote pacoteRecebido;
        
        Gson gson = new Gson();
        
        pacoteEnviado = new Pacote(TipoOperacao.EXCLUI_REGCORP, gson.toJson(codRegiao));
        
        cliente.request(pacoteEnviado);
    }
    
}
