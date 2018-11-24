package br.cefetmg.inf.controller;

import br.cefetmg.inf.model.domain.Usuario;
import java.sql.SQLException;
import javax.servlet.http.HttpServletRequest;
import br.cefetmg.inf.model.services.IManterUsuario;
import br.cefetmg.inf.model.services.impl.ManterAluno;
import br.cefetmg.inf.model.services.impl.ManterInstrutor;

public class TelaAlterarUsuario extends Controller{

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
                jsp="AlterarUsuario";
            }
            else if(instrutor!=null){
                request.setAttribute("usuario", instrutor);
            }
            else{
                String erro = "Erro ao encontrar dados do usuario!";
                jsp = "erro.jsp";
                request.setAttribute("erro", erro);
                return defineView(request, jsp);
            }
        } catch (SQLException e) {
            e.printStackTrace();
            String erro = "Erro ao encontrar dados do usuario";
            jsp = "erro.jsp";
            request.setAttribute("erro", erro);
        }
        return defineView(request, jsp);
    }
}
