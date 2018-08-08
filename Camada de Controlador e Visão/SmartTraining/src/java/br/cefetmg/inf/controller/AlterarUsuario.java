package br.cefetmg.inf.controller;

import br.cefetmg.inf.model.domain.Usuario;
import br.cefetmg.inf.model.services.IManterAluno;
import br.cefetmg.inf.model.services.impl.ManterAluno;
import javax.servlet.http.HttpServletRequest;

public class AlterarUsuario {

    public static String execute(HttpServletRequest request) {
        String jsp = "";
        try {
            String cpf = request.getParameter("cpf");
            IManterAluno manterUsuario = new ManterAluno();
            Usuario usuario = manterUsuario.pesquisarPorCpf(cpf);
            if(usuario!=null){    
                request.setAttribute("usuario",usuario);
                jsp = "/AlterarUsuario.jsp";
            }else{
                String erro = "Ocorreu erro ao tentar alterar os dados do usuario!";
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
