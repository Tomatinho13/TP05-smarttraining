package br.cefetmg.inf.controller;

import br.cefetmg.inf.model.domain.Avaliacao;
import br.cefetmg.inf.model.services.IManterAvaliacao;
import br.cefetmg.inf.model.services.impl.ManterAvaliacao;
import java.sql.SQLException;
import java.util.ArrayList;
import javax.servlet.http.HttpServletRequest;

public class ListarAvaliacoes implements Controller{
    
    @Override
    public String execute(HttpServletRequest request) {
        String jsp;
        
         try {
            IManterAvaliacao manterAvaliacao = new ManterAvaliacao();
            String codCpfAluno = request.getAttribute("codCpfAluno").toString().replaceAll("[^0-9]", "");
            ArrayList <Avaliacao> listaAvaliacoes = manterAvaliacao.pesquisarPorAluno(codCpfAluno);
            
            if (listaAvaliacoes != null) {
                request.setAttribute("listaAvaliacoes", listaAvaliacoes);
                jsp = "/ListaAvaliacoes.jsp";
            } else {
                String erro = "Nao existe registro de avaliacao!";
                request.setAttribute("erro", erro);
                jsp = "/erro.jsp";
                return jsp;
            }

        } catch (SQLException e) {
            e.printStackTrace(System.err);
            String erro = "Erro ao listar avaliacoes!";
            request.setAttribute("erro", erro);
            jsp = "erro.jsp";
        }
        return jsp;
    }
}
