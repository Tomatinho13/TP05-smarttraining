package br.cefetmg.inf.controller;

import br.cefetmg.inf.model.domain.Usuario;
import br.cefetmg.inf.model.services.IManterAluno;
import br.cefetmg.inf.model.services.impl.ManterAluno;
import java.util.ArrayList;
import javax.servlet.http.HttpServletRequest;

public class ListarUsuarios {
    public static String execute(HttpServletRequest request) {
        String jsp = "";
        
         try {
            IManterAluno manterUsuario = new ManterAluno();
            ArrayList<Usuario> listaUsuarios = manterUsuario.pesquisarTodos();
            
            if (listaUsuarios != null) {
                request.setAttribute("listaUsuarios", listaUsuarios);
                jsp = "/ListaUsuarios.jsp";
            } else {
                String erro = "Nao existe registro de usuário!";
                request.setAttribute("erro", erro);
                jsp = "/erro.jsp";
            }

        } catch (Exception e) {
            e.printStackTrace();
            jsp = "";
        }
        return jsp;
    }
}
