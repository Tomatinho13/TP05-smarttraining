package br.cefetmg.inf.controller;

import br.cefetmg.inf.model.domain.Exercicio;
import br.cefetmg.inf.model.domain.Musculo;
import br.cefetmg.inf.model.services.IManterExercicio;
import br.cefetmg.inf.model.services.IManterMusculo;
import br.cefetmg.inf.model.services.impl.ManterExercicio;
import br.cefetmg.inf.model.services.impl.ManterMusculo;
import com.google.gson.Gson;
import java.io.BufferedReader;
import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;
import javax.servlet.http.HttpServletRequest;

public class CadastrarExercicio extends Controller {

    @Override
    public String execute(HttpServletRequest request) {
        String jsp = "TelaInicialInstrutor";
        if (request.getAttribute("tipoView").equals("json")) {
            BufferedReader leitor;
            try {
                leitor = request.getReader();
                
                Gson gson = new Gson();
                IManterExercicio manterExercicio = new ManterExercicio();
                
                Exercicio exercicio = gson.fromJson(leitor.readLine(), Exercicio.class);
                
                manterExercicio.cadastrar(exercicio);
                request.setAttribute("resposta", "Sucesso!");
                jsp = "resposta";
                
            } catch (IOException | SQLException ex) {
                ex.printStackTrace(System.err);
                String erro = "Erro ao cadastrar exercicio!";
                request.setAttribute("erro", erro);
                jsp = "erro.jsp";
            }
        } else {
            try {
                IManterExercicio manterExercicio = new ManterExercicio();
                IManterMusculo manterMusculo = new ManterMusculo();

                String nomeExercicio = request.getParameter("nomeExercicio");
                String descricaoExercicio = request.getParameter("descExercicio");

                String[] codAparelhos = request.getParameterValues("aparelhos");
                String[] codMusculos = request.getParameterValues("musculos");

                ArrayList<Musculo> listaMusculos = new ArrayList<>();

                for (String codMusculo : codMusculos) {
                    listaMusculos.add(manterMusculo.pesquisarPorCodigo(Integer.parseInt(codMusculo)));
                }

                Exercicio exercicio = new Exercicio(0, nomeExercicio, descricaoExercicio, listaMusculos);

                manterExercicio.cadastrar(exercicio);

                exercicio = manterExercicio.pesquisarPorNome(nomeExercicio);

                for (String codAparelho : codAparelhos) {
                    manterExercicio.cadastrarAparelhoExercicio(exercicio.getNumero(), Integer.parseInt(codAparelho), "");
                }

            } catch (SQLException ex) {
                ex.printStackTrace(System.err);
                String erro = "Erro ao cadastrar exercicio!";
                request.setAttribute("erro", erro);
                jsp = "erro.jsp";
            }
        }
        return defineView(request, jsp);
    }
}
