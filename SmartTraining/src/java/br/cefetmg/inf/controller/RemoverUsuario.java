package br.cefetmg.inf.controller;

import java.sql.SQLException;
import javax.servlet.http.HttpServletRequest;
import br.cefetmg.inf.model.services.IManterUsuario;
import br.cefetmg.inf.proxy.ManterAlunoProxy;
import java.rmi.RemoteException;
import java.util.logging.Level;
import java.util.logging.Logger;

public class RemoverUsuario extends Controller {

    @Override
    public String execute(HttpServletRequest request) {
        String jsp = "";

        try {
            String codCpfUsuario = request.getParameter("usuario").replaceAll(" ", "");

            
            IManterUsuario manterUsuario = new ManterAlunoProxy();

            manterUsuario.excluir(codCpfUsuario);

            jsp = new TelaRemoverUsuario().execute(request);
        } catch (SQLException e) {
            e.printStackTrace(System.err);
            String erro = "Erro ao remover usuario!";
            request.setAttribute("erro", erro);
            jsp = "erro.jsp";
        } catch (RemoteException ex) {
            Logger.getLogger(RemoverUsuario.class.getName()).log(Level.SEVERE, null, ex);
        }
        return jsp;
    }
}
