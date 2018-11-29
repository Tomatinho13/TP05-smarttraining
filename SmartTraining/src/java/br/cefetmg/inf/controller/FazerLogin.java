package br.cefetmg.inf.controller;

import br.cefetmg.inf.model.domain.Usuario;
import java.sql.SQLException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import br.cefetmg.inf.model.services.IManterUsuario;
import br.cefetmg.inf.proxy.ManterAlunoProxy;
import br.cefetmg.inf.proxy.ManterInstrutorProxy;
import java.rmi.RemoteException;
import java.util.logging.Level;
import java.util.logging.Logger;

public class FazerLogin extends Controller{

    @Override
    public  String execute(HttpServletRequest request) {
        String jsp = "";
        HttpSession sessao = request.getSession();
        try {

            String cpf =  request.getParameter("cpf").replaceAll("[^0-9]", "");
            String senha = request.getParameter("senha");

            IManterUsuario manterAluno = new ManterAlunoProxy();
            IManterUsuario manterInstrutor = new ManterInstrutorProxy();
            Usuario aluno = manterAluno.pesquisarPorCpf(cpf);
            Usuario instrutor = manterInstrutor.pesquisarPorCpf(cpf);
            
            if(aluno != null && aluno.getSenha().equals(senha)){
                sessao.setAttribute("usuario", aluno);
                jsp="TelaInicialAluno";
            }
            else if(instrutor!= null && instrutor.getSenha().equals(senha)){
                sessao.setAttribute("usuario", instrutor);
                jsp="TelaInicialInstrutor";
            }
            else if((aluno != null && !aluno.getSenha().equals(senha)) || 
                    (instrutor!=null && !instrutor.getSenha().equals(senha))){
                String erro = "Senha Incorreta";
                jsp="erro";
                request.setAttribute("erro", erro);
            }
            else{
                String erro="CPF incorreto";
                jsp="erro";
                request.setAttribute("erro", erro);
            }
        }
        catch (SQLException e) {
            e.printStackTrace(System.err);
            String erro = "Erro ao fazer login!";
            request.setAttribute("erro", erro);
            jsp = "erro.jsp";
        } catch (RemoteException ex) {
            Logger.getLogger(FazerLogin.class.getName()).log(Level.SEVERE, null, ex);
        }
        return defineView(request, jsp);
    }
}
