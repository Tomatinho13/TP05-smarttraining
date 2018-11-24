package br.cefetmg.inf.model.services.impl;

import br.cefetmg.inf.model.dao.impl.DiaTreinoDao;
import br.cefetmg.inf.model.domain.Atividade;
import br.cefetmg.inf.model.domain.DiaTreino;
import br.cefetmg.inf.model.services.IManterDiaTreino;
import java.sql.SQLException;
import java.util.ArrayList;

public class ManterDiaTreino implements IManterDiaTreino {
    private DiaTreinoDao diaTreinoDao = new DiaTreinoDao();
    
    @Override
    public ArrayList<DiaTreino> pesquisarTodos(Atividade atividade) throws SQLException {
        diaTreinoDao = new DiaTreinoDao();
        return diaTreinoDao.getListaDiaTreino(atividade);
    }

    @Override
    public boolean cadastrar(DiaTreino diaTreino) throws SQLException {
        diaTreinoDao = new DiaTreinoDao();
        return diaTreinoDao.postDiaTreino(diaTreino);
    }

}
