package br.cefetmg.inf.controller;

import br.cefetmg.inf.model.domain.Aparelho;
import br.cefetmg.inf.model.domain.Musculo;
import br.cefetmg.inf.model.services.IManterAparelho;
import br.cefetmg.inf.model.services.IManterMusculo;
import br.cefetmg.inf.model.services.impl.ManterAparelho;
import br.cefetmg.inf.model.services.impl.ManterMusculo;
import java.sql.SQLException;
import java.util.ArrayList;
import javax.servlet.http.HttpServletRequest;

public class TelaCadastrarExercicio extends Controller {

    @Override
    public String execute(HttpServletRequest request) {
        String jsp;
        try {
            jsp = "CadastrarExercicio";

            IManterAparelho manterAparelho = new ManterAparelho();
            IManterMusculo manterMusculo = new ManterMusculo();

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
        }
        return defineView(request, jsp);
    }

}
