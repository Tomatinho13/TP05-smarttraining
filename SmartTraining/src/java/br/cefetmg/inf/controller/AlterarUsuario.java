package br.cefetmg.inf.controller;

import br.cefetmg.inf.model.domain.Usuario;
import java.sql.SQLException;
import java.time.LocalDate;
import javax.servlet.http.HttpServletRequest;
import br.cefetmg.inf.model.services.IManterUsuario;
import br.cefetmg.inf.proxy.ManterAlunoProxy;
import br.cefetmg.inf.proxy.ManterInstrutorProxy;
import java.rmi.RemoteException;
import java.util.logging.Level;
import java.util.logging.Logger;

public class AlterarUsuario extends Controller {

    @Override
    public String execute(HttpServletRequest request) {
        String jsp = "";
        try {
            IManterUsuario manterUsuario;

            String cpf = request.getParameter("cpf").replaceAll("[^0-9]", "");
            Usuario usuario = new Usuario();

            usuario.setCpf(cpf);
            usuario.setDataNascimento(LocalDate.parse(request.getParameter("datNasc")));
            usuario.setEmail(request.getParameter("email"));
            usuario.setTipo(((Usuario) request.getSession().getAttribute("usuario")).getTipo());
            usuario.setNome(request.getParameter("nome"));
            usuario.setSenha(request.getParameter("senha"));

            if (usuario.getTipo() == 'I') {
                manterUsuario = new ManterInstrutorProxy();
            } else {
                manterUsuario = new ManterAlunoProxy();
            }

            manterUsuario.alterar(usuario);
            jsp = "TelaInicialAluno";
        } catch (SQLException e) {
            e.printStackTrace(System.err);
            String erro = "Ocorreu erro ao tentar alterar os dados do usuario!";
            request.setAttribute("erro", erro);
            jsp = "/erro";
        } catch (RemoteException ex) {
            Logger.getLogger(AlterarUsuario.class.getName()).log(Level.SEVERE, null, ex);
        }
        return defineView(request, jsp);
    }
}
