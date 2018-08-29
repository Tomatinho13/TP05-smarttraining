package br.cefetmg.inf.controller;

import br.cefetmg.inf.model.domain.Aparelho;
import br.cefetmg.inf.model.domain.Exercicio;
import br.cefetmg.inf.model.domain.Musculo;
import br.cefetmg.inf.model.services.IManterAparelho;
import br.cefetmg.inf.model.services.IManterExercicio;
import br.cefetmg.inf.model.services.IManterMusculo;
import br.cefetmg.inf.model.services.impl.ManterAparelho;
import br.cefetmg.inf.model.services.impl.ManterMusculo;
<<<<<<< HEAD
import br.cefetmg.inf.proxy.ManterExercicioProxy;
=======
import br.cefetmg.inf.proxy.ManterAparelhoProxy;
>>>>>>> 1bf8a6a4536dbc9a13b72781446022b6ab8b7f76
import java.sql.SQLException;
import java.util.ArrayList;
import javax.servlet.http.HttpServletRequest;

public class TelaAlterarExercicio implements Controller{

    @Override
    public String execute(HttpServletRequest request) {
        String jsp="AlterarExercicio.jsp";
        try {
            int codExercicio = Integer.parseInt(request.getParameter("codExercicio"));
            IManterExercicio manterExercicio = new ManterExercicioProxy();
            Exercicio exercicio = manterExercicio.pesquisarPorCodigo(codExercicio);
            if(exercicio!=null){
                request.setAttribute("exercicio", exercicio);
            }
            else{
                String erro = "Erro ao carregar exercicio!";
                jsp = "erro.jsp";
                request.setAttribute("erro", erro);
            }
            
            IManterAparelho manterAparelho = new ManterAparelhoProxy();
            ArrayList<Aparelho> listaAparelhos = manterAparelho.pesquisarTodos();
            if(!listaAparelhos.isEmpty()){
                request.setAttribute("aparelhos", listaAparelhos);
            }
            else{
                String erro = "Nao ha aparelhos registrados!";
                jsp = "erro.jsp";
                request.setAttribute("erro", erro);
            }
            
            IManterMusculo manterMusculo = new ManterMusculo();
            ArrayList<Musculo> listaMusculos = manterMusculo.pesquisarTodos();
            if(!listaMusculos.isEmpty()){
                request.setAttribute("musculos", listaMusculos);
            }
            else{
                String erro = "Nao ha musculos registrados!";
                jsp = "erro.jsp";
                request.setAttribute("erro", erro);
            }
        } catch (SQLException e) {
            e.printStackTrace(System.err);
            String erro = "Erro ao carregar exercicio!";
            request.setAttribute("erro", erro);
            jsp = "erro.jsp";
        }
        return jsp;
    }
}