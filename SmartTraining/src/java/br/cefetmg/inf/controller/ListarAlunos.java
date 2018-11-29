package br.cefetmg.inf.controller;

import br.cefetmg.inf.model.domain.Usuario;
import br.cefetmg.inf.model.services.IManterUsuario;
import br.cefetmg.inf.proxy.ManterAlunoProxy;
import java.rmi.RemoteException;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.http.HttpServletRequest;

public class ListarAlunos extends Controller {

    @Override
    public String execute(HttpServletRequest request) {
        String jsp = "";

        try {
            jsp = "ListaAlunos";
            IManterUsuario manterAluno = new ManterAlunoProxy();

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
        } catch (RemoteException ex) {
            Logger.getLogger(ListarAlunos.class.getName()).log(Level.SEVERE, null, ex);
        }
        return defineView(request, jsp);
    }
}
