package br.cefetmg.inf.proxy;

import br.cefetmg.inf.model.domain.Usuario;
import br.cefetmg.inf.model.services.IManterUsuario;
import br.cefetmg.inf.util.Pacote;
import br.cefetmg.inf.util.TipoOperacao;
import com.google.gson.Gson;
import java.sql.SQLException;
import java.util.ArrayList;


public class ManterAlunoProxy implements IManterUsuario{

    @Override
    public Usuario pesquisarPorCpf(String codCpf) throws SQLException {
        Pacote pacoteEnviado;
        Pacote pacoteRecebido;
        
        Gson gson = new Gson();
        
        pacoteEnviado = new Pacote(TipoOperacao.PESQ_ALUNO_CPF, gson.toJson(codCpf));
        
        pacoteRecebido = cliente.request(pacoteEnviado);
        Usuario aluno = gson.fromJson(pacoteRecebido.getDados(), Usuario.class);
        return aluno;
    }

    @Override
    public Usuario pesquisarPorNome(String nome) throws SQLException {
        Pacote pacoteEnviado;
        Pacote pacoteRecebido;
        
        Gson gson = new Gson();
        
        pacoteEnviado = new Pacote(TipoOperacao.PESQ_ALUNO_NOME, gson.toJson(nome));
        
        pacoteRecebido = cliente.request(pacoteEnviado);
        Usuario aluno = gson.fromJson(pacoteRecebido.getDados(), Usuario.class);
        return aluno;
    }

    @Override
    public ArrayList<Usuario> pesquisarTodos() throws SQLException {
        Pacote pacoteEnviado;
        Pacote pacoteRecebido;
        
        Gson gson = new Gson();
        
        pacoteEnviado = new Pacote(TipoOperacao.LISTA_ALUNO, null);
        
        pacoteRecebido = cliente.request(pacoteEnviado);
        ArrayList<Usuario> listaAlunos = gson.fromJson(pacoteRecebido.getDados(), ArrayList.class);
        return listaAlunos;
    }

    @Override
    public void cadastrar(Usuario aluno) throws SQLException {
        Pacote pacoteEnviado;
        Pacote pacoteRecebido;
        
        Gson gson = new Gson();
        
        pacoteEnviado = new Pacote(TipoOperacao.CAD_ALUNO, gson.toJson(aluno));
        
        cliente.request(pacoteEnviado);
    }

    @Override
    public void alterar(Usuario aluno) throws SQLException {
        Pacote pacoteEnviado;
        Pacote pacoteRecebido;
        
        Gson gson = new Gson();
        
        pacoteEnviado = new Pacote(TipoOperacao.ALTERA_ALUNO, gson.toJson(aluno));
        
        cliente.request(pacoteEnviado);
    }

    @Override
    public void excluir(String codCpf) throws SQLException {
        Pacote pacoteEnviado;
        Pacote pacoteRecebido;
        
        Gson gson = new Gson();
        
        pacoteEnviado = new Pacote(TipoOperacao.EXCLUI_ALUNO, gson.toJson(codCpf));
        
        cliente.request(pacoteEnviado);
    }
    
}
