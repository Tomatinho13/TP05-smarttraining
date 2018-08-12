package br.cefetmg.inf.controller;

import br.cefetmg.inf.model.domain.Exercicio;
import br.cefetmg.inf.model.services.IManterExercicio;
import br.cefetmg.inf.model.services.impl.ManterExercicio;
import java.sql.SQLException;
import javax.servlet.http.HttpServletRequest;

public class RemoverExercicio implements Controller {

    @Override
    public String execute(HttpServletRequest request) {
        String jsp;
        
        try {
            String nomeExercicio = request.getParameter("nomeExercicio");

            IManterExercicio manterExercicio = new ManterExercicio();

            Exercicio exercicio = manterExercicio.pesquisarPorNome(nomeExercicio);
            manterExercicio.excluir(exercicio.getCodExercicio());
            
            jsp = new ListarExercicios().execute(request);
        } catch (SQLException e) {
            jsp = "";
        }
        return jsp;
    }
}
