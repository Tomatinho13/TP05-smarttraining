package br.cefetmg.inf.controller;

import br.cefetmg.inf.model.domain.Atividade;
import br.cefetmg.inf.model.domain.DiaTreino;
import br.cefetmg.inf.model.services.IManterDiaTreino;
import br.cefetmg.inf.proxy.ManterDiaTreinoProxy;
import com.google.gson.Gson;
import java.io.BufferedReader;
import java.io.IOException;
import java.sql.SQLException;
import java.time.LocalDate;
import javax.servlet.http.HttpServletRequest;

public class CadastrarDiaTreino extends Controller {

    @Override
    public String execute(HttpServletRequest request) {
        String jsp = "/resposta";
        if (request.getAttribute("tipoView").equals("json")) {
            try {
                BufferedReader leitor = request.getReader();
                Gson gson = new Gson();

                Atividade atividade = gson.fromJson(leitor.readLine(), Atividade.class);
                DiaTreino diaTreino = new DiaTreino(atividade, LocalDate.now());

                IManterDiaTreino manterDiaTreino = new ManterDiaTreinoProxy();
                manterDiaTreino.cadastrar(diaTreino);
                request.setAttribute("resposta", "Sucesso!");
            } catch (IOException ex) {
                ex.printStackTrace(System.err);
                String erro = "Erro no recebimento dos dados do treino!";
                request.setAttribute("erro", erro);
                jsp = "erro";
            } catch (SQLException ex) {
                ex.printStackTrace(System.err);
                String erro = "Erro ao cadastrar o dia de treino!";
                request.setAttribute("erro", erro);
                jsp = "erro";

            }
        } else {
            jsp = "erro.jsp";
            return jsp;
        }
        return defineView(request, jsp);
    }
}
