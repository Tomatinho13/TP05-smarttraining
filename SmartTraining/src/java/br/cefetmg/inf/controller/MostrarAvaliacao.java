package br.cefetmg.inf.controller;

import br.cefetmg.inf.model.domain.Avaliacao;
import br.cefetmg.inf.model.services.IManterAvaliacao;
import br.cefetmg.inf.proxy.ManterAvaliacaoProxy;
import java.rmi.RemoteException;
import java.sql.Date;
import java.sql.SQLException;
import java.time.LocalDate;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.http.HttpServletRequest;

public class MostrarAvaliacao extends Controller{

    @Override
    public String execute(HttpServletRequest request) {
        String jsp="MostrarAvaliacao";
        try {
            String codCpfAluno = request.getParameter("codCpf");
            LocalDate dataAvaliacao = Date.valueOf(request.getParameter("data").trim()).toLocalDate();
            IManterAvaliacao manterAvaliacao = new ManterAvaliacaoProxy();
            Avaliacao avaliacao = manterAvaliacao.pesquisar(codCpfAluno, dataAvaliacao);
            
            if(avaliacao!=null){
                request.setAttribute("avaliacao", avaliacao);
            }
            else{
                String erro = "Avaliacao nao encontrada!";
                jsp = "erro";
                request.setAttribute("erro", erro);
            }
        } catch (SQLException e) {
            e.printStackTrace(System.err);
            String erro = "Erro ao carregar avaliacao!";
            request.setAttribute("erro", erro);
            jsp = "erro";
        } catch (RemoteException ex) {
            Logger.getLogger(MostrarAvaliacao.class.getName()).log(Level.SEVERE, null, ex);
        }
        return defineView(request, jsp);
    }
}
