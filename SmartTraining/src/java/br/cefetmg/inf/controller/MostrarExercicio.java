package br.cefetmg.inf.controller;

import br.cefetmg.inf.model.domain.Exercicio;
import br.cefetmg.inf.model.services.IManterExercicio;
import br.cefetmg.inf.proxy.ManterExercicioProxy;
import java.rmi.RemoteException;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.http.HttpServletRequest;

public class MostrarExercicio extends Controller{

    @Override
    public String execute(HttpServletRequest request) {
        String jsp="MostrarExercicio";
        try {
            int codExercicio = Integer.parseInt(request.getParameter("numero"));
            IManterExercicio manterExercicio = new ManterExercicioProxy();
            Exercicio exercicio = manterExercicio.pesquisarPorCodigo(codExercicio);
            if(exercicio!=null){
                request.setAttribute("exercicio", exercicio);
            }
            else{
                String erro = "Erro ao carregar exercicio!";
                jsp = "erro";
                request.setAttribute("erro", erro);
            }
        } catch (SQLException e) {
            e.printStackTrace(System.err);
            String erro = "Erro ao carregar exercicio!";
            request.setAttribute("erro", erro);
            jsp = "erro";
        } catch (RemoteException ex) {
            Logger.getLogger(MostrarExercicio.class.getName()).log(Level.SEVERE, null, ex);
        }
        return defineView(request, jsp);
    }
}
