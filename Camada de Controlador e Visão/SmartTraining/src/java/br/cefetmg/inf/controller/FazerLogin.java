package br.cefetmg.inf.controller;

import br.cefetmg.inf.model.domain.Instrutor;
import br.cefetmg.inf.model.domain.Usuario;
import br.cefetmg.inf.model.services.IManterAluno;
import br.cefetmg.inf.model.services.IManterInstrutor;
import br.cefetmg.inf.model.services.impl.ManterAluno;
import br.cefetmg.inf.model.services.impl.ManterInstrutor;
import javax.servlet.http.HttpServletRequest;

public class FazerLogin{

    public static String execute(HttpServletRequest request) {
        String jsp = "";
        try{

            String cpf =  request.getParameter("cpf");
            String senha = request.getParameter("senha");

            IManterAluno manterAluno = new ManterAluno();
            IManterInstrutor manterInstrutor = new ManterInstrutor();
            Usuario usuario = manterAluno.pesquisarPorCpf(cpf);
            Instrutor instrutor;
            if(usuario.getTxtSenha()==senha){
                jsp="TelaInicialAluno.jsp"; //ainda nao implementado
            }
            else{
                instrutor = manterInstrutor.pesquisarPorCpf(cpf);
                if(usuario.getTxtSenha()==senha){
                    jsp="TelaInicialAluno.jsp"; //ainda nao implementado
                }else{
                   jsp="/erro.jsp"; 
                }
            }
        }
        catch(Exception e){
            e.printStackTrace();
            jsp = "";
        }
        return jsp;
    }
}
