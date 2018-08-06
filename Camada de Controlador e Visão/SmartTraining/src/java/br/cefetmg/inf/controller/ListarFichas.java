package br.cefetmg.inf.controller;

import br.cefetmg.inf.model.domain.Ficha;
import br.cefetmg.inf.model.services.IManterFicha;
import br.cefetmg.inf.model.services.impl.ManterFicha;
import java.util.ArrayList;
import javax.servlet.http.HttpServletRequest;

public class ListarFichas {
    public static String execute(HttpServletRequest request) {
        String jsp = "";
        
         try {
            IManterFicha manterFicha = new ManterFicha();
            String codCpfAluno = (String) request.getAttribute("codCpfAluno");
            ArrayList<Ficha> listaFichas = manterFicha.pesquisarPorAluno(codCpfAluno);
            
            if (listaFichas != null) {
                request.setAttribute("listaFichas", listaFichas);
                jsp = "/ListaFichas.jsp";
            } else {
                String erro = "Nao existe registro de ficha!";
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
