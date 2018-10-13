package br.cefetmg.inf.controller;

import br.cefetmg.inf.model.domain.Exercicio;
import br.cefetmg.inf.model.domain.Musculo;
import br.cefetmg.inf.model.services.IManterExercicio;
import br.cefetmg.inf.model.services.IManterMusculo;
import br.cefetmg.inf.proxy.ManterExercicioProxy;
import br.cefetmg.inf.proxy.ManterMusculoProxy;
import java.sql.SQLException;
import java.util.ArrayList;
import javax.servlet.http.HttpServletRequest;

public class CadastrarExercicio extends Controller {

    @Override
    public String execute(HttpServletRequest request) {
        String jsp = "TelaInicialInstrutor";

        try {
            IManterExercicio manterExercicio = new ManterExercicioProxy();
            IManterMusculo manterMusculo = new ManterMusculoProxy();
            
            String nomeExercicio = request.getParameter("nomeExercicio");
            String descricaoExercicio = request.getParameter("descExercicio");

            String[] codAparelhos = request.getParameterValues("aparelhos");
            String[] codMusculos = request.getParameterValues("musculos");
            
            ArrayList<Musculo> listaMusculos = new ArrayList<>();
            
            for(String codMusculo : codMusculos){
                listaMusculos.add(manterMusculo.pesquisarPorCodigo(Integer.parseInt(codMusculo)));
            }
            
            Exercicio exercicio = new Exercicio(0, nomeExercicio, descricaoExercicio, listaMusculos);
            
            manterExercicio.cadastrar(exercicio);

            exercicio = manterExercicio.pesquisarPorNome(nomeExercicio);

            for (String codAparelho : codAparelhos) {
                manterExercicio.cadastrarAparelhoExercicio(exercicio.getNumero(), Integer.parseInt(codAparelho), "");
            }

        } catch (SQLException e) {
            e.printStackTrace(System.err);
            String erro = "Erro ao cadastrar exercicio!";
            request.setAttribute("erro", erro);
            jsp = "erro.jsp";
        }
        return defineView(request, jsp);
    }
}