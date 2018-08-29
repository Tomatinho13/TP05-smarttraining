package br.cefetmg.inf.controller;

import br.cefetmg.inf.model.domain.Avaliacao;
import br.cefetmg.inf.model.services.IManterAvaliacao;
import br.cefetmg.inf.proxy.ManterAvaliacaoProxy;
import java.sql.SQLException;
import java.time.LocalDate;
import javax.servlet.http.HttpServletRequest;

public class AlterarAvaliacao implements Controller{

    @Override
    public String execute(HttpServletRequest request) {
        String jsp;
        try {
            String cpf = request.getParameter("codCpfAluno").replaceAll("[^0-9]", "");
            LocalDate data = LocalDate.parse(request.getParameter("dataAvaliacao"));
            IManterAvaliacao manterAvaliacao = new ManterAvaliacaoProxy();
            Avaliacao avaliacao = manterAvaliacao.pesquisar(cpf, data);
            if(avaliacao!=null){    
                request.setAttribute("avaliacao",avaliacao);
                jsp = "/AlterarAvaliacao.jsp";
            }else{
                String erro = "Ocorreu erro ao tentar alterar avaliacao!";
                request.setAttribute("erro", erro);
                jsp = "/erro.jsp";
            }
        } catch (SQLException e) {
            e.printStackTrace(System.err);
            String erro = "Ocorreu erro ao tentar alterar os dados da avaliacao!";
            request.setAttribute("erro", erro);
            jsp = "/erro.jsp";
        }
        return jsp;
    }
}