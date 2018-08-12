package br.cefetmg.inf.controller;

import br.cefetmg.inf.model.domain.Instrutor;
import br.cefetmg.inf.model.services.IManterInstrutor;
import br.cefetmg.inf.model.services.impl.ManterInstrutor;
import java.sql.SQLException;
import java.time.LocalDate;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.http.HttpServletRequest;

public class CadastrarInstrutor implements Controller{
    
     @Override
     public String execute(HttpServletRequest request) {
        String jsp;
        String cpf =  request.getParameter("cpf");
        String nome = request.getParameter("nome");
        char idtTipoUsuario = 'I';
        String senha = request.getParameter("senha");
        String email = request.getParameter("email");
        LocalDate dataNascimento = LocalDate.parse(request.getParameter("datNasc"));
        String cref = request.getParameter("cref");

        Instrutor instrutor = new Instrutor();
        IManterInstrutor manterInstrutor = new ManterInstrutor();
        
        instrutor.setCodCpf(cpf);
        instrutor.setNomUsuario(nome);
        instrutor.setIdtTipoUsuario(idtTipoUsuario);
        instrutor.setTxtSenha(senha);
        instrutor.setDesEmail(email);
        instrutor.setDatNascimento(dataNascimento);
        instrutor.setCodCREF(cref);

        try {
            manterInstrutor.cadastrar(instrutor);
        } catch (SQLException ex) {
            Logger.getLogger(CadastrarInstrutor.class.getName()).log(Level.SEVERE, null, ex);
        }
        jsp = "/LoginUsuario.jsp";
        return jsp;
    }
}
