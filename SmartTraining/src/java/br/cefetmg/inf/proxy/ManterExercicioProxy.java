/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.cefetmg.inf.proxy;

import br.cefetmg.inf.model.domain.AparelhoExercicio;
import br.cefetmg.inf.model.domain.Exercicio;
import br.cefetmg.inf.model.services.IManterExercicio;
import br.cefetmg.inf.util.Pacote;
import br.cefetmg.inf.util.TipoOperacao;
import com.google.gson.Gson;
import java.sql.SQLException;
import java.util.ArrayList;

/**
 *
 * @author felipe
 */
public class ManterExercicioProxy implements IManterExercicio{

    @Override
    public Exercicio pesquisarPorCodigo(int codExercicio) throws SQLException {
        Pacote pacoteEnviado;
        Pacote pacoteRecebido;
        
        Gson gson = new Gson();
        
        pacoteEnviado = new Pacote(TipoOperacao.PESQ_EXERCICIO_COD, gson.toJson(codExercicio));
        
        pacoteRecebido = cliente.request(pacoteEnviado);
        Exercicio exercicio = gson.fromJson(pacoteRecebido.getDados(), Exercicio.class);
        return exercicio;
    }

    @Override
    public Exercicio pesquisarPorNome(String nomeExercicio) throws SQLException {
        Pacote pacoteEnviado;
        Pacote pacoteRecebido;
        
        Gson gson = new Gson();
        
        pacoteEnviado = new Pacote(TipoOperacao.PESQ_EXERCICIO_NOME, gson.toJson(nomeExercicio));
        
        pacoteRecebido = cliente.request(pacoteEnviado);
        Exercicio exercicio = gson.fromJson(pacoteRecebido.getDados(), Exercicio.class);
        return exercicio;
    }

    @Override
    public AparelhoExercicio pesquisarAparelhoExercicio(int codExercicio, int nroAparelho) throws SQLException {
        Pacote pacoteEnviado;
        Pacote pacoteRecebido;
        
        Gson gson = new Gson();
        
        //MAIS DE UM PARAMETRO
        pacoteEnviado = new Pacote(TipoOperacao.PESQ_APARELHOEXERCICIO, gson.toJson(codExercicio));
        
        pacoteRecebido = cliente.request(pacoteEnviado);
        AparelhoExercicio aparelhoExercicio = gson.fromJson(pacoteRecebido.getDados(), AparelhoExercicio.class);
        return aparelhoExercicio;
    }

    @Override
    public ArrayList<Exercicio> pesquisarPorRegiao(String nomeRegiao) throws SQLException {
        Pacote pacoteEnviado;
        Pacote pacoteRecebido;
        
        Gson gson = new Gson();
        
        pacoteEnviado = new Pacote(TipoOperacao.LISTA_EXERCICIO_REGIAO, gson.toJson(nomeRegiao));
        
        pacoteRecebido = cliente.request(pacoteEnviado);
        ArrayList<Exercicio> listaExercicios = gson.fromJson(pacoteRecebido.getDados(), ArrayList.class);
        return listaExercicios;
    }

    @Override
    public ArrayList<Exercicio> pesquisarPorMusculo(int codMusculo) throws SQLException {
        Pacote pacoteEnviado;
        Pacote pacoteRecebido;
        
        Gson gson = new Gson();
        
        pacoteEnviado = new Pacote(TipoOperacao.LISTA_EXERCICIO_MUSCULO, gson.toJson(codMusculo));
        
        pacoteRecebido = cliente.request(pacoteEnviado);
        ArrayList<Exercicio> listaExercicios = gson.fromJson(pacoteRecebido.getDados(), ArrayList.class);
        return listaExercicios;
    }

    @Override
    public ArrayList<Exercicio> pesquisarTodos() throws SQLException {
        Pacote pacoteEnviado;
        Pacote pacoteRecebido;
        
        Gson gson = new Gson();
        
        pacoteEnviado = new Pacote(TipoOperacao.LISTA_EXERCICIO, null);
        
        pacoteRecebido = cliente.request(pacoteEnviado);
        ArrayList<Exercicio> listaExercicios = gson.fromJson(pacoteRecebido.getDados(), ArrayList.class);
        return listaExercicios;
    }

    @Override
    public void cadastrar(Exercicio exercicio, String[] codMusculos) throws SQLException {
        Pacote pacoteEnviado;
        Pacote pacoteRecebido;
        
        Gson gson = new Gson();
        
        pacoteEnviado = new Pacote(TipoOperacao.CAD_EXERCICIO, gson.toJson(exercicio));
        
        cliente.request(pacoteEnviado);
    }

    @Override
    public void cadastrarAparelhoExercicio(int codExercicio, int nroAparelho, String caminhoImg) throws SQLException {
        Pacote pacoteEnviado;
        Pacote pacoteRecebido;
        
        Gson gson = new Gson();
        
        //MAIS DE UM PARAMETRO
        pacoteEnviado = new Pacote(TipoOperacao.CAD_APARELHOEXERCICIO, gson.toJson(exercicio));
        
        cliente.request(pacoteEnviado);
    }

    @Override
    public void alterar(Exercicio exercicio) throws SQLException {
        Pacote pacoteEnviado;
        Pacote pacoteRecebido;
        
        Gson gson = new Gson();
        
        pacoteEnviado = new Pacote(TipoOperacao.ALTERA_EXERCICIO, gson.toJson(exercicio));
        
        cliente.request(pacoteEnviado);
    }

    @Override
    public void excluir(int codExercicio) throws SQLException {
        Pacote pacoteEnviado;
        Pacote pacoteRecebido;
        
        Gson gson = new Gson();
        
        pacoteEnviado = new Pacote(TipoOperacao.EXCLUI_EXERCICIO, gson.toJson(codExercicio));
        
        cliente.request(pacoteEnviado);
    }
    
}
