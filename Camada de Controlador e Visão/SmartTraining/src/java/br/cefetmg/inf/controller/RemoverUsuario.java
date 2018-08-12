package br.cefetmg.inf.controller;

import br.cefetmg.inf.model.domain.Usuario;
import br.cefetmg.inf.model.services.IManterAluno;
import br.cefetmg.inf.model.services.impl.ManterAluno;
import java.sql.SQLException;
import javax.servlet.http.HttpServletRequest;

public class RemoverUsuario implements Controller {

    @Override
    public String execute(HttpServletRequest request) {
        String jsp;

        try {
            String nomeUsuario = request.getParameter("nomeUsuario");

            IManterAluno manterUsuario = new ManterAluno();

            Usuario usuario = manterUsuario.pesquisarPorNome(nomeUsuario);
            manterUsuario.excluir(usuario.getCodCpf());

            jsp = new ListarUsuarios().execute(request);
        } catch (SQLException e) {
            jsp = "";
        }
        return jsp;
    }
}
