package br.cefetmg.inf.model.services;

import br.cefetmg.inf.model.domain.Avaliacao;
import java.sql.SQLException;
import java.time.LocalDate;
import java.util.ArrayList;

public interface IManterAvaliacao {

    public ArrayList<Avaliacao> pesquisarPorAluno(String codCpf) throws SQLException;
    
    public Avaliacao pesquisar(String codCpf, LocalDate data) throws SQLException;

    public boolean cadastrar(Avaliacao avaliacao) throws SQLException;

    public boolean alterar(Avaliacao avaliacao) throws SQLException;

    public boolean excluir(String codCpf, LocalDate datAvaliacao) throws SQLException;
}
