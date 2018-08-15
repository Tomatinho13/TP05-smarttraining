package br.cefetmg.inf.controller;

import br.cefetmg.inf.model.domain.Instrutor;
import br.cefetmg.inf.model.domain.Usuario;
import br.cefetmg.inf.model.services.impl.ManterAluno;
import br.cefetmg.inf.model.services.impl.ManterInstrutor;
import java.sql.SQLException;
import java.util.ArrayList;
import javax.servlet.http.HttpServletRequest;

public class TelaRemoverUsuario implements Controller {

    @Override
    public String execute(HttpServletRequest request) {
        String jsp;
        try {
            jsp = "RemoverUsuario.jsp";

            ManterAluno manterAluno = new ManterAluno();
            ManterInstrutor manterInstrutor = new ManterInstrutor();

            ArrayList<Usuario> listaAlunos = manterAluno.pesquisarTodos();
            ArrayList<Instrutor> listaInstrutores = manterInstrutor.pesquisarTodos();
            ArrayList<Usuario> listaUsuarios = new ArrayList<>();

            if (listaAlunos==null) {
                if (listaInstrutores==null) {
                    jsp = "erro.jsp";
                }
            } else if (listaInstrutores==null) {
                listaUsuarios.addAll(listaAlunos);
            } else {
                listaUsuarios.addAll(listaAlunos);
                listaUsuarios.addAll(listaInstrutores);
            }
            request.setAttribute("usuarios", listaUsuarios);
        } catch (SQLException ex) {
            jsp = "erro.jsp";
        }
        return jsp;
    }

}
