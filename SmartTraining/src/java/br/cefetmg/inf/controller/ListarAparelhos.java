package br.cefetmg.inf.controller;

import br.cefetmg.inf.model.domain.Aparelho;
import br.cefetmg.inf.model.domain.Exercicio;
import br.cefetmg.inf.model.services.IManterAparelho;
import br.cefetmg.inf.model.services.IManterExercicio;
import br.cefetmg.inf.model.services.impl.ManterAparelho;
import br.cefetmg.inf.model.services.impl.ManterExercicio;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.http.HttpServletRequest;

public class ListarAparelhos extends Controller{

    @Override
    public String execute(HttpServletRequest request) {
        String jsp = "ListaAparelhos";
        try {
            IManterAparelho manterAparelho = new ManterAparelho();
            
            ArrayList<Aparelho> listaAparelhos = manterAparelho.pesquisarTodos();
            
            request.setAttribute("aparelhos", listaAparelhos);
            if (listaAparelhos == null) {
                jsp = "erro";
                String erro = "Erro ao pesquisar aparelhos!";
                request.setAttribute("erro", erro);
                return defineView(request, jsp);
            }
        } catch (SQLException ex) {
            Logger.getLogger(ListarAparelhos.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        return defineView(request, jsp);
    }
    
}
