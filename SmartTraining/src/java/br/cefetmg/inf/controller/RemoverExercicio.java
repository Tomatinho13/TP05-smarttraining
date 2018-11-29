package br.cefetmg.inf.controller;

import br.cefetmg.inf.model.services.IManterExercicio;
import br.cefetmg.inf.proxy.ManterExercicioProxy;
import java.rmi.RemoteException;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.http.HttpServletRequest;

public class RemoverExercicio extends Controller {

    @Override
    public String execute(HttpServletRequest request) {
        String jsp = "";
        
        try {
            int codExercicio = Integer.parseInt(request.getParameter("exercicio").trim());

            IManterExercicio manterExercicio = new ManterExercicioProxy();

            manterExercicio.excluir(codExercicio);
            
            jsp = new TelaRemoverExercicio().execute(request);
        } catch (SQLException e) {
            e.printStackTrace(System.err);
            String erro = "Erro ao remover exercicio!";
            request.setAttribute("erro", erro);
            jsp = "erro.jsp";
        } catch (RemoteException ex) {
            Logger.getLogger(RemoverExercicio.class.getName()).log(Level.SEVERE, null, ex);
        }
        return jsp;
    }
}
