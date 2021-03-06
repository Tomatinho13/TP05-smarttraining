package br.cefetmg.inf.controller;

import br.cefetmg.inf.model.domain.Exercicio;
import br.cefetmg.inf.model.services.IManterExercicio;
import br.cefetmg.inf.proxy.ManterExercicioProxy;
import java.rmi.RemoteException;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.http.HttpServletRequest;

public class TelaRemoverExercicio extends Controller {

    @Override
    public String execute(HttpServletRequest request) {
        String jsp = "";
        try {
            jsp = "RemoverExercicio";

            IManterExercicio manterExercicio = new ManterExercicioProxy();

            ArrayList<Exercicio> listaExercicios = manterExercicio.pesquisarTodos();

            if (listaExercicios==null)
                jsp = "erro.jsp";
            
            request.setAttribute("exercicios", listaExercicios);
        } catch (SQLException e) {
            e.printStackTrace(System.err);
            String erro = "Erro ao remover exercicio!";
            request.setAttribute("erro", erro);
            jsp = "erro.jsp";
        } catch (RemoteException ex) {
            Logger.getLogger(TelaRemoverExercicio.class.getName()).log(Level.SEVERE, null, ex);
        }
        return defineView(request, jsp);
    }

}
