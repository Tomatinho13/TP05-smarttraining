package br.cefetmg.inf.controller;

import br.cefetmg.inf.model.domain.Avaliacao;
import br.cefetmg.inf.model.services.IManterAvaliacao;
import br.cefetmg.inf.model.services.impl.ManterAvaliacao;
import java.util.ArrayList;
import javax.servlet.http.HttpServletRequest;

public class ListarAvaliacoes {
    public static String execute(HttpServletRequest request) {
        String jsp = "";
        
         try {
            IManterAvaliacao manterAvaliacao = new ManterAvaliacao();
            String codCpfAluno = (String) request.getAttribute("codCpfAluno");
            ArrayList <Avaliacao> listaAvaliacoes = manterAvaliacao.pesquisarPorAluno(codCpfAluno);
            
            if (listaAvaliacoes != null) {
                request.setAttribute("listaAvaliacoes", listaAvaliacoes);
                jsp = "/ListaAvaliacoes.jsp";
            } else {
                String erro = "Nao existe registro de avaliacao!";
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
