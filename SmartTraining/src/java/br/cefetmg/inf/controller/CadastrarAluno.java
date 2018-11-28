package br.cefetmg.inf.controller;

import br.cefetmg.inf.model.domain.Usuario;
import java.sql.SQLException;
import java.time.LocalDate;
import javax.servlet.http.HttpServletRequest;
import br.cefetmg.inf.model.services.IManterUsuario;
import br.cefetmg.inf.proxy.ManterAlunoProxy;
import com.google.gson.Gson;
import java.io.BufferedReader;
import java.io.IOException;
import java.rmi.RemoteException;
import java.util.logging.Level;
import java.util.logging.Logger;

public class CadastrarAluno extends Controller {

    @Override
    public String execute(HttpServletRequest request) {
        String jsp = "/LoginUsuario";
        if (request.getAttribute("tipoView").equals("json")) {
            try {
                BufferedReader leitor = request.getReader();
                Gson gson = new Gson();
                Usuario aluno = gson.fromJson(leitor.readLine(), Usuario.class);
                IManterUsuario manterAluno = new ManterAlunoProxy();
                manterAluno.cadastrar(aluno);
                request.setAttribute("resposta", "Sucesso!");
                jsp = "resposta";
            } catch (IOException ex) {
                ex.printStackTrace(System.err);
                String erro = "Erro no recebimento dos dados do aluno!";
                request.setAttribute("erro", erro);
                jsp = "erro";

            } catch (SQLException ex) {
                ex.printStackTrace(System.err);
                String erro = "Erro ao cadastrar o aluno!";
                request.setAttribute("erro", erro);
                jsp = "erro";

            }
        } else {
            try {
                String cpf = request.getParameter("cpf").replaceAll("[^0-9]", "");
                String nome = request.getParameter("nome");
                char idtTipoUsuario = 'A';
                String senha = request.getParameter("senha");
                String email = request.getParameter("email");
                LocalDate nascimento = LocalDate.parse(request.getParameter("datNasc"));

                Usuario aluno = new Usuario();

                aluno.setCpf(cpf);
                aluno.setNome(nome);
                aluno.setTipo(idtTipoUsuario);
                aluno.setSenha(senha);
                aluno.setEmail(email);
                aluno.setDataNascimento(nascimento);

                IManterUsuario manterAluno = new ManterAlunoProxy();
                manterAluno.cadastrar(aluno);
            } catch (SQLException e) {
                e.printStackTrace(System.err);
                String erro = "Erro ao cadastrar aluno!";
                request.setAttribute("erro", erro);
                jsp = "erro.jsp";
            } catch (RemoteException ex) {
                Logger.getLogger(CadastrarAluno.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        return defineView(request, jsp);
    }
}
