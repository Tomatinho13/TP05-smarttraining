package br.cefetmg.inf.model.dao;

import br.cefetmg.inf.model.domain.DiaTreino;
import java.sql.SQLException;
import java.util.ArrayList;

public interface IDiaTreinoDao {

    public ArrayList<DiaTreino> getListaDiaTreino(String codCpf, String numeroFicha) throws SQLException;

    public boolean postDiaTreino(DiaTreino diaTreino) throws SQLException;

    public void fechaConexao();
}
