package br.cefetmg.inf.model.dao;

import br.cefetmg.inf.model.domain.Instrutor;
import java.sql.SQLException;

/**
 *
 * @author Jamalz
 */
public interface IInstrutorDao {
    public Instrutor getInstrutor(String cpf) throws SQLException;
    public void postInstrutor(Instrutor instrutor) throws SQLException;
    public void putInstrutor(Instrutor instrutor) throws SQLException;
    public void deleteInstrutor(String cpf) throws SQLException;
}
