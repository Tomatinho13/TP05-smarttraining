package br.cefetmg.inf.controller;

import br.cefetmg.inf.model.domain.Instrutor;
import br.cefetmg.inf.model.domain.Usuario;
import br.cefetmg.inf.model.services.IManterAluno;
import br.cefetmg.inf.model.services.IManterInstrutor;
import br.cefetmg.inf.model.services.impl.ManterAluno;
import br.cefetmg.inf.model.services.impl.ManterInstrutor;
import java.sql.SQLException;
import javax.servlet.http.HttpServletRequest;

public class FazerLogin implements Controller{

    @Override
    public  String execute(HttpServletRequest request) {
        String jsp;
        try{

            String cpf =  request.getParameter("cpf").replaceAll("[^0-9]", "");
            String senha = request.getParameter("senha");

            IManterAluno manterAluno = new ManterAluno();
            IManterInstrutor manterInstrutor = new ManterInstrutor();
            Usuario usuario = manterAluno.pesquisarPorCpf(cpf);
            Instrutor instrutor = manterInstrutor.pesquisarPorCpf(cpf);
            if(usuario != null && usuario.getTxtSenha().equals(senha)){
                    jsp="TelaInicialAluno.jsp";
            }
            else if(instrutor!= null && instrutor.getTxtSenha().equals(senha)){
                jsp="TelaInicialInstrutor.jsp";
            }
            else{
                jsp="erro.jsp";
            }
        }
        catch(SQLException e){
            jsp = "";
        }
        return jsp;
    }
}
