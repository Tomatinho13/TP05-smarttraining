package br.cefetmg.inf.controller;

import br.cefetmg.inf.model.domain.Usuario;
import br.cefetmg.inf.model.services.IManterAluno;
import br.cefetmg.inf.model.services.impl.ManterAluno;
import java.sql.SQLException;
import java.time.LocalDate;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.http.HttpServletRequest;

public class cadastrarAluno {

    public static String execute(HttpServletRequest request) {
        String jsp = "";
        String cpf =  request.getParameter("cpf");
        String nome = request.getParameter("nome");
        char idtTipoUsuario = 'A';
        String senha = request.getParameter("senha");
        String email = request.getParameter("email");
        LocalDate nascimento = LocalDate.parse(request.getParameter("nascimento"));

        Usuario aluno = new Usuario();

        aluno.setCodCpf(cpf);
        aluno.setNomUsuario(nome);
        aluno.setIdtTipoUsuario(idtTipoUsuario);
        aluno.setTxtSenha(senha);
        aluno.setDesEmail(email);
        aluno.setDatNascimento(nascimento);

        IManterAluno manterAluno = new ManterAluno();
        try {
            manterAluno.cadastrar(aluno);
        } catch (SQLException ex) {
            Logger.getLogger(cadastrarAluno.class.getName()).log(Level.SEVERE, null, ex);
        }
        jsp = "/LoginUsuario.jsp";
        return jsp;
    }
}
