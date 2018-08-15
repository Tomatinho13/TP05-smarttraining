package br.cefetmg.inf.controller;

import br.cefetmg.inf.model.services.IManterAluno;
import br.cefetmg.inf.model.services.impl.ManterAluno;
import java.sql.SQLException;
import javax.servlet.http.HttpServletRequest;

public class RemoverUsuario implements Controller {

    @Override
    public String execute(HttpServletRequest request) {
        String jsp;

        try {
            String codCpfUsuario = request.getParameter("usuario").replaceAll(" ", "");

            
            IManterAluno manterUsuario = new ManterAluno();

            manterUsuario.excluir(codCpfUsuario);

            jsp = new TelaRemoverUsuario().execute(request);
        } catch (SQLException e) {
            jsp = "";
        }
        return jsp;
    }
}
