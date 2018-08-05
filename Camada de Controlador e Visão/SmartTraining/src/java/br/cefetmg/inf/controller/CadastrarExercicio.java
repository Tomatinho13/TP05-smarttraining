package br.cefetmg.inf.controller;

import br.cefetmg.inf.model.domain.Aparelho;
import br.cefetmg.inf.model.domain.Exercicio;
import br.cefetmg.inf.model.services.IManterAparelho;
import br.cefetmg.inf.model.services.IManterExercicio;
import br.cefetmg.inf.model.services.impl.ManterAparelho;
import br.cefetmg.inf.model.services.impl.ManterExercicio;
import java.sql.SQLException;
import java.time.LocalDate;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.http.HttpServletRequest;

public class CadastrarExercicio {
    public static String execute(HttpServletRequest request) throws SQLException {
        String jsp = "";
        
        String nomeExercicio = request.getParameter("nomeExercicio");
        String descricaoExercicio = request.getParameter("descExercicio");
        
        String nomeAparelho = request.getParameter("nomeAparelho");
        IManterAparelho manterAparelho = new ManterAparelho();
        Aparelho aparelho = manterAparelho.pesquisar(nomeAparelho);
        int numeroAparelho = aparelho.getNroAparelho();
        
        IManterExercicio manterExercicio = new ManterExercicio();
        Exercicio exercicio = new Exercicio();

        exercicio.setCodExercicio();
        exercicio.setDescricaoExercicio(descricaoExercicio);
        exercicio.setNomeExercicio(nomeExercicio);
        
        try {
            manterExercicio.cadastrar(exercicio);
        } catch (SQLException ex) {
            Logger.getLogger(CadastrarAluno.class.getName()).log(Level.SEVERE, null, ex);
        }
        jsp = "/LoginUsuario.jsp";
        return jsp;
    }
}

