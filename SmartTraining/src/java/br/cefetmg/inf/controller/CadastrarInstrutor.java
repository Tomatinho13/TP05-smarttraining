package br.cefetmg.inf.controller;

import br.cefetmg.inf.model.domain.Instrutor;
import java.sql.SQLException;
import java.time.LocalDate;
import javax.servlet.http.HttpServletRequest;
import br.cefetmg.inf.model.services.IManterUsuario;
import br.cefetmg.inf.proxy.ManterInstrutorProxy;

public class CadastrarInstrutor extends Controller {

    @Override
    public String execute(HttpServletRequest request) {
        String jsp = "/LoginUsuario";

        try {
            String cpf = request.getParameter("cpf").replaceAll("[^0-9]", "");
            String nome = request.getParameter("nome");
            char idtTipoUsuario = 'I';
            String senha = request.getParameter("senha");
            String email = request.getParameter("email");
            LocalDate dataNascimento = LocalDate.parse(request.getParameter("datNasc"));
            String cref = request.getParameter("cref");

            Instrutor instrutor = new Instrutor();
            IManterUsuario manterInstrutor = new ManterInstrutorProxy();

            instrutor.setCpf(cpf);
            instrutor.setNome(nome);
            instrutor.setTipo(idtTipoUsuario);
            instrutor.setSenha(senha);
            instrutor.setEmail(email);
            instrutor.setDataNascimento(dataNascimento);
            instrutor.setNroCref(cref);

            manterInstrutor.cadastrar(instrutor);
        } catch (SQLException e) {
            e.printStackTrace(System.err);
            String erro = "Erro ao cadastrar instrutor!";
            request.setAttribute("erro", erro);
            jsp = "erro.jsp";
        }
        return defineView(request, jsp);
    }
}
