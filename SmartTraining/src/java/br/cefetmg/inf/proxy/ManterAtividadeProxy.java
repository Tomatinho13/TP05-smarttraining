/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.cefetmg.inf.proxy;

import br.cefetmg.inf.model.domain.Atividade;
import br.cefetmg.inf.model.services.IManterAtividade;
import br.cefetmg.inf.util.Pacote;
import br.cefetmg.inf.util.TipoOperacao;
import com.google.gson.Gson;
import java.sql.SQLException;

/**
 *
 * @author felipe
 */
public class ManterAtividadeProxy implements IManterAtividade{

    @Override
    public Atividade pesquisar(String codCpf, int nroTreino, int codExercicio, int nroAparelho, int nroFicha) throws SQLException {
        Pacote pacoteEnviado;
        Pacote pacoteRecebido;
        
        Gson gson = new Gson();
        
        //MAIS DE UM PARAMETRO
        pacoteEnviado = new Pacote(TipoOperacao.PESQ_ATIVIDADE, gson.toJson(codCpf));
        
        pacoteRecebido = cliente.request(pacoteEnviado);
        Atividade atividade = gson.fromJson(pacoteRecebido.getDados(), Atividade.class);
        return atividade;
    }

    @Override
    public void cadastrar(Atividade atividade) throws SQLException {
        Pacote pacoteEnviado;
        Pacote pacoteRecebido;
        
        Gson gson = new Gson();
        
        pacoteEnviado = new Pacote(TipoOperacao.CAD_ATIVIDADE, gson.toJson(atividade));
        
        cliente.request(pacoteEnviado);
    }

    @Override
    public void alterar(Atividade atividade) throws SQLException {
        Pacote pacoteEnviado;
        Pacote pacoteRecebido;
        
        Gson gson = new Gson();
        
        pacoteEnviado = new Pacote(TipoOperacao.ALTERA_ATIVIDADE, gson.toJson(atividade));
        
        cliente.request(pacoteEnviado);
    }

    @Override
    public void excluir(String codCpf, int nroTreino, int codExercicio, int nroAparelho, int nroFicha) throws SQLException {
        Pacote pacoteEnviado;
        Pacote pacoteRecebido;
        
        Gson gson = new Gson();
        
        //MAIS DE UM PARAMETRO
        pacoteEnviado = new Pacote(TipoOperacao.EXCLUI_ATIVIDADE, gson.toJson(codCpf));
        
        cliente.request(pacoteEnviado);
    }
    
}
