package br.cefetmg.inf.controller;

import br.cefetmg.inf.model.domain.Aparelho;
import br.cefetmg.inf.model.services.IManterAparelho;
import br.cefetmg.inf.proxy.ManterAparelhoProxy;
import java.rmi.RemoteException;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.http.HttpServletRequest;

public class MostrarAparelho extends Controller{

    @Override
    public String execute(HttpServletRequest request) {
        String jsp="MostrarAparelho";
        try {
            int nroAparelho = Integer.parseInt(request.getParameter("numero"));
            
            IManterAparelho manterAparelho = new ManterAparelhoProxy();
            
            Aparelho aparelho = manterAparelho.pesquisar(nroAparelho);
            
            if(aparelho!=null){
                request.setAttribute("aparelho", aparelho);
            }
            else{
                String erro = "Aparelho nao encontrado!";
                jsp = "erro";
                request.setAttribute("erro", erro);
            }
        } catch (SQLException e) {
            e.printStackTrace(System.err);
            String erro = "Erro ao carregar aparelho!";
            request.setAttribute("erro", erro);
            jsp = "erro";
        } catch (RemoteException ex) {
            Logger.getLogger(MostrarAparelho.class.getName()).log(Level.SEVERE, null, ex);
        }
        return defineView(request, jsp);
    }
}
