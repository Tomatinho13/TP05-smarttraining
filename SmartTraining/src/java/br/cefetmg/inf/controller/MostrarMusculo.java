package br.cefetmg.inf.controller;

import br.cefetmg.inf.model.domain.Musculo;
import br.cefetmg.inf.model.services.IManterMusculo;
import br.cefetmg.inf.proxy.ManterMusculoProxy;
import java.rmi.RemoteException;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.http.HttpServletRequest;

public class MostrarMusculo extends Controller{

    @Override
    public String execute(HttpServletRequest request) {
        String jsp="MostrarMusculo";
        try {
            int nroMusculo = Integer.parseInt(request.getParameter("numero"));
            
            IManterMusculo manterMusculo = new ManterMusculoProxy();
            
            Musculo musculo = manterMusculo.pesquisarPorCodigo(nroMusculo);
            
            if(musculo!=null){
                request.setAttribute("musculo", musculo);
            }
            else{
                String erro = "Musculo nao encontrado!";
                jsp = "erro";
                request.setAttribute("erro", erro);
            }
        } catch (SQLException e) {
            e.printStackTrace(System.err);
            String erro = "Erro ao carregar musculo!";
            request.setAttribute("erro", erro);
            jsp = "erro";
        } catch (RemoteException ex) {
            Logger.getLogger(MostrarMusculo.class.getName()).log(Level.SEVERE, null, ex);
        }
        return defineView(request, jsp);
    }
}
