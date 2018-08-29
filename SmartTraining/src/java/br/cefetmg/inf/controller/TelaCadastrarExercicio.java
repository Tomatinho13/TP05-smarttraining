package br.cefetmg.inf.controller;

import br.cefetmg.inf.model.domain.Aparelho;
import br.cefetmg.inf.model.domain.Musculo;
import br.cefetmg.inf.model.services.IManterAparelho;
import br.cefetmg.inf.model.services.IManterMusculo;
<<<<<<< HEAD
import br.cefetmg.inf.proxy.ManterAparelhoProxy;
import br.cefetmg.inf.proxy.ManterMusculoProxy;
=======
import br.cefetmg.inf.model.services.impl.ManterAparelho;
import br.cefetmg.inf.model.services.impl.ManterMusculo;
import br.cefetmg.inf.proxy.ManterAparelhoProxy;
>>>>>>> 1bf8a6a4536dbc9a13b72781446022b6ab8b7f76
import java.sql.SQLException;
import java.util.ArrayList;
import javax.servlet.http.HttpServletRequest;

public class TelaCadastrarExercicio implements Controller {

    @Override
    public String execute(HttpServletRequest request) {
        String jsp;
        try {
            jsp = "CadastrarExercicio.jsp";

            IManterAparelho manterAparelho = new ManterAparelhoProxy();
<<<<<<< HEAD
            IManterMusculo manterMusculo = new ManterMusculoProxy();
=======
            IManterMusculo manterMusculo = new ManterMusculo();
>>>>>>> 1bf8a6a4536dbc9a13b72781446022b6ab8b7f76

            ArrayList<Aparelho> listaAparelhos = manterAparelho.pesquisarTodos();
            ArrayList<Musculo> listaMusculos = manterMusculo.pesquisarTodos();

            if (listaAparelhos == null) {
                jsp = "erro.jsp";
                String erro = "Erro ao pesquisar aparelhos!";
                request.setAttribute("erro", erro);
                return jsp;
            } else if (listaMusculos == null) {
                jsp = "erro.jsp";
                String erro = "Erro ao pesquisar musculos!";
                request.setAttribute("erro", erro);
                return jsp;
            }

            request.setAttribute("aparelhos", listaAparelhos);
            request.setAttribute("musculos", listaMusculos);

        } catch (SQLException e) {
            e.printStackTrace(System.err);
            String erro = "Erro ao cadastrar exercicio!";
            request.setAttribute("erro", erro);
            jsp = "erro.jsp";
        }
        return jsp;
    }

}
