package br.cefetmg.inf.controller;

import br.cefetmg.inf.model.domain.Usuario;
import br.cefetmg.inf.proxy.ManterAlunoProxy;
import java.sql.SQLException;
import java.util.ArrayList;
import javax.servlet.http.HttpServletRequest;

public class ListarAlunos extends Controller {

    @Override
    public String execute(HttpServletRequest request) {
        String jsp;

        try {
            jsp="ListaAlunos";
            ManterAlunoProxy manterAluno = new ManterAlunoProxy();

            ArrayList<Usuario> listaAlunos = manterAluno.pesquisarTodos();

            if(listaAlunos == null){
                String erro="Nenhum aluno encontrado!";
                jsp = "erro.jsp";
                request.setAttribute("erro", erro);
                return defineView(request, jsp);
            }
            
            request.setAttribute("alunos", listaAlunos);

        } catch (SQLException e) {
            e.printStackTrace(System.err);
            String erro="Erro ao carregar lista de alunos";
            jsp = "erro.jsp";
            request.setAttribute("erro", erro);
        }
        return defineView(request, jsp);
    }
}
