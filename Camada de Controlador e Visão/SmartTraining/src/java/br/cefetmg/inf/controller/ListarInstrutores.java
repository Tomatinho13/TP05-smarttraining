package br.cefetmg.inf.controller;

import br.cefetmg.inf.model.domain.Usuario;
import br.cefetmg.inf.model.services.impl.ManterInstrutor;
import java.sql.SQLException;
import java.util.ArrayList;
import javax.servlet.http.HttpServletRequest;

public class ListarInstrutores implements Controller {

    @Override
    public String execute(HttpServletRequest request) {
        String jsp;

        try {
            jsp="ListaInstrutores.jsp";
            ManterInstrutor manterInstrutor = new ManterInstrutor();

            ArrayList<Usuario> listaInstrutores = manterInstrutor.pesquisarTodos();

            if(listaInstrutores == null){
                String erro="Nenhum instrutor encontrado!";
                jsp = "erro.jsp";
                request.setAttribute("erro", erro);
                return jsp;
            }
            
            request.setAttribute("instrutores", listaInstrutores);

        } catch (SQLException e) {
            String erro="Erro ao carregar lista de instrutores";
            jsp = "erro.jsp";
            request.setAttribute("erro", erro);
        }
        return jsp;
    }
}
