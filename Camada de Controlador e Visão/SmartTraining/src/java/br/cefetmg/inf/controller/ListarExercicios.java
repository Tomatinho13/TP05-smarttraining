package br.cefetmg.inf.controller;

import javax.servlet.http.HttpServletRequest;
import br.cefetmg.inf.model.domain.Exercicio;
import br.cefetmg.inf.model.services.IManterExercicio;
import br.cefetmg.inf.model.services.impl.ManterExercicio;
import br.cefetmg.inf.model.domain.Musculo;
import br.cefetmg.inf.model.services.IManterMusculo;
import br.cefetmg.inf.model.services.impl.ManterMusculo;
import java.util.ArrayList;

/**
 *
 * @author Tomatinho
 */

public class ListarExercicios {
    public static String execute(HttpServletRequest request) {
        String jsp = "";
        
        try {
            IManterExercicio manterExercicio = new ManterExercicio();
            IManterMusculo manterMusculo = new ManterMusculo();
            
            ArrayList <Musculo> listaMusculos = manterMusculo.listarTodos();
            
            if (listaMusculos != null) {
                request.setAttribute("listaMusculos", listaMusculos);
                jsp = "/ListaExercicios.jsp";
            } else {
                String erro = "Nao existem musculos registrados no banco de dados!";
                request.setAttribute("erro", erro);
                jsp = "/erro.jsp";
            }
            
            for (Musculo musculo : listaMusculos) {
                ArrayList <Exercicio> listaExercicios = manterExercicio.pesquisarPorMusculo(musculo.getCodMusculo());
                if (listaExercicios != null) {
                    request.setAttribute("listaExercicios", listaExercicios);
                    jsp = "/ListaExercicios.jsp";
                } else {
                    String erro = "Nao existem exercícios para esse musculo!";
                    request.setAttribute("erro", erro);
                    jsp = "/erro.jsp";
                }
            }
            
        } catch (Exception e) {
            e.printStackTrace();
            jsp = "";
        }
        return jsp;
    }
}
