package br.cefetmg.inf.controller;

import br.cefetmg.inf.model.domain.Objetivo;
import br.cefetmg.inf.model.domain.Usuario;
import br.cefetmg.inf.model.services.IManterObjetivo;
import br.cefetmg.inf.model.services.impl.ManterAluno;
import br.cefetmg.inf.model.services.impl.ManterObjetivo;
import java.sql.SQLException;
import java.util.ArrayList;
import javax.servlet.http.HttpServletRequest;
import br.cefetmg.inf.model.services.IManterUsuario;

public class TelaCadastrarAvaliacao implements Controller {

    @Override
    public String execute(HttpServletRequest request) {
        String jsp;
        try {
            jsp = "CadastrarAvaliacao.jsp";
            String cpfAluno = request.getParameter("codCpfAluno").trim();

            IManterObjetivo manterObjetivo = new ManterObjetivo();
            IManterUsuario manterAluno = new ManterAluno();
            
            Usuario aluno = manterAluno.pesquisarPorCpf(cpfAluno);

            ArrayList<Objetivo> listaObjetivos = manterObjetivo.pesquisarTodos();

            if (listaObjetivos==null)
                jsp = "erro.jsp";
            
            request.setAttribute("aluno", aluno);
            request.setAttribute("objetivos", listaObjetivos);
        } catch (SQLException e) {
            e.printStackTrace(System.err);
            String erro = "Erro ao cadastrar avaliacao!";
            request.setAttribute("erro", erro);
            jsp = "erro.jsp";
        }
        return jsp;
    }

}
