package br.cefetmg.inf.controller;

import br.cefetmg.inf.model.domain.Ficha;
import br.cefetmg.inf.model.services.IManterFicha;
import br.cefetmg.inf.model.services.impl.ManterFicha;
import com.google.gson.Gson;
import java.io.IOException;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.http.HttpServletRequest;

public class CadastrarFicha extends Controller {

    @Override
    public String execute(HttpServletRequest request) {
        String jsp = "respostaJSON.jsp";
        try {
            Gson gson = new Gson();
            Ficha ficha = gson.fromJson(request.getReader(), Ficha.class);
            
            IManterFicha manterFicha = new ManterFicha();
            manterFicha.cadastrar(ficha);
        } catch (IOException | SQLException ex) {
            Logger.getLogger(CadastrarFicha.class.getName()).log(Level.SEVERE, null, ex);
        }
        return jsp;
    }
}
