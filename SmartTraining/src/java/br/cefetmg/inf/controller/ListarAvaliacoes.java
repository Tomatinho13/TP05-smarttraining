package br.cefetmg.inf.controller;

import br.cefetmg.inf.model.domain.Avaliacao;
import br.cefetmg.inf.model.domain.Usuario;
import br.cefetmg.inf.model.services.IManterAvaliacao;
import java.sql.SQLException;
import java.util.ArrayList;
import javax.servlet.http.HttpServletRequest;
import br.cefetmg.inf.model.services.IManterUsuario;
import br.cefetmg.inf.model.services.impl.ManterAluno;
import br.cefetmg.inf.model.services.impl.ManterAvaliacao;

public class ListarAvaliacoes extends Controller {

    @Override
    public String execute(HttpServletRequest request) {
        String jsp = null;

        try {
            IManterAvaliacao manterAvaliacao = new ManterAvaliacao();
            IManterUsuario manterUsuario = new ManterAluno();
            String codCpfAluno = request.getParameter("codCpf").replaceAll("[^0-9]", "");
            Usuario aluno = manterUsuario.pesquisarPorCpf(codCpfAluno);
            ArrayList<Avaliacao> listaAvaliacoes = manterAvaliacao.pesquisarPorAluno(aluno.getCpf());

            if (!listaAvaliacoes.isEmpty()) {
                request.setAttribute("avaliacoes", listaAvaliacoes);
                request.setAttribute("aluno", aluno);                
                jsp = "/ListaAvaliacoes";
            } else {
                String erro = "Nao existe registro de avaliacoes!";
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
    return defineView(request, jsp);
    }
}
