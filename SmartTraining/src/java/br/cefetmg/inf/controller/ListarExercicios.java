package br.cefetmg.inf.controller;

import br.cefetmg.inf.model.domain.Exercicio;
import javax.servlet.http.HttpServletRequest;
import br.cefetmg.inf.model.domain.Musculo;
import br.cefetmg.inf.model.services.IManterExercicio;
import br.cefetmg.inf.model.services.IManterMusculo;
import br.cefetmg.inf.proxy.ManterExercicioProxy;
import br.cefetmg.inf.proxy.ManterMusculoProxy;
import java.sql.SQLException;
import java.util.ArrayList;

public class ListarExercicios extends Controller {

    @Override
    public String execute(HttpServletRequest request) {
        String jsp;

        try {
            IManterExercicio manterExercicio = new ManterExercicioProxy();

            ArrayList<Exercicio> listaExercicios = manterExercicio.pesquisarTodos();

            if (listaExercicios != null) {
                request.setAttribute("exercicios", listaExercicios);
                jsp = "/ListaExercicios";
            } else {
                String erro = "Nao existem exercicios registrados no banco de dados!";
                request.setAttribute("erro", erro);
                jsp = "/erro";
            }

        } catch (SQLException e) {
            e.printStackTrace(System.err);
            String erro = "Erro ao listar exercicios!";
            request.setAttribute("erro", erro);
            jsp = "erro.jsp";
        }
        return defineView(request, jsp);
    }
}
