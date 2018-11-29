package br.cefetmg.inf.controller;

import br.cefetmg.inf.model.domain.Aparelho;
import br.cefetmg.inf.model.domain.Musculo;
import br.cefetmg.inf.model.services.IManterAparelho;
import br.cefetmg.inf.model.services.IManterMusculo;
import br.cefetmg.inf.proxy.ManterAparelhoProxy;
import br.cefetmg.inf.proxy.ManterMusculoProxy;
import java.rmi.RemoteException;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.http.HttpServletRequest;

public class TelaCadastrarExercicio extends Controller {

    @Override
    public String execute(HttpServletRequest request) {
        String jsp = "";
        try {
            jsp = "CadastrarExercicio";

            IManterAparelho manterAparelho = new ManterAparelhoProxy();
            IManterMusculo manterMusculo = new ManterMusculoProxy();

            ArrayList<Aparelho> listaAparelhos = manterAparelho.pesquisarTodos();
            ArrayList<Musculo> listaMusculos = manterMusculo.pesquisarTodos();

            if (listaAparelhos == null) {
                jsp = "erro";
                String erro = "Erro ao pesquisar aparelhos!";
                request.setAttribute("erro", erro);
                return defineView(request, jsp);
            } else if (listaMusculos == null) {
                jsp = "erro";
                String erro = "Erro ao pesquisar musculos!";
                request.setAttribute("erro", erro);
                return defineView(request, jsp);
            }

            request.setAttribute("aparelhos", listaAparelhos);
            request.setAttribute("musculos", listaMusculos);

        } catch (SQLException e) {
            e.printStackTrace(System.err);
            String erro = "Erro ao cadastrar exercicio!";
            request.setAttribute("erro", erro);
            jsp = "erro";
        } catch (RemoteException ex) {
            Logger.getLogger(TelaCadastrarExercicio.class.getName()).log(Level.SEVERE, null, ex);
        }
        return defineView(request, jsp);
    }

}
