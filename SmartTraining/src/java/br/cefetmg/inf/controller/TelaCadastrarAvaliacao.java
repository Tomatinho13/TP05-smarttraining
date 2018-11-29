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
import java.rmi.RemoteException;
import java.util.logging.Level;
import java.util.logging.Logger;

public class TelaCadastrarAvaliacao extends Controller {

    @Override
    public String execute(HttpServletRequest request) {
        String jsp = "";
        try {
            jsp = "CadastrarAvaliacao";
            if (request.getAttribute("tipoView").equals("html")) {
                String cpfAluno = request.getParameter("codCpfAluno").trim();    
                IManterUsuario manterAluno = new ManterAlunoProxy();
                Usuario aluno = manterAluno.pesquisarPorCpf(cpfAluno);
                request.setAttribute("aluno", aluno);
            }
            
            IManterObjetivo manterObjetivo = new ManterObjetivoProxy();
            ArrayList<Objetivo> listaObjetivos = manterObjetivo.pesquisarTodos();

            if (listaObjetivos.isEmpty()) {
                String erro = "Nao ha objetivos cadastrados!";
                request.setAttribute("erro", erro);
                jsp = "erro";
            }
            
            request.setAttribute("objetivos", listaObjetivos);

        } catch (SQLException e) {
            e.printStackTrace(System.err);
            String erro = "Erro ao cadastrar avaliacao!";
            request.setAttribute("erro", erro);
            jsp = "erro";
        } catch (RemoteException ex) {
            Logger.getLogger(TelaCadastrarAvaliacao.class.getName()).log(Level.SEVERE, null, ex);
        }
        return defineView(request, jsp);
    }

}
