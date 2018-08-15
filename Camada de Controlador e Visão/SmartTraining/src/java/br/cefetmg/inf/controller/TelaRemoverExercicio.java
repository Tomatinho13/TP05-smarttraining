package br.cefetmg.inf.controller;

import br.cefetmg.inf.model.domain.Exercicio;
import br.cefetmg.inf.model.services.impl.ManterExercicio;
import java.sql.SQLException;
import java.util.ArrayList;
import javax.servlet.http.HttpServletRequest;

public class TelaRemoverExercicio implements Controller {

    @Override
    public String execute(HttpServletRequest request) {
        String jsp;
        try {
            jsp = "RemoverExercicio.jsp";

            ManterExercicio manterExercicio = new ManterExercicio();

            ArrayList<Exercicio> listaExercicios = manterExercicio.pesquisarTodos();

            if (listaExercicios==null)
                jsp = "erro.jsp";
            
            request.setAttribute("exercicios", listaExercicios);
        } catch (SQLException ex) {
            jsp = "erro.jsp";
        }
        return jsp;
    }

}
