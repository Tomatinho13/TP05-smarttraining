package br.cefetmg.inf.controller;

import br.cefetmg.inf.model.domain.Avaliacao;
import br.cefetmg.inf.model.services.IManterAvaliacao;
import br.cefetmg.inf.model.services.impl.ManterAvaliacao;
import java.sql.Date;
import java.sql.SQLException;
import java.time.LocalDate;
import javax.servlet.http.HttpServletRequest;

public class MostrarAvaliacao implements Controller{

    @Override
    public String execute(HttpServletRequest request) {
        String jsp="MostrarAvaliacao.jsp";
        try {
            String codCpfAluno = request.getParameter("codCpfAluno");
            LocalDate dataAvaliacao = Date.valueOf(request.getParameter("dataAvaliacao")).toLocalDate();
            IManterAvaliacao manterAvaliacao = new ManterAvaliacao();
            Avaliacao avaliacao = manterAvaliacao.pesquisar(codCpfAluno, dataAvaliacao);
            
            if(avaliacao!=null){
                request.setAttribute("avaliacao", avaliacao);
            }
            else{
                String erro = "Avaliacao nao encontrada!";
                jsp = "erro.jsp";
                request.setAttribute("erro", erro);
            }
        } catch (SQLException e) {
            e.printStackTrace(System.err);
            String erro = "Erro ao carregar avaliacao!";
            request.setAttribute("erro", erro);
            jsp = "erro.jsp";
        }
        return jsp;
    }
}
