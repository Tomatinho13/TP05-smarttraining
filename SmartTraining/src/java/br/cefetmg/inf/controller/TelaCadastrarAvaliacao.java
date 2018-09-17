package br.cefetmg.inf.controller;

import br.cefetmg.inf.model.domain.Objetivo;
import br.cefetmg.inf.model.domain.Usuario;
import br.cefetmg.inf.model.services.IManterObjetivo;
import java.sql.SQLException;
import java.util.ArrayList;
import javax.servlet.http.HttpServletRequest;
import br.cefetmg.inf.model.services.IManterUsuario;
import br.cefetmg.inf.proxy.ManterAlunoProxy;
import br.cefetmg.inf.proxy.ManterObjetivoProxy;

public class TelaCadastrarAvaliacao extends Controller {

    @Override
    public String execute(HttpServletRequest request) {
        String jsp;
        try {
            jsp = "CadastrarAvaliacao";
            String cpfAluno = request.getParameter("codCpfAluno").trim();

            IManterObjetivo manterObjetivo = new ManterObjetivoProxy();
            IManterUsuario manterAluno = new ManterAlunoProxy();

            Usuario aluno = manterAluno.pesquisarPorCpf(cpfAluno);

            ArrayList<Objetivo> listaObjetivos = manterObjetivo.pesquisarTodos();
            
            if (listaObjetivos.isEmpty()) {
                String erro = "Nao ha objetivos cadastrados!";
                request.setAttribute("erro", erro);
                jsp = "erro.jsp";
            }

            request.setAttribute("aluno", aluno);
            request.setAttribute("objetivos", listaObjetivos);
        } catch (SQLException e) {
            e.printStackTrace(System.err);
            String erro = "Erro ao cadastrar avaliacao!";
            request.setAttribute("erro", erro);
            jsp = "erro.jsp";
        }
        return defineView(request, jsp);
    }

}
