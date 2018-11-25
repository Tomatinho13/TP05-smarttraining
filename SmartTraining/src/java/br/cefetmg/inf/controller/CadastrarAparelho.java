package br.cefetmg.inf.controller;

import br.cefetmg.inf.model.domain.Aparelho;
import br.cefetmg.inf.model.services.IManterAparelho;
import br.cefetmg.inf.model.services.impl.ManterAparelho;
import java.sql.SQLException;
import java.util.ArrayList;
import javax.servlet.http.HttpServletRequest;

public class CadastrarAparelho extends Controller {

    @Override
    public String execute(HttpServletRequest request) {
        String jsp = "TelaInicialInstrutor";
        try {
            String nome = request.getParameter("nome");
            int numero = Integer.parseInt(request.getParameter("numero"));

            IManterAparelho manterAparelho = new ManterAparelho();
            if (manterAparelho.pesquisar(numero) != null) {
                String erro = "Numero de aparelho ja registrado";
                request.setAttribute("erro", erro);
                jsp = "erro";
                return defineView(request, jsp);
            }
            Aparelho aparelho = new Aparelho(numero, nome, new ArrayList<>());
            manterAparelho.cadastrar(aparelho);
            
        } catch (SQLException e) {
            e.printStackTrace(System.err);
            String erro = "Erro ao cadastrar aparelho";
            request.setAttribute("erro", erro);
            jsp = "erro";
            return defineView(request, jsp);
        }
        return defineView(request, jsp);
    }
}
