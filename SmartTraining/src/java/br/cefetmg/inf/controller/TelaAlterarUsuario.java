package br.cefetmg.inf.controller;

import br.cefetmg.inf.model.domain.Usuario;
import br.cefetmg.inf.model.services.impl.ManterAluno;
import br.cefetmg.inf.model.services.impl.ManterInstrutor;
import java.sql.SQLException;
import javax.servlet.http.HttpServletRequest;
import br.cefetmg.inf.model.services.IManterUsuario;

public class TelaAlterarUsuario implements Controller{

    @Override
    public String execute(HttpServletRequest request) {
        String jsp="";
        try {
            String cpfUsuario = request.getParameter("codCpfUsuario");
            IManterUsuario manterAluno = new ManterAluno();
            IManterUsuario manterInstrutor = new ManterInstrutor();
            Usuario aluno  = manterAluno.pesquisarPorCpf(cpfUsuario);
            Usuario instrutor  = manterInstrutor.pesquisarPorCpf(cpfUsuario);
            if(aluno!=null){
                request.setAttribute("usuario", aluno);
                jsp="AlterarUsuario.jsp";
            }
            else if(instrutor!=null){
                request.setAttribute("usuario", instrutor);
            }
            else{
                String erro = "Erro ao encontrar dados do usuario!";
                jsp = "erro.jsp";
                request.setAttribute("erro", erro);
                return jsp;
            }
        } catch (SQLException e) {
            e.printStackTrace();
            String erro = "Erro ao encontrar dados do usuario";
            jsp = "erro.jsp";
            request.setAttribute("erro", erro);
        }
        return jsp;
    }
}
