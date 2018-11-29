package br.cefetmg.inf.controller;

import br.cefetmg.inf.model.domain.Usuario;
import br.cefetmg.inf.model.services.IManterUsuario;
import br.cefetmg.inf.proxy.ManterAlunoProxy;
import br.cefetmg.inf.proxy.ManterInstrutorProxy;
import java.rmi.RemoteException;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.http.HttpServletRequest;

public class TelaRemoverUsuario extends Controller {

    @Override
    public String execute(HttpServletRequest request) {
        String jsp = "";
        try {
            jsp = "RemoverUsuario";

            IManterUsuario manterAluno = new ManterAlunoProxy();
            IManterUsuario manterInstrutor = new ManterInstrutorProxy();

            ArrayList<Usuario> listaAlunos = manterAluno.pesquisarTodos();
            ArrayList<Usuario> listaInstrutores = manterInstrutor.pesquisarTodos();
            ArrayList<Usuario> listaUsuarios = new ArrayList<>();

            listaUsuarios.addAll(listaAlunos);
            listaUsuarios.addAll(listaInstrutores);
            
            request.setAttribute("usuarios", listaUsuarios);
        } catch (SQLException e) {
            e.printStackTrace(System.err);
            String erro = "Erro ao remover usuario!";
            request.setAttribute("erro", erro);
            jsp = "erro.jsp";
        } catch (RemoteException ex) {
            Logger.getLogger(TelaRemoverUsuario.class.getName()).log(Level.SEVERE, null, ex);
        }
        return defineView(request, jsp);
    }

}
