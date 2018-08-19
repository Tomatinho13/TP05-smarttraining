package br.cefetmg.inf.controller;

import br.cefetmg.inf.model.domain.Exercicio;
import br.cefetmg.inf.model.services.IManterExercicio;
import br.cefetmg.inf.model.services.impl.ManterExercicio;
import java.sql.SQLException;
import javax.servlet.http.HttpServletRequest;

public class AlterarExercicio implements Controller{

    @Override
    public String execute(HttpServletRequest request) {
        String jsp;
        try {
            String nome = request.getParameter("nome");
            IManterExercicio manterExercicio = new ManterExercicio();
            Exercicio exercicio = manterExercicio.pesquisarPorNome(nome);
            if(exercicio!=null){    
                request.setAttribute("exercicio",exercicio);
                jsp = "/AlterarExercicio.jsp";
            }else{
                String erro = "Ocorreu erro ao tentar alterar o exercicio!";
                request.setAttribute("erro", erro);
                jsp = "/erro.jsp";
            }
        } catch (SQLException e) {
            e.printStackTrace(System.err);
            String erro = "Ocorreu erro ao tentar alterar os dados do exercicio!";
            request.setAttribute("erro", erro);
            jsp = "/erro.jsp";
        }
        return jsp;
    }
}
