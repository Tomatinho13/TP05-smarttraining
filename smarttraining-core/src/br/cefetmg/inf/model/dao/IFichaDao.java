package br.cefetmg.inf.model.dao;

import br.cefetmg.inf.model.domain.Ficha;
import java.sql.SQLException;
import java.util.ArrayList;

/**
 *
 * @author Jamalz
 */
public interface IFichaDao {

    public Ficha getFicha(String cpf, int numeroFicha) throws SQLException;

    public ArrayList<Ficha> getListaFicha(String cpf) throws SQLException;

    public boolean postFicha(Ficha ficha) throws SQLException;

    public boolean putFicha(Ficha ficha) throws SQLException;

    public boolean deleteFicha(String cpf, int nroFicha) throws SQLException;

    public void fechaConexao();
}
