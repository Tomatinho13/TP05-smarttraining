package br.cefetmg.inf.controller;

import br.cefetmg.inf.model.domain.Usuario;
import br.cefetmg.inf.model.services.IManterUsuario;
import br.cefetmg.inf.model.services.impl.ManterAluno;
import br.cefetmg.inf.model.services.impl.ManterInstrutor;
import java.sql.SQLException;
import javax.servlet.http.HttpServletRequest;

public class MostrarUsuario implements Controller{

    @Override
    public String execute(HttpServletRequest request) {
        String jsp="MostrarUsuario.jsp";
        try {
            String cpfUsuario = request.getParameter("codCpfUsuario");
            IManterUsuario manterAluno = new ManterAluno();
            IManterUsuario manterInstrutor = new ManterInstrutor();
            Usuario aluno  = manterAluno.pesquisarPorCpf(cpfUsuario);
            Usuario instrutor  = manterInstrutor.pesquisarPorCpf(cpfUsuario);
            if(aluno!=null){
                request.setAttribute("usuario", aluno);
            }
            else if(instrutor!=null){
                request.setAttribute("usuario", instrutor);
            }
            else{
                String erro = "Erro ao carregar perfil!";
                jsp = "erro.jsp";
                request.setAttribute("erro", erro);
            }
        } catch (SQLException e) {
            e.printStackTrace(System.err);
            String erro = "Erro ao carregar perfil!";
            request.setAttribute("erro", erro);
            jsp = "erro.jsp";
        }
        return jsp;
    }
}
