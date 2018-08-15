package br.cefetmg.inf.controller;

import javax.servlet.http.HttpServletRequest;
import br.cefetmg.inf.model.domain.Exercicio;
import br.cefetmg.inf.model.services.IManterExercicio;
import br.cefetmg.inf.model.services.impl.ManterExercicio;
import br.cefetmg.inf.model.domain.Musculo;
import br.cefetmg.inf.model.services.IManterMusculo;
import br.cefetmg.inf.model.services.impl.ManterMusculo;
import java.sql.SQLException;
import java.util.ArrayList;

/**
 *
 * @author Tomatinho
 */
public class ListarExercicios implements Controller {

    @Override
    public String execute(HttpServletRequest request) {
        String jsp;

        try {
            IManterExercicio manterExercicio = new ManterExercicio();
            IManterMusculo manterMusculo = new ManterMusculo();

            ArrayList<Musculo> listaMusculos = manterMusculo.listarTodos();

            if (listaMusculos != null) {
                request.setAttribute("musculos", listaMusculos);
                jsp = "/ListaExercicios.jsp";
            } else {
                String erro = "Nao existem musculos registrados no banco de dados!";
                request.setAttribute("erro", erro);
                jsp = "/erro.jsp";
            }

        } catch (SQLException e) {
            jsp = "";
        }
        return jsp;
    }
}
