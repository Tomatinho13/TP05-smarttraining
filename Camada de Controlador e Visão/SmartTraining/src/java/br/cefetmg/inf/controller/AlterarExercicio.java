package br.cefetmg.inf.controller;

import br.cefetmg.inf.model.domain.Exercicio;
import br.cefetmg.inf.model.services.IManterExercicio;
import br.cefetmg.inf.model.services.impl.ManterExercicio;
import javax.servlet.http.HttpServletRequest;

public class AlterarExercicio {

    public static String execute(HttpServletRequest request) {
        String jsp = "";
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
        } catch (Exception e) {
            e.printStackTrace();
            jsp = "";
        }
        return jsp;
    }
}
