package br.cefetmg.inf.controller;

import br.cefetmg.inf.model.domain.Instrutor;
import br.cefetmg.inf.model.domain.Usuario;
import java.sql.SQLException;
import javax.servlet.http.HttpServletRequest;
import br.cefetmg.inf.model.services.IManterUsuario;
import br.cefetmg.inf.model.services.impl.ManterAluno;
import br.cefetmg.inf.model.services.impl.ManterInstrutor;
import br.cefetmg.inf.model.services.impl.ManterUsuario;

public class MostrarUsuario extends Controller {

    @Override
    public String execute(HttpServletRequest request) {
        String jsp = "MostrarUsuario";
        try {
            String cpfUsuario = request.getParameter("codCpf").replaceAll("[^0-9]", "");

            IManterUsuario manterUsuario = new ManterUsuario();

            Usuario usuario = (Instrutor)manterUsuario.pesquisarPorCpf(cpfUsuario);
            if (usuario != null) {
                if (usuario.getTipo()=='I') {
                    jsp="MostrarInstrutor";
                }
                request.setAttribute("usuario", usuario);
            } else {
                String erro = "Usuario nao cadastrado!";
                jsp = "erro";
                request.setAttribute("erro", erro);
            }
        } catch (SQLException e) {
            e.printStackTrace(System.err);
            String erro = "Erro ao carregar perfil!";
            request.setAttribute("erro", erro);
            jsp = "erro";
        }
        return defineView(request, jsp);
    }
}
