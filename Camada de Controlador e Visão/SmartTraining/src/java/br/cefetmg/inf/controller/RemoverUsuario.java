package br.cefetmg.inf.controller;

import br.cefetmg.inf.model.domain.Usuario;
import br.cefetmg.inf.model.services.IManterAluno;
import br.cefetmg.inf.model.services.impl.ManterAluno;
import javax.servlet.http.HttpServletRequest;

public class RemoverUsuario{
    public static String execute(HttpServletRequest request) {
        String jsp = "";
        
        try {
            String nomeUsuario = request.getParameter("nomeUsuario");
            
            IManterAluno manterUsuario = new ManterAluno();
            
            Usuario usuario = manterUsuario.pesquisarPorNome(nomeUsuario);
            manterUsuario.excluir(usuario.getCodCpf());
            
            jsp = ListarUsuarios.execute(request);
        } catch (Exception e) {
            e.printStackTrace();
            jsp = "";
        }
        return jsp;
    }
}