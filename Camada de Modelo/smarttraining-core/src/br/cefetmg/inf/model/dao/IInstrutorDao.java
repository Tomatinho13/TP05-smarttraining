package br.cefetmg.inf.model.dao;

import br.cefetmg.inf.model.domain.Instrutor;
import java.sql.SQLException;
import java.util.ArrayList;

/**
 *
 * @author Jamalz
 */
public interface IInstrutorDao {
    public Instrutor getInstrutor(String cpf) throws SQLException;
    public ArrayList<Instrutor> getListaInstrutores() throws SQLException;
    public void postInstrutor(Instrutor instrutor) throws SQLException;
    public void putInstrutor(Instrutor instrutor) throws SQLException;
    public void deleteInstrutor(String cpf) throws SQLException;
}
