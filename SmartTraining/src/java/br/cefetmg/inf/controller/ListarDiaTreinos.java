package br.cefetmg.inf.controller;

import br.cefetmg.inf.model.domain.DiaTreino;
import br.cefetmg.inf.model.services.IManterDiaTreino;
import br.cefetmg.inf.model.services.impl.ManterDiaTreino;
import java.sql.SQLException;
import java.util.ArrayList;
import javax.servlet.http.HttpServletRequest;

public class ListarDiaTreinos extends Controller {

    @Override
    public String execute(HttpServletRequest request) {
        String jsp;

        try {
            IManterDiaTreino manterDiaTreino = new ManterDiaTreino();
            
            String codCpf = request.getParameter("codCpf");
            String nroFicha = request.getParameter("nroFicha");
            ArrayList<DiaTreino> listaDiaTreinos = manterDiaTreino.pesquisarTodos(codCpf, nroFicha);

            if (listaDiaTreinos != null) {
                request.setAttribute("diaTreinos", listaDiaTreinos);
                jsp = "/ListaDiaTreinos";
            } else {
                String erro = "Nao existem dias de treino registrados no banco de dados!";
                request.setAttribute("erro", erro);
                jsp = "/erro";
            }

        } catch (SQLException e) {
            e.printStackTrace(System.err);
            String erro = "Erro ao listar dias de treino!";
            request.setAttribute("erro", erro);
            jsp = "erro.jsp";
        }
        return defineView(request, jsp);
    }
}
