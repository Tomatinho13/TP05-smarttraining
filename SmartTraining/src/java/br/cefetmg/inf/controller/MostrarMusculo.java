package br.cefetmg.inf.controller;

import br.cefetmg.inf.model.domain.Aparelho;
import br.cefetmg.inf.model.domain.Musculo;
import br.cefetmg.inf.model.services.IManterAparelho;
import br.cefetmg.inf.model.services.IManterMusculo;
import br.cefetmg.inf.model.services.impl.ManterAparelho;
import br.cefetmg.inf.model.services.impl.ManterMusculo;
import java.sql.SQLException;
import javax.servlet.http.HttpServletRequest;

public class MostrarMusculo extends Controller{

    @Override
    public String execute(HttpServletRequest request) {
        String jsp="MostrarMusculo";
        try {
            int nroMusculo = Integer.parseInt(request.getParameter("numero"));
            
            IManterMusculo manterMusculo = new ManterMusculo();
            
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
        }
        return defineView(request, jsp);
    }
}
